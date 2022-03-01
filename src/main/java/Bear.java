package main.java;

import main.java.Stuffing.stuffing;
import java.util.LinkedList;

public class Bear implements Comparable<Bear>{
    private main.java.Casing casing;
    private main.java.Stuffing stuff;
    private main.java.Embroidery ink;
    private LinkedList<main.java.NoiseMaker> noisemakers; // accessory
    private LinkedList<main.java.Clothing> clothing; // accessory
    private double price;
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

    public main.java.Casing getCasing() {
        return casing;
    }

    public void setCasing(main.java.Casing casing) {
        this.casing = casing;
    }

    public main.java.Stuffing getStuff() {
        return stuff;
    }

    public void setStuff(main.java.Stuffing stuff) {
        this.stuff = stuff;
    }

    public main.java.Embroidery getInk() {
        return ink;
    }

    public void setInk(main.java.Embroidery ink) {
        this.ink = ink;
    }

    public LinkedList<main.java.NoiseMaker> getNoisemakers() {
        return noisemakers;
    }

    public void setNoisemakers(LinkedList<main.java.NoiseMaker> noisemakers) {
        this.noisemakers = noisemakers;
    }

    public LinkedList<main.java.Clothing> getClothing() {
        return clothing;
    }

    public void setClothing(LinkedList<main.java.Clothing> clothing) {
        this.clothing = clothing;
    }

    public double getPrice() {
        return price;
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