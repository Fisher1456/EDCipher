package util;

import algo.Cipher;

public final class WrapAround {
//    public WrapAround() {
//
//    }

    public static int wrap(int input) {
        return wrap(input, 0, Cipher.CAPITAL_MAX);
    }

    public static int wrap(int input, int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max <= 0");
        }
        return wrap(input, 0, max);
    }

    public static int wrap(int input, int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException("max <= min");
        }

        int output = input;

        while (output < min || output >= max) {
            while (output < min) {
                output += max;
            }

            while (output >= max) {
                output -= (max - min);
            }
        }

        return output;
    }
}
