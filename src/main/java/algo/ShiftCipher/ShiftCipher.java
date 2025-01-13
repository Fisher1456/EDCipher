package algo.ShiftCipher;

import algo.Cipher;
import algo.ICipher;
import util.CharInt;
import util.WrapAround;

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

            if (encodedChar >= LOWER_CASE_MIN && encodedChar < DIGIT_MIN) {
//                newCharInt = (encodedChar + shift) % (100 + CAPITAL_MAX);
//                if (newCharInt < 100) {
//                    newCharInt += 100;
//                }
                newCharInt = WrapAround.wrap(encodedChar + shift, LOWER_CASE_MIN, LOWER_CASE_MAX);
            } else if (encodedChar >= DIGIT_MIN) {
//                newCharInt = (((encodedChar - 200) + shift) % DIGIT_MAX) + 200;
                newCharInt = WrapAround.wrap((encodedChar) + shift, DIGIT_MIN, DIGIT_MAX);
            } else {
                newCharInt = WrapAround.wrap(encodedChar + shift,  CAPITAL_MAX);
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

            if (encodedChar >= LOWER_CASE_MIN && encodedChar < DIGIT_MIN) {
//                newCharInt = (((encodedChar - 100) + (CAPITAL_MAX - shift)) % CAPITAL_MAX) + 100;
                newCharInt = WrapAround.wrap(encodedChar - shift, LOWER_CASE_MIN, LOWER_CASE_MAX - shift);
            } else if (encodedChar >= DIGIT_MIN) {
//                newCharInt = ((encodedChar - 200) + (DIGIT_MAX - shift)) % DIGIT_MAX;
//                if (newCharInt < 0) {
//                    newCharInt = DIGIT_MAX - (-newCharInt);
//                }
//                newCharInt += 200;
                newCharInt = WrapAround.wrap(encodedChar - shift, DIGIT_MIN, DIGIT_MAX - shift);
            } else {
//                newCharInt = (encodedChar + (CAPITAL_MAX - shift)) % CAPITAL_MAX;
                newCharInt = WrapAround.wrap(encodedChar - shift, CAPITAL_MAX);
            }
            newChar = CharInt.toChar(newCharInt);
            plainText.append(newChar);
        }

        return plainText.toString();
    }
}
