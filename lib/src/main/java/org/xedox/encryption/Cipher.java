package org.xedox.encryption;

import java.util.Random;
import java.util.HashMap;

public final class Cipher {

    private static String SYMBOLS =
            "1234567890qwertyuiopasdfghjklzxcvbnm,.QWERTYUIOPASDFGHJKLZXCVBNM+=/_<>[]!@#$%^&*()-'\":;,?`~\\|{}€£¥₩°•○●□■♤♡◇♧☆▪︎¤《》¡¿";
    // possible symbols
    
    public static void setPossibleSymbols(String new) {
        SYMBOLS = new;
    }
    
    private static HashMap<Character, Character> keys;

    public static String encrypt(String text) {
        keys = new HashMap<>();
        StringBuilder encryptedText = new StringBuilder();

        for (int pos = 0; pos < text.length(); pos++) {
            char current = text.charAt(pos);
            if (!keys.containsKey(current)) {
                char random = getRandomChar(SYMBOLS);
                while (keys.containsKey(random)) {
                    random = getRandomChar(SYMBOLS);
                }
                keys.put(current, random);
            }
            encryptedText.append(keys.get(current));
        }

        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText) {
        StringBuilder decryptedText = new StringBuilder();
        for (int pos = 0; pos < encryptedText.length(); pos++) {
            char current = encryptedText.charAt(pos);
            boolean found = false;
            for (Character key : keys.keySet()) {
                if (keys.get(key) == current) {
                    decryptedText.append(key);
                    found = true;
                    break;
                }
            }
            if (!found) {
                decryptedText.append(current);
            }
        }
        return decryptedText.toString();
    }

    public static final char getRandomChar(String text) {
        return text.charAt(new Random().nextInt(text.length()));
    }
}
