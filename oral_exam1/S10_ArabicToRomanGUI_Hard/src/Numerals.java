/**
 * Enumerates Roman numerals with their values.
 * @author Konnor Sommer
 */

public enum Numerals {
    M(1000),
    CM(900),
    D(500),
    CD(400),
    C(100),
    XC(90),
    L(50),
    XL(40),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);
    /**
     * Variable which stores the Arabic value of a Roman numeral.
     */
    private final int num;

    /**
     * Sets the Arabic value of a Roman numeral.
     * @param num
     */
    Numerals(int num) {
        this.num = num;
    }

    /**
     * Reterns the Arabic value for this numeral.
     * @return num The arabic value
     */
    public int getNum(){
        return num;
    }
}

