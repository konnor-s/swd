import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
/**
 * Junit test class to test method getEaster/Computus algorithm.
 * Tests that the getEaster method is returning the correct Easter date for a given year.
 * By extension is testing the Computus algorithm implemented in the Computus class constructor.
 * Tests with known Easter dates from census.gov.
 * Easter date source: <a href="https://www.census.gov/srd/www/genhol/easter500.html">link</a>.
 */

public class ComputusJunitTest {
    private Computus testDate;
    @ParameterizedTest
    //Dates are all in format yearmonthday to match getEaster() method return. Years starting at 1600 and incrementing by 25.
    @ValueSource (longs={16000402,16250330,16500417,16750414,17000411,17250401,//Values taken from census.gov
            17500329,17750416,18000413,18250403,18500331,18750328,19000415,19250412,
            19500409,19750330,20000423,20250420,20500410,20750407})
    void testgetEaster(long i){
        testDate= new Computus((int)(i/10000));//instantiate Computus object with just the year.
        assertEquals(i,testDate.getEaster());
    }
}
