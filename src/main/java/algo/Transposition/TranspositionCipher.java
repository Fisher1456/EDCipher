package algo.Transposition;

import algo.Cipher;
import algo.ICipher;
import util.CharBlock;

import java.nio.file.Path;
import java.util.ArrayList;

public class TranspositionCipher extends Cipher implements ICipher  {
    private final TranspositionKey key;
    private final int blockSize;
    private final ArrayList<CharBlock> charBlocks = new ArrayList<>();

    public TranspositionCipher(TranspositionKey key, int blockSize) {
        this.key = key;
        this.blockSize = blockSize;
    }

    @Override
    public String encrypt(Path plainTextFile) {
        StringBuilder plainText = new StringBuilder(fileToString(plainTextFile));
        StringBuilder cipherText = new StringBuilder();

        if (plainText.length() % blockSize != 0) {
            while (plainText.length() % blockSize != 0) {
                plainText.append('!');
            }
        }

        for (int i = 0; i < blockSize; i ++) {
            charBlocks.add(new CharBlock());
            for (int j = 0; j < plainText.length(); j ++) {
                if (j % (blockSize + i) == 1) {
                    charBlocks.get(i).addCharInt(plainText.charAt(j));
                }
            }
        }

        key.setBlocks(charBlocks);





        return "";
    }

    @Override
    public String decrypt(Path cipherTextFile) {
        String cipherText = fileToString(cipherTextFile);



        return "";
    }
}
