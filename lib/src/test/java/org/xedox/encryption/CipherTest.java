package org.xedox.encryption;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CipherTest {

    @Test
    void encryptDecryptTest() {
        String text = "Hello from test!";
        
        Cipher cipher = new Cipher("1234567890 +=/_<>[]!@#$%^&*\"()-'\\:;,?{}₩♧◇¥£♡♤€■□●○|~`°•☆▪︎¤《》¡¿");

        String encrypted = cipher.encrypt(text);
        String decrypted = cipher.decrypt(encrypted);

        System.out.println("source: " + text);
        System.out.println("encrypted: " + encrypted);
        System.out.println("decrypted: " + decrypted);
        assertEquals(text, decrypted);
    }
}
