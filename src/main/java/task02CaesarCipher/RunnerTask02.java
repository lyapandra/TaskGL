package task02CaesarCipher;

import java.util.Map;

public class RunnerTask02 {

    /**
     * Convert {@Code caesarCipher} into {@Code decryptCaesarCipherMessageWithForceMethod} using Force method
     */
    public static void main(String[] args) {

        StringBuilder cipheredMessage = new StringBuilder("rovvy drsc cswzvo dohd sc tecd kswon dy myxqbkdevkdo iye csxmo iue rkfo zkccon drsc docd");
        CaesarCipher caesarCipher = new CaesarCipher(cipheredMessage);
        Map<Integer, StringBuilder> decryptCaesarCipherMessageWithForceMethod = caesarCipher.decryptForce();

    }

}
