import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/***
 * This class provides a framework to implement black box tests for various
 * implementations of the BearWorkshop Class. The BearWorkshop is having a
 * blowout sale and is offering the following savings.
 */
@RunWith(Parameterized.class)
public class GivenBlackBox {
    private Class<BearWorkshop> classUnderTest;

    @SuppressWarnings("unchecked")
    public GivenBlackBox(Object classUnderTest) {
        this.classUnderTest = (Class<BearWorkshop>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = {
                {main.java.BearWorkshop1.class},
                {main.java.BearWorkshop2.class},
                {main.java.BearWorkshop3.class},
                {main.java.BearWorkshop4.class},
                {main.java.BearWorkshop5.class}

        };
        return Arrays.asList(classes);
    }

    private BearWorkshop createBearWorkshop(String name) throws Exception {
        Constructor<BearWorkshop> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }

    BearWorkshop oneBear;
    Double oneBearExpected;

    BearWorkshop threeBears;
    Double threeBearsExpected;

    BearWorkshop twoBears;
    Double twoBearsExpected;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    /*
    @Test
    public void oneBearNoSavings() {
    	// One Bear base stuffing, no saving expected
        
        BearWorkshop oneBear = null;
        try {
        	oneBear = createBearWorkshop("NY");
        } catch (Exception e) {
        }
        
        oneBear.addBear(new Bear(Stuffing.stuffing.BASE)); // $30 stuffing + $1 casing -- should be no savings at all
        oneBearExpected = 0.00; // no savings since no clothing
    	
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

	    customBear.clothing.add(new Clothing(4, "Hat")); //$35
	    customBear.clothing.add(new Clothing(4, "Sunglasses")); //$39
	    customBear.clothing.add(new Clothing(4, "Shoes")); // free
	    
        Double bearsExpected = 4.0; // one cloth item for free
        Double ans = bears.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    */

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

        bear1.clothing.add(new Clothing(5, "Cowboy Hat"));
        bear1.clothing.add(new Clothing(5, "Fedora Hat"));
        bear1.clothing.add(new Clothing(5, "Baseball Hat"));
        bear1.clothing.add(new Clothing(5, "Straw Hat"));
        bear1.clothing.add(new Clothing(5, "Top Hat"));
        bear1.clothing.add(new Clothing(5, "Yellow Hat"));
        bear1.clothing.add(new Clothing(5, "Tall Hat"));
        bear1.clothing.add(new Clothing(5, "Upside-down Hat"));
        bear1.clothing.add(new Clothing(5, "Yankee with no brim Hat"));
        bear1.clothing.add(new Clothing(5, "Flower Hat"));
        bear1.clothing.add(new Clothing(5, "Hypercube Hat"));
        bear1.clothing.add(new Clothing(5, "Gentlemen's Hat"));
        bear1.clothing.add(new Clothing(5, "Invisible Hat"));
        bear1.clothing.add(new Clothing(5, "Old Hat"));

        assertEquals(28.1, workshop.calculateSavings(), 0.005);
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

        bear1.clothing.add(new Clothing(-5, "Impossible hat"));
        bear1.clothing.add(new Clothing(0, "\0"));

        assertEquals(0, workshop.calculateSavings(), 0);
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

        bear1.noisemakers.add(new NoiseMaker("Demonic Screeching", "unintelligible loud noises", NoiseMaker.Location.CENTERBODY));
        bear1.noisemakers.add(new NoiseMaker("Horrible Yelling", "unintelligible loud noises", NoiseMaker.Location.CENTERBODY));

        assertEquals(0, workshop.calculateSavings(), 0);
    }
}
