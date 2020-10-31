/**
 * Defines characteristics of a game period.
 * @author Konnor Sommer
 */
public class Period {
    /**
     * Current period
     */
    private int period;
    /**
     * Length of period in minutes
     */
    private final int length;
    /**
     * Name of period.
     */
    private final String name;
    /**
     * Number of periods
     */
    private final int numPeriods;
    /**
     * Constructs the type of period for this game
     * @param period current period
     * @param length length in minutes
     * @param name name of period
     * @param numPeriods number of periods in a game
     */
    Period(int period,int length,String name,int numPeriods){
        this.period = period;
        this.length = length;
        this.name = name;
        this.numPeriods = numPeriods;
    }

    /**
     * Sets the current period
     * @param p current period
     */
    public void setPeriod(int p){
        period = p;
    }

    /**
     * Returns the current period.
     * @return current period
     */
    public int getPeriod(){
        return period;
    }

    /**
     * Returns the length of a period.
     * @return length of period
     */
    public int getLength(){
        return length;
    }

    /**
     * Returns the name of a period.
     * @return name of period
     */
    public String getName(){
        return name;
    }

    /**
     * Return number of periods
     * @return number of periods
     */
    public int getNumPeriods(){
        return numPeriods;
    }
}
