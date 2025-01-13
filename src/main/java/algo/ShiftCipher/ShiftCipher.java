package algo.ShiftCipher;

import algo.Cipher;
import algo.ICipher;
import util.CharInt;

import java.nio.file.Path;

public class ShiftCipher extends Cipher implements ICipher {
    private final int shift;

    public ShiftCipher(ShiftKey key) {
        shift = key.getForwardShift();
    }

    @Override
    public String encrypt(Path plainTextFile) {
        String plainText = fileToString(plainTextFile);

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            int newCharInt = -1;
            char newChar = '!';
            int encodedChar = CharInt.toInt(plainText.charAt(i));

            if (encodedChar == -1) {
                newChar = plainText.charAt(i);
                cipherText.append(newChar);
                continue;
            }

            if (encodedChar >= 100 && encodedChar < 200) {
                newCharInt = (encodedChar + shift) % (100 + letterMod);
                if (newCharInt < 100) {
                    newCharInt += 100;
                }
            } else if (encodedChar >= 200) {
                newCharInt = (((encodedChar - 200) + shift) % digitMod) + 200;
            } else {
                newCharInt = (encodedChar + shift) % letterMod;
            }
            newChar = CharInt.toChar(newCharInt);
            cipherText.append(newChar);
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
            int newCharInt = -1;
            char newChar = ' ';

            int encodedChar = CharInt.toInt(cipherText.charAt(i));
            if (encodedChar == -1) {
                newChar = cipherText.charAt(i);
                plainText.append(newChar);
                continue;
            }

            if (encodedChar >= 100 && encodedChar < 200) {
                newCharInt = (((encodedChar - 100) + (letterMod - shift)) % letterMod) + 100;
            } else if (encodedChar >= 200) {
                newCharInt = ((encodedChar - 200) + (digitMod - shift)) % digitMod;
                if (newCharInt < 0) {
                    newCharInt = digitMod - (-newCharInt);
                }
                newCharInt += 200;
            } else {
                newCharInt = (encodedChar + (letterMod - shift)) % letterMod;
            }
            newChar = CharInt.toChar(newCharInt);
            plainText.append(newChar);
        }

        return plainText.toString();
    }
}
