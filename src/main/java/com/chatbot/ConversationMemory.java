package com.chatbot;

import java.util.HashMap;
import java.util.Map;

public class ConversationMemory {
    private String lastIntent = "unknown";
    private final Map<String, String> slots = new HashMap<>();

    public void setLastIntent(String intent) {
        this.lastIntent = intent;
    }

    public String getLastIntent() {
        return lastIntent;
    }

    public void setSlot(String key, String value) {
        slots.put(key, value);
    }

    public String getSlot(String key) {
        return slots.get(key);
    }

    public void clear() {
        lastIntent = "unknown";
        slots.clear();
    }

    public Map<String, String> getAllSlots() {
        return slots;
    }
}
