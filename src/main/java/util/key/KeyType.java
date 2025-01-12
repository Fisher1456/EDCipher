package util.key;

public enum KeyType {
    ShiftCipher, SubstitutionCipher;

    public static KeyType parse(String type) {
        switch (type) {
            case "Shift Cipher":
                return ShiftCipher;
            case "Substitution Cipher":
                return SubstitutionCipher;
            default:
                throw new IllegalArgumentException("Invalid key type: " + type);
        }
    }
}
