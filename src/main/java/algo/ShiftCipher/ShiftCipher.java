package algo.ShiftCipher;

import util.CharInt;
import util.key.Key;
import util.key.ShiftKey;

import java.io.*;
import java.nio.file.Path;

public class ShiftCipher {
    private ShiftKey key;

    private static final int letterMod = 26;
    private static final int digitMod = 10;

    public ShiftCipher(ShiftKey key) {
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

    public String encrypt(Path plainTextFile) {
        String plainText = fileToString(plainTextFile);

        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) {
            int newCharInt = -1;
            char newChar = ' ';
            int encodedChar = CharInt.toInt(plainText.charAt(i));

            if (encodedChar == -1) {
                newChar = plainText.charAt(i);
                cipherText += newChar;
                continue;
            }

            if (encodedChar >= 100 && encodedChar < 200) {
                newCharInt = (encodedChar + key.getKey()) % (100 + letterMod);
                if (newCharInt < 100) {
                    newCharInt += 100;
                }
            } else if (encodedChar >= 200) {
                newCharInt = (((encodedChar - 200) + key.getKey()) % digitMod) + 200;
            } else {
                newCharInt = (encodedChar + key.getKey()) % letterMod;
            }
            newChar = CharInt.toChar(newCharInt);
            cipherText += newChar;
        }

        return cipherText;
    }

    public String decrypt(Path cipherTextFile) {
        String cipherText = fileToString(cipherTextFile);

        return decrypt(cipherText);
    }

    public String decrypt(String cipherText) {
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int newCharInt = -1;
            char newChar = ' ';

            int decodedChar = CharInt.toInt(cipherText.charAt(i));
            if (decodedChar == -1) {
                newChar = cipherText.charAt(i);
                plainText += newChar;
                continue;
            }

            if (decodedChar >= 100 && decodedChar < 200) {
                newCharInt = (((decodedChar - 100) + (letterMod - key.getKey())) % letterMod) + 100;
            } else if (decodedChar >= 200) {
                newCharInt = ((decodedChar - 200) + (digitMod - key.getKey())) % digitMod;
                if (newCharInt < 0) {
                    newCharInt = digitMod - (-newCharInt);
                }
                newCharInt += 200;
            } else {
                newCharInt = (decodedChar + (letterMod - key.getKey())) % letterMod;
            }
            newChar = CharInt.toChar(newCharInt);
            plainText += newChar;
        }

        return plainText;
    }
}
