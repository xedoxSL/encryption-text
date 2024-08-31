package org.xedox;

import org.xedox.encryption.Cipher;

public final class Main {
    public static final void main(String[] args) {
        String text = "Testing";

        String encrypted = Cipher.encrypt(text);
        String decrypted = Cipher.decrypt(encrypted);
        System.out.println("source: " + text);
        System.out.println("encrypted text: " + encrypted);
        System.out.println("decrypted text: " + decrypted);
    }
}
