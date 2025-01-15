package algo.Substitution;

import algo.Cipher;
import algo.IKey;
import algo.KeyType;
import util.CharInt;
import util.WrapAround;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SubstitutionKey implements IKey {
    private KeyType keyType = null;
    private final HashMap<CharInt, CharInt> key = new HashMap<>();

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
                key.put(new CharInt(j), new CharInt(WrapAround.wrap(j + shift)));
                j ++;

                tempKey = new StringBuilder();
                continue;
            }

            tempKey.append(keyString.charAt(i));
        }

        if (key.size() < 26) {
            for (int i = key.size(); i < 26; i ++) {
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
}
