package algo.SubstitutionCipher;

import algo.Cipher;
import algo.IKey;
import algo.Key;
import algo.KeyType;
import util.WrapAround;

import java.util.ArrayList;

public class SubstitutionKey extends Key implements IKey {
    private KeyType keyType = null;
    private ArrayList<Integer> keyForward = null;
    private ArrayList<Integer> keyBackward = null;
    //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,

    public SubstitutionKey() {
    }

    @Override
    public void setKey(String keyString, String type) {
        this.keyType = KeyType.parse(type);
        this.keyForward = new ArrayList<>();
        this.keyBackward = new ArrayList<>();
        for (int i = 0; i < Cipher.CAPITAL_MAX; i ++) {
            keyBackward.add(0);
        }

        StringBuilder tempKey = new StringBuilder();
        for (int i = 0; i < keyString.length(); i++) {
            if (keyString.charAt(i) == ' ') {
                continue;
            } else if (keyString.charAt(i) == ',') {
                int shift = WrapAround.wrap(Integer.parseInt(tempKey.toString()), Cipher.CAPITAL_MAX);
                keyForward.add(shift);
                keyBackward.set(shift, shift - i);
                tempKey = new StringBuilder();
                continue;
            }

            tempKey.append(keyString.charAt(i));
        }

        if (keyForward.size() < 26) {
            for (int i = keyForward.size(); i < 26; i ++) {
                keyForward.add(0);
            }
        }
    }

    public int getForwardShift(int index) {
        return keyForward.get(index);
    }

    public int getBackwardShift(int value) {
//        for (int i = value; i < key.size() + value; i++) {
//            if ((i + key.get(i)) % Cipher.letterMod == value) {
//                return key.get(i);
//            }
//        }

//        return 0;

        return keyBackward.get(value);
    }
}
