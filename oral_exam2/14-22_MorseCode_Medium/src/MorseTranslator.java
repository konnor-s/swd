public class MorseTranslator {
    public static String morseToEnglish(String morse){
        String[][] conversions = {
                {".-","A"},{"-...","B"},{"-.-.","C"},{"-..","D"},{".","D"},
                {"..-.","F"},{"--.","G"},{"....","H"},{"..","I"},{".---","J"},
                {"-.-","K"},{".-..","L"},{"--","M"},{"-.","N"},{"---","O"},
                {".--.","P"},{"--.-","Q"},{".-.","R"},{"...","S"},{"-","T"},
                {"..-","U"},{"...-","V"},{".--","W"},{"-..-","X"},{"-.--","Y"},
                {"--..","Z"},{".----","1"},{"..---","2"},{"...--","3"},{"....-","4"},
                {".....","5"},{"-....","6"},{"--...","7"},{"---..","8"},{"----.","9"},
                {"-----","0"}
        };

        StringBuilder english = new StringBuilder(new String(""));
        String buffer = new String("");
        for(int i = 0;i<=morse.length();i++){
            System.out.println(buffer);
            //Get 1 letter
            if(morse.regionMatches(i," ",0,1) || i==morse.length()){
                for(int j = 0;j<36;j++){
                    if(buffer.equals(conversions[j][0])){
                        buffer = conversions[j][1];
                    }
                }
                //Add space after letter if end of word
                if(morse.regionMatches(i,"   ",0,3)){
                    buffer += " ";
                }
                english.append(buffer);
                buffer="";

            }


            else {
                buffer += morse.charAt(i);
            }
            //Add letter to english


        }

        return english.toString();
    }
}
