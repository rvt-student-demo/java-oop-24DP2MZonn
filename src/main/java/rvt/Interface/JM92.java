package rvt.Interface;

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
        public static class Box implements Packable{
            private double weight;
            private Packable[] items;

            public Box(double weight, Packable... items) {
                this.items = items;
            }

            @Override
            public double weight() {
                double totalWeight = 0;
                for (Packable item : items) {
                    totalWeight += item.weight();
                }
                return totalWeight;
        }
        
    }
    public static void main(String[] args) {
       
        }
    
    }
}