public class Perfect {
    public static boolean isPerfect(int x){
        int sum=1;
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0){
                sum+=(x/i+i);
            }
        }
        return (sum==x) && (x!=1);
    }
    public static void printFactors(int x){
        System.out.printf("1");
        for(int i=2;i<x;i++) {
            if (x % i == 0) {
                System.out.printf(" + %d",i);
            }
        }
    }
}
