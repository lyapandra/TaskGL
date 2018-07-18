package task02CaesarCipher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaesarCipher {
    Map<Integer, String> mapOfMostRangedCommonEnglishWords = new HashMap<>();
    static StringBuilder cipheredMessage;
    

    public int circleShift(int cipheredChar, int shift) {
        int chFinish = (int) ('a') + (cipheredChar - (int) ('a') + shift) % 26;
        return chFinish;
    }

    public CaesarCipher(StringBuilder cipheredMessage) {
        this.cipheredMessage = cipheredMessage;
    }

    public void init() {
        Map<Integer, String> mostCommonEnglishWords = getMapOfRangedCommonEnglishWords();

        List listCipheredMessageWords = Arrays.asList((new String(cipheredMessage)).split(" "));
        for (int countWords = 1; countWords <= mapOfMostRangedCommonEnglishWords.size(); countWords++) {

            if (listCipheredMessageWords.contains(mapOfMostRangedCommonEnglishWords.get(countWords))){
                System.out.println(mapOfMostRangedCommonEnglishWords.get(countWords) + " is present");
            }

        }

//        decryptForce(caesarCipher);
    }

    /**
     * @return
     * Source: https://en.wikipedia.org/wiki/Most_common_words_in_English
     */
    private Map<Integer, String> getMapOfRangedCommonEnglishWords() {

        mapOfMostRangedCommonEnglishWords.put(1,"the");
        mapOfMostRangedCommonEnglishWords.put(2,"be");
        mapOfMostRangedCommonEnglishWords.put(3,"to");
        mapOfMostRangedCommonEnglishWords.put(4,"of");
        mapOfMostRangedCommonEnglishWords.put(5,"and");
        mapOfMostRangedCommonEnglishWords.put(6,"a");
        mapOfMostRangedCommonEnglishWords.put(7,"in");
        mapOfMostRangedCommonEnglishWords.put(8,"that");
        mapOfMostRangedCommonEnglishWords.put(9,"have");
        mapOfMostRangedCommonEnglishWords.put(10,"I");
        mapOfMostRangedCommonEnglishWords.put(11,"rovvy");

        return mapOfMostRangedCommonEnglishWords;
    }

    private void decryptForce(CaesarCipher caesarCipher) {
        for (int shift = 0; shift < 27; shift++) {
            StringBuilder shiftedMessage = new StringBuilder();
            shiftedMessage = getShiftedMessages(caesarCipher, shift, shiftedMessage);

//            if ((shiftedMessage.indexOf(" a ")>0)|(shiftedMessage.indexOf(" this ")>0)){
            if (
                    (shiftedMessage.indexOf(" a ") + (shiftedMessage.indexOf(" this "))
                            > 0)) {
                System.out.println("Check this:");
                System.out.println("For shift = " + shift + " unciphered text is: " + shiftedMessage);
            }

        }
    }

    private StringBuilder getShiftedMessages(CaesarCipher caesarCipher, int shift, StringBuilder guessStr) {
        for (int countChars = 0; countChars < cipheredMessage.length(); countChars++) {
            int charCurrentNmb = cipheredMessage.charAt(countChars);
            if (charCurrentNmb != ' ') {
                guessStr = guessStr.append((char) circleShift(charCurrentNmb, shift));
            } else {
                guessStr = guessStr.append(' ');
            }
        }
        return guessStr;
    }

}
