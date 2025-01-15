package algo.SubstitutionCipher;

import algo.Cipher;
import algo.ICipher;
import util.CharInt;
import util.WrapAround;

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
            CharInt newCharInt = new CharInt(-1);
            char newChar = ' ';
            CharInt encodedCharInt = new CharInt(plainText.charAt(i));

            if (encodedCharInt.getIndex() == -1 || encodedCharInt.getIndex() > 25) {
                newChar = plainText.charAt(i);
                cipherText.append(newChar);
                continue;
            }

//            newCharInt = WrapAround.wrap(key.getForwardShift(encodedCharInt), CAPITAL_MAX);
            newCharInt = key.getForwardCharInt(encodedCharInt);


//            if (encodedChar >= 100 && encodedChar < 200) {
//                newCharInt = (encodedChar + key.getKey()) % (100 + letterMod);
//                if (newCharInt < 100) {
//                    newCharInt += 100;
//                }
//            } else if (encodedChar >= 200) {
//                newCharInt = (((encodedChar - 200) + key.getKey()) % digitMod) + 200;
//            } else {
//                newCharInt = (encodedChar + key.getKey()) % letterMod;
//            }

//            newChar = CharInt.toChar(newCharInt);
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

            if (encodedCharInt.getIndex() == -1 || encodedCharInt.getIndex() > 25) {
                newChar = cipherText.charAt(i);
                plainText.append(newChar);
                continue;
            }

//            newCharInt = WrapAround.wrap(key.getBackwardShift(encodedCharInt), CAPITAL_MAX);
            newCharInt = key.getBackwardCharInt(encodedCharInt);

//            if (decodedChar >= 100 && decodedChar < 200) {
//                newCharInt = (((decodedChar - 100) + (letterMod - key.getKey())) % letterMod) + 100;
//            } else if (decodedChar >= 200) {
//                newCharInt = ((decodedChar - 200) + (digitMod - key.getKey())) % digitMod;
//                if (newCharInt < 0) {
//                    newCharInt = digitMod - (-newCharInt);
//                }
//                newCharInt += 200;
//            } else {
//                newCharInt = (decodedChar + (letterMod - key.getKey())) % letterMod;
//            }
//            newChar = CharInt.toChar(newCharInt);
            newChar = newCharInt.getLetter();
            plainText.append(newChar);
        }

        return plainText.toString();
    }
}
