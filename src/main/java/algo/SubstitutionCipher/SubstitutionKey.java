package algo.SubstitutionCipher;

import algo.IKey;
import algo.Key;
import algo.KeyType;

import java.util.ArrayList;

public class SubstitutionKey extends Key implements IKey {
    private KeyType keyType = null;
    private ArrayList<Integer> key = null;
    //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,

    public SubstitutionKey() {
    }

    @Override
    public void setKey(String keyString, String type) {
        this.keyType = KeyType.parse(type);
        this.key = new ArrayList<>();

        String tempKey = "";
        for (int i = 0; i < keyString.length(); i++) {
            if (keyString.charAt(i) == ' ') {
                continue;
            } else if (keyString.charAt(i) == ',') {
                key.add(Integer.parseInt(tempKey));
                tempKey = "";
                continue;
            }

            tempKey += keyString.charAt(i);
        }

        if (key.size() < 26) {
            for (int i = key.size(); i < 26; i ++) {
                key.add(0);
            }
        }
    }

    public int getForwardValue(int index) {
        return key.get(index);
    }

    public int getBackwardValue(int value) {
        for (int i = 0; i < key.size(); i++) {
            if (i + key.get(i) == value) {
                return key.get(i);
            }
        }

        return 0;
    }
}
