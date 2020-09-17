import java.util.Scanner;

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
    public long getEaster(){
        return (long) year*10000+month*100+day;
    }
    private void printEaster(){
        System.out.printf("%s%d%s%d%s%d%n", "Easter: ", month, "/",day, "/",year);
    }

    public static void userDateInput(){
        int inpYear=1;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter year to determine data of Easter, or enter -1 to exit");
        System.out.print("\nEnter year: ");
        inpYear=input.nextInt();
        while (inpYear!=-1){
            Computus easter= new Computus(inpYear);
            easter.printEaster();
            System.out.print("\nEnter year: ");
            inpYear=input.nextInt();
        }
    }
    public static void printOccurrences(){
        int[][] dateArray=new int[13][32];
        for(int i=0;i<5700000;i++){
            Computus yearObj= new Computus(i);
            long tempDate=yearObj.getEaster();
            dateArray[(int)((tempDate%10000)/100)][(int)((tempDate%10000)%100)]++;
        }
        System.out.print("Occurences of Easter on each date over 5,700,000 year cycle\n");
        for(int m=1;m<13;m++){
            for(int d=1;d<32;d++){
                if (dateArray[m][d]>1){
                    System.out.printf("%d%s%d%s%d%n", m, "/",d, "--",dateArray[m][d]);
                }
            }
        }
    }


}
