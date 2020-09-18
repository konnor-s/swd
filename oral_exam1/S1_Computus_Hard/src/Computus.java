import java.util.Scanner;

/**
 * Class which implements the Meeus/Jones/Butcher Gregorian algorithm to calculate the date of Easter.
 * Algorithm source: <a href="https://en.wikipedia.org/wiki/Computus#Anonymous_Gregorian_algorithm">link</a>.
 * @author Konnor Sommer
 */
public class Computus {
    /**
     * Variable to store input year.
     */
    private final int year;
    /**
     * Variable to store calculated Easter month
     */
    private final int month;
    /**
     * Variable to store calculated Easter day
     */
    private final int day;

    /**
     * Constructor for class Computus.
     * For input {@link Computus#year}, calculates the month and day of Easter and stores them in {@link Computus#month} and {@link Computus#day}
     * @param year The input integer to calculate Easter
     */
    Computus(int year){
        if(year<0) {//There was no Easter on negative dates
            throw new IllegalArgumentException("Year was less than 0");
        }
        this.year = year;
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        month = (h + l - 7 * m + 114) / 31;
        day = ((h + l - 7 * m + 114) % 31) + 1;
    }
    /**
     * Returns the date of Easter for this object.
     * @return the date of Easter, in format yearmonthday as long
     */
    public long getEaster(){
        return (long) year*10000+month*100+day;
    }

    /**
     * Prints the date of Easter.
     * Prints in format "Easter: month/day/year
     */
    private void printEaster(){
        System.out.printf("%s%d%s%d%s%d%n", "Easter: ", month, "/",day, "/",year);
    }
    /**
     * Takes user input of a year and prints the date of Easter for that year.
     * Continues asking for user input until they enter a negative value, then this method terminates.
     * Instantiates new Computus object with input year, then calls method printEaster to print the Easter date.
     * @see Computus#printEaster()
     */
    public static void userDateInput(){
        int inpYear=1;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter year to determine data of Easter, or enter negative number to exit");
        System.out.print("\nEnter year: ");
        inpYear=input.nextInt();//get input before loop in case they enter negative first
        while (inpYear>-1){//exit for negative
            Computus easter= new Computus(inpYear);//instantiate new object with user input
            easter.printEaster();
            System.out.print("\nEnter year: ");//get new input
            inpYear=input.nextInt();
        }
    }
    /**
     * Prints the amount of occurrences of Easter on each calendar date over a 5,700,000 year cycle.
     * For values 0 up to 5700000, instantiates a new Computus object, then calls method getEaster to store the object's Easter
     * date. Uses the month and day of this date to increment an array with indices [month][day]. Then prints each date with
     * non-zero occurrences, along with the number of occurrences, in format month/day--occurrences.
     * @see Computus#getEaster()
     */
    public static void printOccurrences(){
        int[][] dateArray=new int[13][32];//array to store number of easter occurrences on each date.
        for(int i=0;i<5700000;i++){
            Computus yearObj= new Computus(i);
            long tempDate=yearObj.getEaster();
            dateArray[(int)((tempDate%10000)/100)][(int)(tempDate%100)]++;//increment array of index [month][day]
            //I could have made getMonth and getDay methods to use here, but I think it's simpler to have one getEaster method for the entire date.
        }
        System.out.print("Occurences of Easter on each date over 5,700,000 year cycle\n");
        for(int m=1;m<13;m++){
            for(int d=1;d<32;d++){
                if (dateArray[m][d]>1){//Print out each date that has non-zero occurrences
                    System.out.printf("%d%s%d%s%d%n", m, "/",d, "--",dateArray[m][d]);
                }
            }
        }
    }
}
