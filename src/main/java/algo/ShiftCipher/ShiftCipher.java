package algo.ShiftCipher;

import algo.Cipher;
import algo.ICipher;
import algo.IKey;
import algo.Key;
import util.CharInt;
import util.WrapAround;

import java.nio.file.Path;

public class ShiftCipher extends Cipher implements ICipher {
    ShiftKey key;
//    private final int shift;

    public ShiftCipher(ShiftKey key) {
//        shift = key.getForwardCharInt();
        this.key = key;
    }

    @Override
    public String encrypt(Path plainTextFile) {
        String plainText = fileToString(plainTextFile);

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            CharInt newCharInt = new CharInt(-1);
            char newChar = '!';
//            int encodedChar = CharInt.toInt(plainText.charAt(i));
            CharInt encodedCharInt = new CharInt(plainText.charAt(i));

            if (encodedCharInt.getIndex() == -1) {
                newChar = plainText.charAt(i);
                cipherText.append(newChar);
                continue;
            }

//            if (encodedCharInt.getIndex() >= LOWER_CASE_MIN && encodedCharInt.getIndex() < DIGIT_MIN) {
////                newCharInt = (encodedChar + shift) % (100 + CAPITAL_MAX);
////                if (newCharInt < 100) {
////                    newCharInt += 100;
////                }
////                newCharInt = WrapAround.wrap(encodedCharInt + shift, LOWER_CASE_MIN, LOWER_CASE_MAX);
//            } else if (encodedCharInt.getIndex() >= DIGIT_MIN) {
////                newCharInt = (((encodedChar - 200) + shift) % DIGIT_MAX) + 200;
////                newCharInt = WrapAround.wrap((encodedCharInt) + shift, DIGIT_MIN, DIGIT_MAX);
//            } else {
//                newCharInt = WrapAround.wrap(encodedCharInt + shift,  CAPITAL_MAX);
//            }
//            newChar = CharInt.toChar(newCharInt);
            newCharInt = key.getForwardCharInt(encodedCharInt);

            newChar = newCharInt.getLetter();
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
            CharInt newCharInt = new CharInt(-1);
            char newChar = ' ';

            CharInt encodedCharInt = new CharInt(cipherText.charAt(i));
            if (encodedCharInt.getIndex() == -1) {
                newChar = cipherText.charAt(i);
                plainText.append(newChar);
                continue;
            }

//            if (encodedChar >= LOWER_CASE_MIN && encodedChar < DIGIT_MIN) {
////                newCharInt = (((encodedChar - 100) + (CAPITAL_MAX - shift)) % CAPITAL_MAX) + 100;
//                newCharInt = WrapAround.wrap(encodedChar - shift, LOWER_CASE_MIN, LOWER_CASE_MAX - shift);
//            } else if (encodedChar >= DIGIT_MIN) {
////                newCharInt = ((encodedChar - 200) + (DIGIT_MAX - shift)) % DIGIT_MAX;
////                if (newCharInt < 0) {
////                    newCharInt = DIGIT_MAX - (-newCharInt);
////                }
////                newCharInt += 200;
//                newCharInt = WrapAround.wrap(encodedChar - shift, DIGIT_MIN, DIGIT_MAX - shift);
//            } else {
////                newCharInt = (encodedChar + (CAPITAL_MAX - shift)) % CAPITAL_MAX;
//                newCharInt = WrapAround.wrap(encodedChar - shift, CAPITAL_MAX);
//            }
            newCharInt = key.getBackwardCharInt(encodedCharInt);

//            newChar = CharInt.toChar(newCharInt);
            newChar = newCharInt.getLetter();
            plainText.append(newChar);
        }

        return plainText.toString();
    }
}
