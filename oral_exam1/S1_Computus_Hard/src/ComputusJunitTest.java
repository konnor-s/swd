import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
/**
 * Junit test class to test method getEaster.
 * Tests with known Easter dates from census.gov.
 * Easter date source: <a href="https://www.census.gov/srd/www/genhol/easter500.html">link</a>.
 *

 */

public class ComputusJunitTest {
    private Computus testDate;
    @ParameterizedTest
    @ValueSource (longs={16000402,16250330,16500417,16750414,17000411,17250401,
            17500329,17750416,18000413,18250403,18500331,18750328,19000415,19250412,
            19500409,19750330,20000423,20250420,20500410,20750407})
    void testgetEaster(long i){
        testDate= new Computus((int)(i/10000));
        assertEquals(i,testDate.getEaster());
    }
}
