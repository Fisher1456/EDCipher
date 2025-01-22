package algo;

import util.CharInt;

public interface IKey {
    void setKey(String keyString, String type);

    default CharInt getForwardCharInt(CharInt ci, int blockPosition) {
        return new CharInt(-1);
    }

    CharInt getForwardCharInt(CharInt ci);

    CharInt getBackwardCharInt(CharInt ci);
}
