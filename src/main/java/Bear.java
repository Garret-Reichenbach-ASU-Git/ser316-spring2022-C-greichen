package main.java;

import main.java.Stuffing.stuffing;
import java.util.LinkedList;

public class Bear implements Comparable<Bear>{
    public main.java.Casing casing;
    public main.java.Stuffing stuff;
    public main.java.Embroidery ink;
    public LinkedList<main.java.NoiseMaker> noisemakers; // accessory
    public LinkedList<main.java.Clothing> clothing; // accessory
    public double price;
    // bear has a shell (requ)
    // bear has stuffing (req)
    // bear has a tattoo/emroider or not (opt)
    // bear has a noisemaker (opt)


    public Bear() {
        this.casing = new main.java.Casing();
        this.stuff = new main.java.Stuffing(stuffing.BASE);
        noisemakers = new LinkedList<>();
        clothing = new LinkedList<>();
        ink = new main.java.Embroidery("");
        price = 0;
    }

    public Bear(stuffing stuff) {
        this.casing = new main.java.Casing();
        this.stuff = new main.java.Stuffing(stuff);
        noisemakers = new LinkedList<>();
        clothing = new LinkedList<>();
        ink = new main.java.Embroidery("");
        price = 0;
    }

    public void setPrice(double incomingPrice) {
        this.price = incomingPrice;
    }

    public boolean addNoise(main.java.NoiseMaker noise) {
        if (this.noisemakers.size() >= 5) {
            return false;
        } else {
            for (main.java.NoiseMaker noisemaker: noisemakers) {
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
        return new Double(this.price).compareTo(bear.price);
    }
}