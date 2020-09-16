public class Computus {
    private int year;
    private int month;
    private int day;

    Computus(int year){
        this.year=year;
        int a=year%19;
        int b=year/100;
        int c=year%100;
        int d=b/4;
        int e=b%4;
        int f=(b+8)/25;
        int g=(b-f+1)/3;
        int h=(19*a+b-d-g+15)%30;
        int i=c/4;
        int k=c%4;
        int l=(32+2*e+2*i-h-k)%7;
        int m=(a+11*h+22*l)/451;
        month=(h+l-7*m+114)/31;
        day=((h+l-7*m+114)%31)+1;
    }
    public int getEaster(){
        return year*10000+month*100+day;
    }
    public void printEaster(){
        System.out.printf("%s%d%s%d%s%d%n", "Easter: ", month, "/",day, "/",year);
    }


}
