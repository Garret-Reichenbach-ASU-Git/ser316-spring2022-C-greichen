import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// This class provides functionality for a BearWorkshop class.
public class BearWorkshop implements BearWorkshopInterface {

    // Workshop has a collection of bears
    // Workshop has a customer
    Customer customer;
    List<Bear> bearCart;

    /**
     * Default constructor for the Bear Workshop
     */
    public BearWorkshop() {
        this("AZ");
    }

    /**
     * This is a parameterized ctor for a BearWorkshop
     *
     * @param state customer is in
     */
    public BearWorkshop(String state) {
        bearCart = new LinkedList<>();
        customer = new Customer(state);
    }

    /**
     * This is a convenience method to calculate the cost of one bears in the
     * shopping cart for a customer in the BearFactory. It should take the
     * accessory discounts into account correctly.
     *
     * @param bear to get cost of
     * @return double representation of bear cost
     */
    @Override
    public double getCost(Bear bear) {
        Collections.sort(bear.clothing);
        int numFree = bear.clothing.size() / 3;

        for (int i = 0; i < bear.clothing.size(); i++) {
            Clothing clothes = bear.clothing.get(i);
            if (i >= numFree) {
                bear.price += clothes.price;
            }
        }

        for (NoiseMaker noise : bear.noisemakers) {
            bear.price += noise.price;
        }

        if (bear.ink != null) {
            bear.price += bear.ink.price;
        }

        bear.price += bear.stuff.price;
        bear.price += bear.casing.priceModifier;

        return bear.price;
    }

    /**
     * Utility method to add a bear to the BearFactory - so ti the shopping cart.
     *
     * @param bear to add
     * @return true if successful, false otherwise
     */
    @Override
    public boolean addBear(Bear bear) {
        this.bearCart.add(bear);
        return true;
    }

    // Simple means to remove a bear from the shopping cart
    @Override
    public boolean removeBear(Bear bear) {
        return this.bearCart.remove(bear);
    }

    /**
     * This is a function to allow customers to checkout their shopping cart
     * It should return the total cost of they purchase.
     * TODO: Test me and fix me in assignment 3
     */
    @Override
    public double checkout() {
        if (this.customer.age <= 13) {
            if (this.customer.parent.age < 18) {
                System.out.println("Guardian is too young");
            }
            return -1;
        }
        double cost = 0.00;
        for (Bear bear : bearCart) {
            cost = cost + getRawCost(bear);
        }
        double temp = 0;
        for (Bear bear : this.bearCart) {
            temp += getCost(bear);
        }

        // calculate total cost
        for (Bear bear : bearCart) {
            this.getRawCost(bear);
        }

        // calculate adjusted cost
        cost = 0;
        for (Bear bear : this.bearCart) {
            cost += this.getCost(bear);
        }

        int numberOfFreeBearsInBearCart = bearCart.size() / 3;

        for (int count = 0; count <= numberOfFreeBearsInBearCart; ++count) {
            for (Bear bear : bearCart) {
                temp += temp - temp * 2 + bear.price;
            }
        }
        cost = temp;

        return cost * calculateTax();
    }

    /**
     * Utility method to calculate tax for purchases by customers in different
     * states.
     * You can assume these taxes are what we want, so they are not wrong.
     */
    public double calculateTax() {
        double tax;
        switch (customer.state) {
            case "AZ":
                tax = 1.07;
                break;
            case "NY":
                tax = 1.09;
                break;
            case "VA":
                tax = 1.05;
                break;
            case "DC":
                tax = 1.105;
                break;
            case "CA":
                tax = 1.1;
                break;
            default:
                tax = 1.05;
                break;
        }
        return tax;
    }

    // Function to get the raw cost of a bear without any discounts
    // TODO: test me and fix me in assignment 3
    public double getRawCost(Bear bear) {
        for (int i = 0; i < bear.clothing.size(); i++) {
            Clothing clothes = bear.clothing.get(i);
            bear.price += clothes.price;
        }

        for (NoiseMaker noise : bear.noisemakers) {
            bear.price += noise.price;
        }

        if (bear.ink != null) {
            bear.price += bear.ink.price;
        }

        bear.price += bear.stuff.price;
        bear.price += bear.casing.priceModifier;

        double bearPrice = bear.price;
        bear.price = 0;
        return bearPrice;
    }

    public double calculateSavings() {
        double savings = 0;
        double cost = 0;
        double rawCost = 0;

        for (Bear bear : bearCart) {
            rawCost += getRawCost(bear);
            bear.setPrice(0);

            Collections.sort(bear.clothing);
            int numFree = bear.clothing.size() / 3;

            for (int i = bear.clothing.size() - 1; i >= 0; i--) {
                Clothing clothes = bear.clothing.get(i);
                if (i <= bear.clothing.size() - numFree - 1) {
                    bear.setPrice(bear.price + clothes.price);
                }
            }
            for (NoiseMaker noiseMaker : bear.noisemakers) {
                bear.setPrice(bear.price + noiseMaker.price);
            }

            bear.setPrice(bear.price + bear.stuff.price);
            bear.setPrice(bear.price + bear.casing.priceModifier);
            bear.setPrice(bear.price + bear.ink.price);
            double temp = getRawCost(bear);
            if (temp > 70.0D) {
                bear.setPrice(bear.price - bear.ink.price);
            }
            cost += bear.price;
        }

        savings += rawCost - cost;
        Collections.sort(bearCart);
        List<Bear> nonFreeBears = new LinkedList<>();
        int counter = 0;
        double discountedCost = 0.0D;

        for (Bear bear : bearCart) {
            if (counter % 3 == 0) {
                bear.setPrice(0);
                Collections.sort(bear.clothing);
                int numFree = bear.clothing.size() / 3;

                for (int i = bear.clothing.size() - 1; i >= 0; i--) {
                    Clothing clothes = bear.clothing.get(i);
                    if (i <= bear.clothing.size() - numFree - 1) {
                        bear.setPrice(bear.price + clothes.price);
                    }
                }
                for (NoiseMaker noiseMaker : bear.noisemakers) {
                    bear.setPrice(bear.price + noiseMaker.price);
                }

                bear.setPrice(bear.price + bear.stuff.price);
                bear.setPrice(bear.price + bear.casing.priceModifier);
                bear.setPrice(bear.price + bear.ink.price);
                double temp = getRawCost(bear);
                if (temp > 70.0D) {
                    bear.setPrice(bear.price - bear.ink.price);
                }
                discountedCost -= bear.price;
            }

            bear.setPrice(0);
            Collections.sort(bear.clothing);
            int numFree = bear.clothing.size() / 3;

            for (int i = bear.clothing.size() - 1; i >= 0; i--) {
                Clothing clothes = bear.clothing.get(i);
                if (i <= bear.clothing.size() - numFree - 1) {
                    bear.setPrice(bear.price + clothes.price);
                }
            }
            for (NoiseMaker noiseMaker : bear.noisemakers) {
                bear.setPrice(bear.price + noiseMaker.price);
            }

            bear.setPrice(bear.price + bear.stuff.price);
            bear.setPrice(bear.price + bear.casing.priceModifier);
            bear.setPrice(bear.price + bear.ink.price);
            double temp = getRawCost(bear);
            if (temp > 70.0D) {
                bear.setPrice(bear.price - bear.ink.price);
            }
            discountedCost += bear.price;
            nonFreeBears.add(bear);
            counter++;
        }
        savings += cost - discountedCost;
        double accessorySavings = 0.0D;

        for (Bear bear : nonFreeBears) {
            int numOfFreeClothes = bear.clothing.size() / 3;
            int numOfAccessories = bear.clothing.size() - numOfFreeClothes;
            numOfAccessories += bear.clothing.size();
            if (numOfAccessories > 9) {
                bear.setPrice(0);
                Collections.sort(bear.clothing);
                int numFree = bear.clothing.size() / 3;

                for (int i = bear.clothing.size() - 1; i >= 0; i--) {
                    Clothing clothes = bear.clothing.get(i);
                    if (i <= bear.clothing.size() - numFree - 1) {
                        bear.setPrice(bear.price + clothes.price);
                    }
                }
                for (NoiseMaker noiseMaker : bear.noisemakers) {
                    bear.setPrice(bear.price + noiseMaker.price);
                }

                bear.setPrice(bear.price + bear.stuff.price);
                bear.setPrice(bear.price + bear.casing.priceModifier);
                bear.setPrice(bear.price + bear.ink.price);
                double temp = getRawCost(bear);
                if (temp > 70.0D) {
                    bear.setPrice(bear.price - bear.ink.price);
                }
                accessorySavings += bear.price * 0.1;
            }
        }

        return accessorySavings + savings;
    }
}