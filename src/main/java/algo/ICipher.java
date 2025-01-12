package algo;

import java.nio.file.Path;

public interface ICipher {
    String encrypt(Path plainTextFile);

    String decrypt(Path cipherTextFile);
}
