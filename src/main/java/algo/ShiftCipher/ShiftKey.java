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

        // update bounds as key values change
        if (this.key < 0 || this.key > 25) {
            throw new IllegalArgumentException(keyString + " must be between 0 and 25");
        }

    }

    public int getKey() {
        return this.key;
    }
}
