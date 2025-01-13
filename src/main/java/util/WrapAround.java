package util;

public final class WrapAround {
    public WrapAround() {

    }

    public static int wrap(int input, int mod) {
        int output = input;

        while (output < 0) {
            output += mod;
        }

        while (output >= mod) {
            output -= mod;
        }

        return output;
    }
}
