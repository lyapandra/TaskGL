package task02CaesarCipher;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * The main goal of using class {@Code CaesarCipher} is to convert ciphered message with <i>caesar algotithm</i> into  decrypted message using Force method
 * Result can contains some decrypted messages. Human has to read and choose the most suitable.
 */
public class CaesarCipher {

    static StringBuilder cipheredMessage;
    Map<Integer, String> rangedCommonEnglishWords = new HashMap<>();
    Map<Integer, StringBuilder> probableDecryptedMessage = new HashMap<>();

    final static Logger logger = Logger.getLogger(CaesarCipher.class);
    final static Logger logCaesarCipher = Logger.getLogger("logCaesarCipherDebug");


    public CaesarCipher(StringBuilder cipheredMessage) {

        this.cipheredMessage = cipheredMessage;
        this.rangedCommonEnglishWords = getMapOfRangedCommonEnglishWords();

    }

    /**
     * Metod iterates to decrypt the message 25 times
     *
     * @return probableDecryptedMessage There can be some decrypted messages. Human has to read and chose the most suitable.
     */
    public Map<Integer, StringBuilder> decryptForce() {

        for (int shift = 1; shift <= 25; shift++) {
            StringBuilder shiftedMessage = new StringBuilder();
            shiftedMessage = getShiftedMessages(shift);
//            shiftedMessage = getShiftedMessages(shift, shiftedMessage);
            if (isPresentEnglishWords(shiftedMessage)){
                probableDecryptedMessage.put(shift, shiftedMessage);
                logCaesarCipher.debug("shift=" + shift + " " + shiftedMessage);
            }
        }
        System.out.println("probableDecryptedMessage = " + probableDecryptedMessage);
        return probableDecryptedMessage;
    }

    /**
     * Method shifts each character of message and creates guessMessage with shifting characters. Spaces are kept.
     *
     * @param shift number of shifting each character of message
     * @return guessMessage containes created message shifted at {@Code shift} number times
     */
    public StringBuilder getShiftedMessages(int shift) {
//    public StringBuilder getShiftedMessages(int shift, StringBuilder guessMessage) {
 StringBuilder guessMessage = new StringBuilder();
        for (int countChars = 0; countChars < cipheredMessage.length(); countChars++) {
            int charCurrentNmb = cipheredMessage.charAt(countChars);
            if (charCurrentNmb != ' ') {
                guessMessage = guessMessage.append((char) circularShift(charCurrentNmb, shift));
            } else {
                guessMessage = guessMessage.append(' ');
            }
        }
        return guessMessage;
    }

    /**
     * {@Code circularShift} provides circular shifting of one {@Code shift} position
     * @param cipheredChar character that sholud to be shifted
     * @param shift number of <b>circular</b> shifting of character
     * @return character after shifting
     */
    public int circularShift(int cipheredChar, int shift) {
        int charFinish = (int) ('a') + (cipheredChar - (int) ('a') + shift) % 26;
        return charFinish;
    }

    /**
     * Create map of 10 most common words in English
     * @see <a href="https://en.wikipedia.org/wiki/Most_common_words_in_English">Most common words in English (wiki)</a>
     * @return Common English Words. Keys are number of range. Values are words.
     */
    private Map<Integer, String> getMapOfRangedCommonEnglishWords() {

        rangedCommonEnglishWords.put(1, "the");
        rangedCommonEnglishWords.put(2, "be");
        rangedCommonEnglishWords.put(3, "to");
        rangedCommonEnglishWords.put(4, "of");
        rangedCommonEnglishWords.put(5, "and");
        rangedCommonEnglishWords.put(6, "a");
        rangedCommonEnglishWords.put(7, "in");
        rangedCommonEnglishWords.put(8, "that");
        rangedCommonEnglishWords.put(9, "have");
        rangedCommonEnglishWords.put(10, "I");
        rangedCommonEnglishWords.put(11, "rovvy");

        return rangedCommonEnglishWords;
    }

    /**
     * Check if shiftedMessages contains most common English word
     *
     * @param shiftedMessages
     * @return true if shiftedMessages contains most common English word that can be used to check that message is decrypted
     */
    private boolean isPresentEnglishWords(StringBuilder shiftedMessages) {
        boolean isPresentEnglishWords = false;
        for (int countWords = 1; countWords <= rangedCommonEnglishWords.size(); countWords++) {
            List listShiftedMessageWords = Arrays.asList((new String(shiftedMessages)).split(" "));
            if (listShiftedMessageWords.contains(rangedCommonEnglishWords.get(countWords))) {
                System.out.println("Word \"" + rangedCommonEnglishWords.get(countWords) + "\" is present in rangedCommonEnglishWords");
                isPresentEnglishWords = true;
            }
        }
        return isPresentEnglishWords;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaesarCipher that = (CaesarCipher) o;
        return Objects.equals(probableDecryptedMessage, that.probableDecryptedMessage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(probableDecryptedMessage);
    }

    @Override
    public String toString() {
        return "CaesarCipher{" +
                "probableDecryptedMessage=" + probableDecryptedMessage +
                '}';
    }
}
