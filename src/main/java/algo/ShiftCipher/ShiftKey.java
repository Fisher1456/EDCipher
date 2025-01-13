package algo.ShiftCipher;

import algo.IKey;
import algo.KeyType;

public class ShiftKey implements IKey {
    private KeyType keyType = null;
    private int key = -1;

    public ShiftKey() {
    }

    @Override
    public void setKey(String keyString, String type) {
        this.key = Integer.parseInt(keyString);
        this.keyType = KeyType.parse(type);
    }

    public int getForwardShift() {
        return this.key;
    }

    public int getBackwardShift() {
        return this.key;
    }
}
