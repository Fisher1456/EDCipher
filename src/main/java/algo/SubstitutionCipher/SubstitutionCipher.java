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
            int newCharInt = -1;
            char newChar = ' ';
            int encodedChar = CharInt.toInt(plainText.charAt(i));

            if (encodedChar == -1 || encodedChar > 25) {
                newChar = plainText.charAt(i);
                cipherText.append(newChar);
                continue;
            }

//            newCharInt = (encodedChar + key.getForwardShift(encodedChar)) % CAPITAL_MAX;
            newCharInt = WrapAround.wrap(encodedChar + key.getForwardShift(encodedChar), CAPITAL_MAX);


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
            if (encodedChar == -1 || encodedChar > 25) {
                newChar = cipherText.charAt(i);
                plainText.append(newChar);
                continue;
            }

//            newCharInt = (encodedChar + (CAPITAL_MAX - key.getBackwardShift(encodedChar))) % CAPITAL_MAX;
            newCharInt = WrapAround.wrap(encodedChar - key.getBackwardShift(encodedChar), CAPITAL_MAX);

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
            newChar = CharInt.toChar(newCharInt);
            plainText.append(newChar);
        }

        return plainText.toString();
    }
}
