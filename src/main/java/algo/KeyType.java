package algo;

public enum KeyType {
    ShiftCipher, SubstitutionCipher;

    public static KeyType parse(String type) {
        return switch (type) {
            case "Shift Cipher" -> ShiftCipher;
            case "Substitution Cipher" -> SubstitutionCipher;
            default -> throw new IllegalArgumentException("Invalid key type: " + type);
        };
    }
}
