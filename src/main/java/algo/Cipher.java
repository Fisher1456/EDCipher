package algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Cipher implements ICipher {
    public static final int letterMod = 26;
    public static final int digitMod = 10;

    @Override
    public String encrypt(Path plainTextFile) {
        return "";
    }

    @Override
    public String decrypt(Path cipherTextFile) {
        return "";
    }

    public static String fileToString(Path inputFile) {
        StringBuilder builder = new StringBuilder();
        try (FileReader fr = new FileReader(inputFile.toFile());
             BufferedReader br = new BufferedReader(fr)) {
            String str;

            while ((str = br.readLine()) != null) {
                builder.append(str).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }
}
