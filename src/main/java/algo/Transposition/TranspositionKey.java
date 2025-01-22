package algo.Transposition;

import algo.IKey;
import algo.KeyType;
import util.CharBlock;
import util.CharInt;
import util.WrapAround;

import java.util.ArrayList;
import java.util.HashMap;

public class TranspositionKey implements IKey {
    private KeyType keyType = null;
    private int blockSize;
    private HashMap<Integer, Integer> key = new HashMap<>();
    private ArrayList<CharBlock> charBlocks = new ArrayList<>();

    @Override
    public void setKey(String keyString, String type) {
        this.keyType = KeyType.parse(type);
        for (int i = 0; i < keyString.length() - 1; i ++) {
            key.put(i, (int) keyString.charAt(i));
        }
        this.blockSize = keyString.charAt(keyString.length() - 1);
    }

    public void setBlocks(ArrayList<CharBlock> charBlocks) {
        this.charBlocks = charBlocks;
//        for (CharBlock cb : charBlocks) {
//            cb.setLocation();
//        }
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
    public CharInt getForwardCharInt(CharInt ci, int blockPosition) {
        return new CharInt(WrapAround.wrap(ci.getIndex() + key.get(ci.getIndex()), key.size()));
    }

    @Override
    public CharInt getForwardCharInt(CharInt ci) {
        return new CharInt(-1);
    }

    @Override
    public CharInt getBackwardCharInt(CharInt ci) {
        return new CharInt(-1);
    }
}
