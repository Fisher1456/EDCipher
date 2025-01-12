package algo.SubstitutionCipher;

import algo.Cipher;
import algo.ICipher;
import util.CharInt;
import util.key.ShiftKey;
import util.key.SubstitutionKey;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class SubstitutionCipher implements ICipher {
    private SubstitutionKey key;

    private static final int letterMod = 26;
    private static final int digitMod = 10;

    public SubstitutionCipher(SubstitutionKey key) {
        this.key = key;
    }

    private static String fileToString(Path inputFile) {
        StringBuilder builder = new StringBuilder();
        try (FileReader fr = new FileReader(inputFile.toFile());
             BufferedReader br = new BufferedReader(fr)) {
            String str;

            while ((str = br.readLine()) != null) {
                builder.append(str).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String output = builder.toString();
        return output;
    }


    @Override
    public String encrypt(Path plainTextFile) {
        String plainText = fileToString(plainTextFile);

        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) {
            int newCharInt = -1;
            char newChar = ' ';
            int encodedChar = CharInt.toInt(plainText.charAt(i));

            if (encodedChar == -1 || encodedChar > 25) {
                newChar = plainText.charAt(i);
                cipherText += newChar;
                continue;
            }

            newCharInt = (encodedChar + key.getForwardValue(encodedChar)) % letterMod;


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
            cipherText += newChar;
        }

        return cipherText;
    }

    @Override
    public String decrypt(Path cipherTextFile) {
        String cipherText = fileToString(cipherTextFile);

        return decrypt(cipherText);
    }

    public String decrypt(String cipherText) {
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int newCharInt = -1;
            char newChar = ' ';

            int encodedChar = CharInt.toInt(cipherText.charAt(i));
            if (encodedChar == -1 || encodedChar > 25) {
                newChar = cipherText.charAt(i);
                plainText += newChar;
                continue;
            }

            newCharInt = (encodedChar + (letterMod - key.getBackwardValue(encodedChar))) % letterMod;

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
            plainText += newChar;
        }

        return plainText;
    }
}
