package com.user.UserModule.util;

import java.security.SecureRandom;

public class UniqueIdGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateUniqueId() {
        StringBuilder uniqueId = new StringBuilder("U");

        // Get current timestamp in milliseconds
        long timestamp = System.currentTimeMillis();
        String timestampStr = Long.toString(timestamp);
        
        // Take last 4 digits of the timestamp
        String timePart = timestampStr.substring(timestampStr.length() - 4);

        uniqueId.append(timePart);

        // Add random characters to ensure the total length is 7
        int randomLength = 2; // As we already have 'U' + 4 characters from timestamp
        for (int i = 0; i < randomLength; i++) {
            int index = secureRandom.nextInt(CHARACTERS.length());
            uniqueId.append(CHARACTERS.charAt(index));
        }

        return uniqueId.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateUniqueId());
    }
}
