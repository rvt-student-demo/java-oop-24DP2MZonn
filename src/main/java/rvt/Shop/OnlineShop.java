package rvt.Shop;
    import java.util.Map;
import java.util.Set;
import java.util.HashMap;
public class OnlineShop {
    public class Warehouse {
        private Map<String, Integer> collection = new HashMap<>();
        private Map<String, Integer> prices = new HashMap<>();
    

        public void addProduct(String product, int price, int stock){
            this.collection.put(product, stock);
            this.prices.put(product, price);
            
        }
        public int price(String product){
            if (this.prices.containsKey(product)) {
                return this.prices.get(product);
            }
            return -99;
        }
        public int stock(String product){
            if (this.collection.containsKey(product)) {
                return this.collection.get(product);
            }
            return 0;
        }
        public boolean take(String product){
            if(this.collection.containsKey(product) && this.collection.get(product) > 0){
                this.collection.put(product, this.collection.get(product) - 1);
                return true;
            }
            return false;
        }
        public Set<String> products(){
            return this.collection.keySet();
        }
    }
    public class Item{
        private String product;
        private int qty;
        private int unitPrice;

        public Item(String product, int qty, int unitPrice){
            this.product = product;
            this.qty = qty;
            this.unitPrice = unitPrice;
        }
        public int price(){
            return this.qty * this.unitPrice;
        }
        public void increaseQuantity(){
            this.qty++;
        }
        public String toString(){
            return this.product + ": " + this.qty;
        }
    }
    public class ShoppingCart{
        private Map<String, Item> cart = new HashMap<>();

        public ShoppingCart(){
        }
        public void add(String product, int price){
            if(this.cart.containsKey(product)){
                this.cart.get(product).increaseQuantity();
            }
        }
    }
    public static void main(String[] args) {
        OnlineShop shop = new OnlineShop();
        Item item = shop.new Item("milk", 4, 2);
        
        System.out.println("an item that contains 4 milks has the total price of " + item.price());
        System.out.println(item);
        item.increaseQuantity();
        System.out.println(item);
    }
}
