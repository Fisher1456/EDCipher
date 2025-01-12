package util.key;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstitutionKey extends Key implements IKey {
    private String keyString = null;
    private KeyType keyType = null;
    private ArrayList<Integer> key = null;
    //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,

    public SubstitutionKey() {
    }

    @Override
    public void setKey(String keyString, String type) {
        this.keyString = keyString;
        this.keyType = KeyType.parse(type);
        this.key = new ArrayList<>();

        String tempKey = "";
        for (int i = 0; i < keyString.length(); i++) {
            if (keyString.charAt(i) != ',') {
                tempKey += keyString.charAt(i);
            } else if (keyString.charAt(i) == ' ') {
                continue;
            } else if (keyString.charAt(i) == ',') {
                this.key.add(Integer.parseInt(tempKey));
                tempKey = "";
            }
        }

        if (this.key.size() < 26) {
            for (int i = this.key.size(); i < 26; i ++) {
                this.key.add(0);
            }
        }
    }

    public int getForwardValue(int index) {
        return this.key.get(index);
    }

    public int getBackwardValue(int value) {
        for (int i = 0; i < this.key.size(); i++) {
            if (this.key.get(i) == value) {
                return i;
            }
        }

        return 0;
    }

    private HashMap cloneMap(HashMap<Integer, Integer> map) {
        HashMap<Integer, Integer> newMap = new HashMap<>();
        newMap.putAll(map);
        return newMap;
    }
}
