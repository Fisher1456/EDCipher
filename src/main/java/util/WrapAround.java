package util;

public final class WrapAround {
    public WrapAround() {

    }

    public static int wrap(int input, int max) {
        return wrap(input, 0, max);
    }

    public static int wrap(int input, int min, int max) {
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
