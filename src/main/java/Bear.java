import java.util.LinkedList;

public class Bear implements Comparable<Bear> {

    public Casing casing;
    public Stuffing stuff;
    public Embroidery ink;
    public LinkedList<NoiseMaker> noisemakers; // accessory
    public LinkedList<Clothing> clothing; // accessory
    public double price;
    // bear has a shell (requ)
    // bear has StuffingType (req)
    // bear has a tattoo/emroider or not (opt)
    // bear has a noisemaker (opt)

    public Bear() {
        this.casing = new Casing();
        this.stuff = new Stuffing(Stuffing.StuffingType.BASE);
        noisemakers = new LinkedList<>();
        clothing = new LinkedList<>();
        ink = new Embroidery("");
        price = 0;
    }

    public Bear(Stuffing.StuffingType stuff) {
        this.casing = new Casing();
        this.stuff = new Stuffing(stuff);
        noisemakers = new LinkedList<>();
        clothing = new LinkedList<>();
        ink = new Embroidery("");
        price = 0;
    }

    public void setPrice(double incomingPrice) {
        this.price = incomingPrice;
    }

    public boolean addNoise(NoiseMaker noise) {
        if (this.noisemakers.size() >= 5) {
            return false;
        } else {
            for (NoiseMaker noisemaker : noisemakers) {
                if (noise.spot == noisemaker.spot) {
                    return false;
                }
            }
            noisemakers.add(noise);
            return true;
        }
    }

    @Override
    public int compareTo(Bear bear) {
        return Double.compare(this.price, bear.price);
    }
}