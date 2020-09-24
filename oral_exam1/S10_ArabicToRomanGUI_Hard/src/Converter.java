
public class Converter {
    public static String ArabicToRoman(int inputNum){
        String outString=new String();
        int runningSumNum = 0;
        if(inputNum <4000) {
            for (Numerals n : Numerals.values()) {//iterate through roman numerals, largest to smallest
                while (n.getNum() + runningSumNum <= inputNum) {//while the sum of the current numeral and running sum are less than the input
                    runningSumNum += n.getNum(); //add numeral's value to running sum
                    outString += n; //append numeral
                }
            }
        }
        return outString;
    }
    public static int RomanToArabic(String inputString){
        int outNum = 0;
        int smallest = 1000;
        boolean valid = true;
        for(int i = 0;i<inputString.length(); i++){
            for(Numerals n: Numerals.values()){
                if (i < inputString.length() - 1 && (n.toString()).equals(inputString.substring(i, i + 2))) {//if there are still 2 more characters, and the numeral = the next 2 characters
                    if (n.getNum() > smallest) {
                        valid = false;
                        i = inputString.length();
                        break;
                    }

                    else if(n.getNum()<smallest) {
                        smallest = n.getNum();
                        outNum += n.getNum();
                        i++;//increment i an additional time since this appended 2 characters
                        break;//break from testing the rest of the numerals on this index
                    }
                }
                else if ((n.toString()).equals(inputString.substring(i, i+1))) {//if the numeral = the next character
                    if (n.getNum() > smallest) {
                        valid = false;
                        i = inputString.length();
                        break;
                    }
                    else if (n.getNum() == smallest){
                        if (i>2 && (n.toString()+n.toString()+n.toString()).equals(inputString.substring(i-3,i))){
                            valid = false;
                            i=inputString.length();
                            break;
                        }
                        else outNum += n.getNum();
                        break;
                    }
                    else if (n.getNum() < smallest) {
                        smallest = n.getNum();
                        outNum += n.getNum();
                        break;//break from testing the rest of the numerals on this index
                    }
                }
                if(n.getNum()==0) {
                    valid = false;
                    break;
                }
            }
        }
        if (valid) return outNum;
        else return -1;
    }
}
