package rvt.Interface;

import java.util.ArrayList;
import java.util.List;

public class JM92 {
    public interface Packable {
        double weight();
    }
    public static class Book implements Packable {
        private double weight;
        private String author;
        private String Bookname;

        public Book(String author,String bookname, double weight) {
            this.author = author;
            this.weight = weight;
            this.Bookname = bookname;   
            
        }

        @Override
        public double weight() {
            return this.weight;
        }
        public String toString() {
            return author + ": " + Bookname + " (" + weight + " kg)";
        }
    }
    public static class CD implements Packable {
        private double weight;
        private String artist;
        private int publicationYear;
        private String CDname;

        public CD( String artist, String CDname, int publicationYear) {
            this.publicationYear = publicationYear;
            this.artist = artist;
            this.CDname = CDname;
        }

        @Override
        public double weight() {
            return this.weight;
        }
        public String toString() {
            return artist + ": " + CDname + " (" + publicationYear + ")";
        }
    }
        public static class Box implements Packable{
            private double maxWeight;
            private List<Packable> items;

            public Box(double maxWeight) {
                this.maxWeight = maxWeight;
                this.items = new ArrayList<>();
            }
            public void add(Packable item) {
                if (this.weight() + item.weight() <= maxWeight) {
                    items.add(item);
                }
            }

            @Override
            public double weight() {
                double totalWeight = 0;
                for (Packable item : items) {
                    totalWeight += item.weight();
                }
                return totalWeight;
            }
            @Override
            public String toString() {
                return "Box: " + items.size() + " items, total weight " + weight() + " kg";
            }

           
        }
    
        
    public static void main(String[] args) { 
        Box smallBox = new Box(5);
        smallBox.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 2));
        smallBox.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        
        Box mediumBox = new Box(8);
        mediumBox.add(new Book("Robert Martin", "Clean Code", 1));
        mediumBox.add(smallBox);
        
        Box bigBox = new Box(15);
        bigBox.add(new Book("Kent Beck", "Test Driven Development", 0.7));
        bigBox.add(mediumBox);
        
        System.out.println(bigBox);
        
            
        bigBox.add(bigBox);
        System.out.println(bigBox);
        
    
    }
}