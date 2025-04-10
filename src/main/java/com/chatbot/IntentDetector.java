package com.chatbot;

import java.util.List;

public class IntentDetector {
    private final SynonymHandler synonymHandler = new SynonymHandler();

    public String detectIntent(List<String> lemmas) {
        return synonymHandler.mapToIntent(lemmas);
    }
}
