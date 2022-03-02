import main.java.Bear;
import main.java.BearWorkshop;
import main.java.Clothing;
import main.java.Stuffing;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * <Description>
 *
 * @author Garret Reichenbach
 * @version 1.0 - [03/01/2022]
 */
public class CalculateSavingsTest {

	BearWorkshop oneBear;
	Double oneBearExpected;

	BearWorkshop threeBears;
	Double threeBearsExpected;

	BearWorkshop twoBears;
	Double twoBearsExpected;

	private BearWorkshop createBearWorkshop(String name) throws Exception {
		return new BearWorkshop(name);
	}

	@Test
    public void oneBearNoSavings() {
    	// One Bear base stuffing, no saving expected

        BearWorkshop oneBear = null;
        try {
        	oneBear = createBearWorkshop("NY");
        } catch (Exception e) {
        }

        oneBear.addBear(new Bear(Stuffing.stuffing.BASE)); // $30 stuffing + $1 casing -- should be no savings at all
        oneBearExpected = 31.0; // no savings since no clothing

        Double ans = oneBear.calculateSavings();
        assertEquals(oneBearExpected, ans);
    }

    @Test
    public void threeBearsSaveOnCheapest() {
    	 // Three Bears expected to not pay for cheapest one
    	BearWorkshop threeBears = null;
        try {
        	threeBears = createBearWorkshop("AZ");
        } catch (Exception e) {
        }

        threeBears.addBear(new Bear(Stuffing.stuffing.BASE)); // this is the cheapest one
        threeBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        threeBears.addBear(new Bear(Stuffing.stuffing.FOAM));
        threeBearsExpected = 31.00;

        Double ans = threeBears.calculateSavings();
        assertEquals(threeBearsExpected, ans);
    }

    @Test
    public void oneBearTest3clothings() {
        BearWorkshop bears = null;
        try {
            bears = createBearWorkshop("DC");
        } catch (Exception e) {
        }

        Bear customBear = new Bear(Stuffing.stuffing.BASE); // $31
        bears.addBear(customBear);

	    customBear.getClothing().add(new Clothing(4, "Hat")); //$35
	    customBear.getClothing().add(new Clothing(4, "Sunglasses")); //$39
	    customBear.getClothing().add(new Clothing(4, "Shoes")); // free

        Double bearsExpected = 43.0; // one cloth item for free
        Double ans = bears.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }

	/**
	 * Test #1
	 * Put as many hats as I could come up with on the bear.
	 */
	@Test
	public void test1() {
		BearWorkshop workshop = null;
		try {
			workshop = createBearWorkshop("AZ");
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		Bear bear1 = new Bear(Stuffing.stuffing.BASE);
		workshop.addBear(bear1);

		bear1.getClothing().add(new Clothing(5, "Cowboy Hat"));
		bear1.getClothing().add(new Clothing(5, "Fedora Hat"));
		bear1.getClothing().add(new Clothing(5, "Baseball Hat"));
		bear1.getClothing().add(new Clothing(5, "Straw Hat"));
		bear1.getClothing().add(new Clothing(5, "Top Hat"));
		bear1.getClothing().add(new Clothing(5, "Yellow Hat"));
		bear1.getClothing().add(new Clothing(5, "Tall Hat"));
		bear1.getClothing().add(new Clothing(5, "Upside-down Hat"));
		bear1.getClothing().add(new Clothing(5, "Yankee with no brim Hat"));
		bear1.getClothing().add(new Clothing(5, "Flower Hat"));
		bear1.getClothing().add(new Clothing(5, "Hypercube Hat"));
		bear1.getClothing().add(new Clothing(5, "Gentlemen's Hat"));
		bear1.getClothing().add(new Clothing(5, "Invisible Hat"));
		bear1.getClothing().add(new Clothing(5, "Old Hat"));

		assertEquals(109.1, workshop.calculateSavings(), 0.005);
	}

	/**
	 * Test #2
	 * Test savings calculation with invalid inputs.
	 */
	@Test
	public void test2() {
		BearWorkshop workshop = null;
		try {
			workshop = createBearWorkshop("AZ");
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		Bear bear1 = new Bear(Stuffing.stuffing.BASE);
		workshop.addBear(bear1);

		bear1.getClothing().add(new Clothing(-5, "Impossible hat"));
		bear1.getClothing().add(new Clothing(0, "\0"));

		assertEquals(26.0, workshop.calculateSavings(), 0);
	}

	@Test
	public void test3() {
		BearWorkshop workshop = null;
		try {
			workshop = createBearWorkshop("AZ");
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		Bear bear1 = new Bear(Stuffing.stuffing.BASE);
		workshop.addBear(bear1);

		bear1.getNoisemakers().add(new main.java.NoiseMaker("Demonic Screeching", "unintelligible loud noises", main.java.NoiseMaker.Location.CENTERBODY));
		bear1.getNoisemakers().add(new main.java.NoiseMaker("Horrible Yelling", "unintelligible loud noises", main.java.NoiseMaker.Location.CENTERBODY));

		assertEquals(51.0, workshop.calculateSavings(), 0);
	}
}
