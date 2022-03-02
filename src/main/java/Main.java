package main.java;

import main.java.Stuffing.stuffing;

public class Main {
    
    public static void main(String[] args) {
        //Fill me in!
    	
        main.java.Bear bear1 = new main.java.Bear(stuffing.FOAM);
        main.java.Bear bear2 = new main.java.Bear(stuffing.BASE);
        main.java.Bear bear3 = new main.java.Bear(stuffing.DOWN);
        
        main.java.BearWorkshop workshop = new main.java.BearWorkshop("AZ");
        workshop.addBear(bear2);
        workshop.addBear(bear3);
        workshop.addBear(bear1);
        
        System.out.println(bear1.getPrice());
        
        System.out.println(workshop.getCost(bear2));
        System.out.println(bear2.getPrice());
        
        System.out.println(workshop.getCost(bear3));
        System.out.println(bear3.getPrice());
        
        bear1.getClothing().add(new main.java.Clothing());
        
        System.out.println("Bear with NO clothing object");
        System.out.println(bear1.getPrice());
        
        System.out.println("Bear with one clothing object");
        System.out.println(workshop.getRawCost(bear1));
        
        bear1.getClothing().add(new main.java.Clothing(5, "Cool sunglasses"));
        System.out.println("Bear with two clothing object");
        System.out.println(workshop.getRawCost(bear1));
    }
}
