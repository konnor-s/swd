/**
 * Class which implements functions to convert between Arabic and Roman Numerals.
 * @author Konnor Sommer
 *
 */
public class Converter {
    /**
     * Converts an input Arabic number into Roman numerals.
     *
     * @param inputNum The input Arabic number, an int
     * @return outString The output Roman numerals, a string
     */
    public static String ArabicToRoman(int inputNum){
        String outString="";
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

    /**
     * Converts an input Roman numeral string to Arabic.
     * Utilizes enum Numerals for making the conversion.
     * Utilizes method Validate() to ensure that the input is valid.
     * @param inputString The input Roman Numerals, a string.
     * @return outNum The output Arabic number, an int, or -1 for invalid input.
     * @see Numerals
     * @see Converter#Validate(int,int)
     */
    public static int RomanToArabic(String inputString){
        int outNum = 0;
        int smallest = 1000;
        boolean valid = true;
        for(int i = 0;i<inputString.length(); i++){
            for(Numerals n: Numerals.values()){
                //if there are still 2 more characters, and the numeral = the next 2 characters
                if (i < inputString.length() - 1 && (n.toString()).equals(inputString.substring(i, i + 2))) {
                    if (!Converter.Validate(smallest, n.getNum())){
                        valid = false;
                        i=inputString.length();
                        break;
                    }
                    //If the matching  numeral is smaller than smallest used, valid
                    else if(n.getNum()<smallest) {
                        smallest = n.getNum();
                        outNum += n.getNum();
                        i++;//increment i an additional time since this appended 2 characters
                        break;//break from testing the rest of the numerals on this index
                    }
                }
                //if the numeral = the next character
                else if ((n.toString()).equals(inputString.substring(i, i+1))) {
                    //Validate
                    if (!Converter.Validate(smallest, n.getNum())){
                        valid = false;
                        i=inputString.length();
                        break;
                    }
                    //If the matching numeral is equal to the smallest used. Another validation step
                    else if (n.getNum() == smallest){
                        //If it is either X,C, or M
                        if((n.getNum() ==1 || n.getNum() == 10 ) || (n.getNum() == 100) || (n.getNum() == 1000)) {
                            //If it is the fourth repetition, invalid
                            if (i > 2 && (n.toString() + n.toString() + n.toString()).equals(inputString.substring(i - 3, i))) {
                                valid = false;
                                i = inputString.length();
                                break;
                            }
                            //else valid
                            else {
                               smallest = n.getNum();
                                outNum += n.getNum();
                                break;
                            }
                        }
                        //if the same numeral is repeated but not X, C, or M, invalid
                        else{
                            valid = false;
                            i = inputString.length();
                            break;
                        }

                    }
                    //If numeral is smaller than smallest used, valid
                    else if (n.getNum() < smallest) {
                        smallest = n.getNum();
                        outNum += n.getNum();
                        break;//break from testing the rest of the numerals on this index
                    }
                }
                //No negatives
                if(n.getNum()<=0) {
                    valid = false;
                    break;
                }
            }
        }
        if (valid) return outNum;
        else return -1;
    }

    /**
     * Class which validates input Roman numerals for method RomantoArabic.
     * @param smallest The smallest value of Roman numeral used so far
     * @param n The value of the current numeral
     * @return valid Boolean indicating whether the Roman numeral is valid
     * @see Converter#RomanToArabic(String)
     */
    private static boolean Validate(int smallest, int n){
        boolean valid = true;
        //If the matching numeral is larger than smallest numeral used, invalid
        if (n > smallest) {
            valid = false;
        }
        //CM
        else if(smallest==900 && n >=100){
            valid = false;
        }
        //D
        else if(smallest==500 && n == 400){
            valid = false;
        }
        //CD
        else if(smallest==400 && n == 100){
            valid = false;
        }
        //C
        //else if(smallest==100 && )}
        //XC
        else if(smallest==90 && n >=10){
            valid = false;
        }
        //L
        else if(smallest==50 && n ==40){
            valid = false;
        }
        //LX
        else if(smallest==40 && n ==10){
            valid = false;
        }
        //X
        //else if(smallest==10 &&){

        //IX
        else if(smallest==9 && n >=0){
            valid = false;
        }
        //LX
        else if(smallest==5 && n ==4){
            valid = false;
        }
        //LX
        else if(smallest==4 && n ==1){
            valid = false;
        }
        return valid;
    }
}
