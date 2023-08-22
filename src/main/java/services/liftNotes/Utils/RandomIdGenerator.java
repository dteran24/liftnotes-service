package services.liftNotes.Utils;

import java.util.UUID;

public class RandomIdGenerator {
    public static String generateRandomId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
}}
