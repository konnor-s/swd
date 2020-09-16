import java.util.Scanner;

public class TestComputus {
    public static void main(String[] args){
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
}
