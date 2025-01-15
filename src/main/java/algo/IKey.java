package algo;

import util.CharInt;

public interface IKey {
    void setKey(String keyString, String type);

    CharInt getForwardCharInt(CharInt ci);

    CharInt getBackwardCharInt(CharInt ci);
}
