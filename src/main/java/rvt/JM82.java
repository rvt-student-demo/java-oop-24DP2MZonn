package rvt;

import java.util.HashMap;
public class JM82{
    public static class IOU {
        private HashMap<String, Double> debts;

        public IOU() {
        this.debts = new HashMap<>();
        }

        public void setSum(String toWhom, double amount) {
        this.debts.put(toWhom, amount);
        }

        public double howMuchDoIOweTo(String toWhom) {
            if (this.debts.containsKey(toWhom)) {
                return this.debts.get(toWhom);
            }

            return 0;
        }
    
    }
    public static void main(String[] args) {
        IOU mattsIOU = new IOU();
        mattsIOU.setSum("Arthur", 51.5);
        mattsIOU.setSum("Arthur", 10.5);

        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
    }
}