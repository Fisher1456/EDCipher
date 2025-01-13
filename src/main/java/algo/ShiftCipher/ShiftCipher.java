package algo.ShiftCipher;

import algo.Cipher;
import algo.ICipher;
import util.CharInt;
import util.key.ShiftKey;

import java.io.*;
import java.nio.file.Path;

public class ShiftCipher implements ICipher {
    private ShiftKey key;
    private int shift;

    private static final int letterMod = 26;
    private static final int digitMod = 10;

    public ShiftCipher(ShiftKey key) {
        this.key = key;
        shift = key.getKey();
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
            char newChar = '!';
            int encodedChar = CharInt.toInt(plainText.charAt(i));

            if (encodedChar == -1) {
                newChar = plainText.charAt(i);
                cipherText += newChar;
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
            if (encodedChar == -1) {
                newChar = cipherText.charAt(i);
                plainText += newChar;
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
            plainText += newChar;
        }

        return plainText;
    }
}
