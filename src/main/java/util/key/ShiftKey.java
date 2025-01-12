package util.key;

public class ShiftKey implements Key {
    private String keyString = null;
    private KeyType keyType = null;
    private int key = -1;

    public ShiftKey() {
    }

    @Override
    public void setKey(String keyString, String type) {
        this.keyString = keyString;
        this.key = Integer.parseInt(keyString);
        this.keyType = KeyType.parse(type);

        // update bounds as key values change
        if (this.key < 0 || this.key > 125) {
            throw new IllegalArgumentException(keyString + " must be between 0 and 125");
        }

    }

    public int getKey() {
        return this.key;
    }
}
