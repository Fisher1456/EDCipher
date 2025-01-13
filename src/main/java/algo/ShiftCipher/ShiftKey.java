package algo.ShiftCipher;

import algo.Cipher;
import algo.IKey;
import algo.KeyType;
import util.WrapAround;

public class ShiftKey implements IKey {
    private KeyType keyType = null;
    private int key = -1;

    public ShiftKey() {
    }

    @Override
    public void setKey(String keyString, String type) {
        this.key = WrapAround.wrap(Integer.parseInt(keyString), Cipher.letterMod);
        this.keyType = KeyType.parse(type);
    }

    public int getForwardShift() {
        return this.key;
    }

    public int getBackwardShift() {
        return this.key;
    }
}
