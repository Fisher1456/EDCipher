package algo.SPN;

import algo.Cipher;
import algo.ICipher;
import util.CharInt;

import java.nio.file.Path;
import java.util.ArrayList;

public class HeysCipher extends Cipher implements ICipher {
    private final HeysKey hk;

    public HeysCipher(HeysKey hk) {
        this.hk = hk;
    }

    @Override
    public String encrypt(Path plainTextFile) {
        String plainText = toCapitals(fileToString(plainTextFile));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char newChar;
            CharInt encodedCharInt = new CharInt(plainText.charAt(i));
            sb.append(encodedCharInt.getHex());
        }

        StringBuilder binaryPlainText = new StringBuilder(CharInt.toBinary(sb.toString()));
        while (binaryPlainText.length() % 16 != 0) {
            binaryPlainText.append("0000");
        }

        ArrayList<String> keyString = new ArrayList<>();
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < binaryPlainText.length(); i ++) {
            key.append("1");
        }
        keyString.add(key.toString());
        keyString.add(key.toString());
        keyString.add(key.toString());
        keyString.add(key.toString());
        hk.setKey(keyString);





        return "";
    }

    @Override
    public String decrypt(Path cipherTextFile) {
        return "";
    }

    private String toCapitals(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i ++) {
            CharInt ci = new CharInt(input.charAt(i));
            if (ci.getIndex() > 25 && ci.getIndex() < 200) {
                sb.append((new CharInt(ci.getIndex() - 100)).getLetter());
                continue;
            } else if (ci.getIndex() >= 200 || ci.getIndex() == -1) {
                continue;
            }
            sb.append(ci.getLetter());
        }
        return sb.toString();
    }
}
