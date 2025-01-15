package algo.Transposition;

import algo.Cipher;
import algo.ICipher;

import java.nio.file.Path;

public class TranspositionCipher extends Cipher implements ICipher  {
    private final TranspositionKey key;
    private final int blockSize;

    public TranspositionCipher(TranspositionKey key, int blockSize) {
        this.key = key;
        this.blockSize = blockSize;
    }

    @Override
    public String encrypt(Path plainTextFile) {
        String plainText = fileToString(plainTextFile);
        StringBuilder cipherText = new StringBuilder();




        return "";
    }

    @Override
    public String decrypt(Path cipherTextFile) {
        String cipherText = fileToString(cipherTextFile);



        return "";
    }
}
