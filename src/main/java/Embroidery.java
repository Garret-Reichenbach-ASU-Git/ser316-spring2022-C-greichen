public class Embroidery {
    final static double pricePerLetter = 1.00;
    double price;
    String embroidText;

    public Embroidery (String embroidery) {
        this.embroidText = embroidery;
        this.price = embroidery.length() * pricePerLetter;
    }
}
