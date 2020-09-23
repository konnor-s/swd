


public class Converter {
    public static String ArabicToRoman(int inputNum){
        String outString=new String();
        int outNum = 0;
        for(Numerals n:Numerals.values()){
            while(n.getNum()+outNum <= inputNum){
                outNum += n.getNum();
                outString += n;
            }
        }
        return outString;
    }
}
