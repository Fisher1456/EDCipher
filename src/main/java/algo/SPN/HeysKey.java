package algo.SPN;

import algo.RoundKey;
import util.CharInt;

import java.util.ArrayList;

public class HeysKey implements RoundKey {
    private ArrayList<String> keyString;

    @Override
    public void setKey(ArrayList<String> keyString) {
        for (String str : keyString) {
            if (str.length() % 16 != 0) {
                throw new IllegalArgumentException("keystring " + str + " length incorrect");
            }
        }
        if (keyString.size() != 4) {
            throw new IllegalArgumentException("keystring size is not 4");
        }

        this.keyString = keyString;
    }

    public String XOR(String input, int round) {
        if (round < 0 ||round > 3) {
            throw new IllegalArgumentException("round value invalid");
        }
        if (input.length() != keyString.get(round).length()) {
            throw new IllegalArgumentException("input and keystring not equal size");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i ++) {
            String letter = String.valueOf(input.charAt(i));
            if (Integer.parseInt(letter) + keyString.get(round).charAt(i) != 1) {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }

        return sb.toString();
    }
}
