package org.xedox.encryption;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CipherTest {

    @Test
    void encryptDecryptTest() {
        String text = "Testing";

        String encrypted = Cipher.encrypt(text);
        String decrypted = Cipher.decrypt(encrypted);

        System.out.println("source: " + text);
        System.out.println("encrypted text: " + encrypted);
        System.out.println("decrypted text: " + decrypted);
        assertEquals(text, decrypted);
    }
}
