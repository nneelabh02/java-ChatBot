package com.chatbot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynonymHandler {
    private final Map<String, List<String>> synonyms = new HashMap<>();

    public SynonymHandler() {
        synonyms.put("greeting", Arrays.asList("hello", "hi", "hey", "greetings"));
        synonyms.put("book_flight", Arrays.asList("book", "reserve", "schedule"));
        synonyms.put("flight", Arrays.asList("flight", "plane", "ticket"));
        synonyms.put("weather_info", Arrays.asList("weather", "climate", "forecast"));
        synonyms.put("goodbye", Arrays.asList("bye", "goodbye", "see you"));
    }

    public String mapToIntent(List<String> lemmas) {
        for (String lemma : lemmas) {
            for (Map.Entry<String, List<String>> entry : synonyms.entrySet()) {
                for (String keyword : entry.getValue()) {
                    if (fuzzyMatch(lemma, keyword)) {
                        return entry.getKey();
                    }
                }
            }
        }
        return "unknown";
    }

    private boolean fuzzyMatch(String input, String keyword) {
        int threshold = 1; // max 1 char difference allowed
        int distance = org.apache.commons.text.similarity.LevenshteinDistance.getDefaultInstance()
                        .apply(input.toLowerCase(), keyword.toLowerCase());
        return distance <= threshold;
    }
}
