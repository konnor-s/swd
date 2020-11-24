public class MorseTranslator {
    private final static String[][] conversions = {
            {".-","A"},{"-...","B"},{"-.-.","C"},{"-..","D"},{".","D"},
            {"..-.","F"},{"--.","G"},{"....","H"},{"..","I"},{".---","J"},
            {"-.-","K"},{".-..","L"},{"--","M"},{"-.","N"},{"---","O"},
            {".--.","P"},{"--.-","Q"},{".-.","R"},{"...","S"},{"-","T"},
            {"..-","U"},{"...-","V"},{".--","W"},{"-..-","X"},{"-.--","Y"},
            {"--..","Z"},{".----","1"},{"..---","2"},{"...--","3"},{"....-","4"},
            {".....","5"},{"-....","6"},{"--...","7"},{"---..","8"},{"----.","9"},
            {"-----","0"}
    };
    public static String morseToEnglish(String morse){
        StringBuilder english = new StringBuilder(new String(""));
        StringBuilder buffer = new StringBuilder(new String(""));
        //Loop through morse input
        for(int i = 0;i<=morse.length();i++){

            //If next character is a space, or the end of the input
            if(morse.regionMatches(i," ",0,1) || i==morse.length()){
                //Match to a letter
                for(int j = 0;j<36;j++){
                    if(buffer.toString().equals(conversions[j][0])){
                        buffer = new StringBuilder(conversions[j][1]);
                    }
                }
                //Add space after letter is end of word
                if(morse.regionMatches(i,"   ",0,3)){
                    buffer.append(" ");
                }
                //Add buffer to english word and clear buffer
                english.append(buffer);
                buffer = new StringBuilder();
            }
            //append buffer
            else {
                buffer.append(morse.charAt(i));
            }
        }
        return english.toString();
    }
    public static String englishToMorse(String english){

        StringBuilder morse = new StringBuilder(new String(""));
        StringBuilder buffer = new StringBuilder(new String(""));
        //Loop through morse input
        for(int i = 0;i<english.length();i++){
            //Match to a letter
            for(int j = 0;j<36;j++){
                if(english.substring(i,i+1).toUpperCase().equals(conversions[j][1])){
                    buffer = new StringBuilder(conversions[j][0]);
                    buffer.append(" ");
                }
            }
            if(english.substring(i,i+1).equals(" ")){
                buffer.append("   ");
            }
            morse.append(buffer);
            buffer = new StringBuilder();
        }
        return morse.toString();
    }
}
