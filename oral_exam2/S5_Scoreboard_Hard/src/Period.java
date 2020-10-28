public class Period {
    private int period;
    private final int length;
    private final String name;
    private final int numPeriods;
    Period(int period,int length,String name,int numPeriods){
        this.period = period;
        this.length = length;
        this.name = name;
        this.numPeriods = numPeriods;
    }
    public void setPeriod(int p){
        period = p;
    }
    public int getPeriod(){
        return period;
    }
    public int getLength(){
        return length;
    }
    public String getName(){
        return name;
    }
    public int getNumPeriods(){
        return numPeriods;
    }
}
