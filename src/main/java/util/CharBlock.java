package util;

import java.util.ArrayList;

public class CharBlock {
    private final ArrayList<CharInt> block;
    private int[] location;

    public CharBlock() {
        this.block = new ArrayList<>();
    }

    public CharBlock(ArrayList<CharInt> block) {
        this.block = block;
    }

    public void addCharInt(CharInt ci) {
        block.add(ci);
    }

    public void addCharInt(int i) {
        block.add(new CharInt(i));
    }

    public void addCharInt(Character c) {
        block.add(new CharInt(c));
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public ArrayList<CharInt> getBlock() {
        return new ArrayList<>(block);
    }
}
