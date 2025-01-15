package algo;

public enum KeyType {
    ShiftCipher, SubstitutionCipher, TranspositionCipher;

    public static KeyType parse(String type) {
        return switch (type) {
            case "Shift Cipher" -> ShiftCipher;
            case "Substitution Cipher" -> SubstitutionCipher;
            case "Transposition Cipher" -> TranspositionCipher;
            default -> throw new IllegalArgumentException("Invalid key type: " + type);
        };
    }

    public static boolean equals(KeyType type1, KeyType type2) {
        return type1.equals(type2);
    }
}
