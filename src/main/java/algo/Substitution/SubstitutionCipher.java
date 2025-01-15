package algo.Substitution;

import algo.Cipher;
import algo.ICipher;
import util.CharInt;

import java.nio.file.Path;

public class SubstitutionCipher extends Cipher implements ICipher {
    private final SubstitutionKey key;

    public SubstitutionCipher(SubstitutionKey key) {
        this.key = key;
    }

    @Override
    public String encrypt(Path plainTextFile) {
        String plainText = fileToString(plainTextFile);

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char newChar;
            CharInt encodedCharInt = new CharInt(plainText.charAt(i));

            if (encodedCharInt.getIndex() == -1 || encodedCharInt.getIndex() > 25) {
                newChar = plainText.charAt(i);
                cipherText.append(newChar);
                continue;
            }
            cipherText.append(key.getForwardCharInt(encodedCharInt).getLetter());
        }

        return cipherText.toString();
    }

    @Override
    public String decrypt(Path cipherTextFile) {
        String cipherText = fileToString(cipherTextFile);

        return decrypt(cipherText);
    }

    public String decrypt(String cipherText) {
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char newChar;
            CharInt encodedCharInt = new CharInt(cipherText.charAt(i));

            if (encodedCharInt.getIndex() == -1 || encodedCharInt.getIndex() > 25) {
                newChar = cipherText.charAt(i);
                plainText.append(newChar);
                continue;
            }
            plainText.append(key.getBackwardCharInt(encodedCharInt).getLetter());
        }

        return plainText.toString();
    }
}
