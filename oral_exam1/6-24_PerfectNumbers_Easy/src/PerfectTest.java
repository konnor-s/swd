public class PerfectTest{
    public static void main(String[] args){
        System.out.print("Perfect numbers between 1 and 10,000:");
        for(int i=1;i<=10000;i++)
            if(Perfect.isPerfect(i)){
                System.out.printf("%n%d: ",i);
                Perfect.printFactors(i);
            }
    }
}