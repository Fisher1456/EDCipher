package algo.ShiftCipher;

import algo.Cipher;
import algo.IKey;
import algo.Key;
import algo.KeyType;
import util.CharInt;
import util.WrapAround;

public class ShiftKey extends Key implements IKey {
    private KeyType keyType = null;
    private int shift = -1;

    public ShiftKey() {
    }

    @Override
    public void setKey(String keyString, String type) {
        this.shift = WrapAround.wrap(Integer.parseInt(keyString));
        this.keyType = KeyType.parse(type);
    }

    @Override
    public CharInt getForwardCharInt(CharInt ci) {
        return new CharInt(WrapAround.wrap(ci.getIndex() + shift));
    }

    @Override
    public CharInt getBackwardCharInt(CharInt ci) {
        return new CharInt(WrapAround.wrap(ci.getIndex() - shift));
    }
}
