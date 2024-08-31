package org.xedox.encryption;

import java.util.Random;
import java.util.HashMap;

public final class Cipher {

    private String SYMBOLS =
            "1234567890qwertyuiopasdfghjklzxcvbnm";
    // possible symbols // default values
    
    public void setPossibleSymbols(String newSymbols) {
        SYMBOLS = newSymbols;
    }
    
    public Cipher(String symbols) {
        this.SYMBOLS = symbols;
        keys = new HashMap<>();
    }
    
    private HashMap<Character, Character> keys;

    public String encrypt(String text) {
        
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

    public String decrypt(String encryptedText) {
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

    public final char getRandomChar(String text) {
        return text.charAt(new Random().nextInt(text.length()));
    }
}
