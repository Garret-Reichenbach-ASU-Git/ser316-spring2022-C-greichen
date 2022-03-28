public class Clothing implements Comparable<Clothing> {
    public double price;
    public String description;

    //  you can assume that the price of $4 per clothing item is correct
    public Clothing() {
        this(4.00, "Generic Offtrack Separate");

    }

    public Clothing(double price, String descr) {
        this.price = price;
        this.description = descr;
    }

    public int compareTo(Clothing clothes) {
        return Double.compare(clothes.price, this.price);
    }
}
