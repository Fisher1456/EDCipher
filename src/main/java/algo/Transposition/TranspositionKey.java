package algo.Transposition;

import algo.IKey;
import algo.KeyType;
import util.CharInt;

import java.util.ArrayList;

public class TranspositionKey implements IKey {
    private KeyType keyType = null;
    private int blockSize;
    private final ArrayList<Integer> key = new ArrayList<>();

    @Override
    public void setKey(String keyString, String type) {
        this.keyType = KeyType.parse(type);
        for (int i = 0; i < keyString.length(); i ++) {
            key.add((int) keyString.charAt(i));
        }
    }

//    private String permute(String input, int blockSize) {
//        int numOfBlocks = input.length() / blockSize;
//
//        StringBuilder ib = new StringBuilder(input);
//        ib.append("!".repeat(Math.max(0, ib.length() % blockSize)));
//        input = ib.toString();
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < numOfBlocks; i ++) {
//            sb.append(input, i, blockSize);
//            sb.append("\n");
//        }
//
//        return sb.toString();
//    }


    @Override
    public CharInt getForwardCharInt(CharInt ci) {
        return null;
    }

    @Override
    public CharInt getBackwardCharInt(CharInt ci) {
        return null;
    }
}
