package algo.SubstitutionCipher;

import algo.Cipher;
import algo.IKey;
import algo.Key;
import algo.KeyType;
import util.CharInt;
import util.WrapAround;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SubstitutionKey extends Key implements IKey {
    private KeyType keyType = null;
//    private final HashMap<Integer, Integer> key = new HashMap<>();
    private final HashMap<CharInt, CharInt> key = new HashMap<>();
    //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,

    public SubstitutionKey() {
    }

    @Override
    public void setKey(String keyString, String type) {
        this.keyType = KeyType.parse(type);

        StringBuilder tempKey = new StringBuilder();
        int j = 0;
        for (int i = 0; i < keyString.length(); i++) {
            if (keyString.charAt(i) == ' ') {
                continue;
            } else if (keyString.charAt(i) == ',') {
                int shift = WrapAround.wrap(Integer.parseInt(tempKey.toString()), Cipher.CAPITAL_MAX);
//                key.put(j, j + shift);
                key.put(new CharInt(j), new CharInt(WrapAround.wrap(j + shift)));
                j ++;

                tempKey = new StringBuilder();
                continue;
            }

            tempKey.append(keyString.charAt(i));
        }

        if (key.size() < 26) {
            for (int i = key.size(); i < 26; i ++) {
//                key.put(j, j);
                key.put(new CharInt(j), new CharInt(j));
            }
        }
    }

    @Override
    public CharInt getForwardCharInt(CharInt ci) {
        return key.get(ci);
    }

    @Override
    public CharInt getBackwardCharInt(CharInt ci) {
        if (key.containsValue(ci)) {
            Iterator<Map.Entry<CharInt, CharInt>> iterator = key.entrySet().iterator();

            while (iterator.hasNext()) {
                if (iterator.next().getValue().getIndex() == ci.getIndex()) {
                    return iterator.next().getValue();
                }
            }
        }

        return ci;
    }

//    public int getForwardShift(int index) {
//        return key.get(index);
//    }
//
//    public int getBackwardShift(int value) {
//        if (key.containsValue(value)) {
//            for (int i = 0; i < key.size(); i ++) {
//                if (key.get(i) == value) {
//                    return i;
//                }
//            }
//        }
//
//        return value;
//    }
}
