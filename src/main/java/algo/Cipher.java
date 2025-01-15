package algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public abstract class Cipher implements ICipher {
//    public static final int CAPITAL_MIN = 0;
    public static final int CAPITAL_MAX = 26;
    public static final int LOWER_CASE_MIN = 100;
    public static final int LOWER_CASE_MAX = 126;
    public static final int DIGIT_MIN = 200;
    public static final int DIGIT_MAX = 210;

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
