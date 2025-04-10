package com.chatbot;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class FuzzyMatcher {

    private final Map<String, String> phraseToIntent = new HashMap<>();
    private final LevenshteinDistance distance = new LevenshteinDistance();

    public FuzzyMatcher() {
        phraseToIntent.put("hello", "greeting");
        phraseToIntent.put("hi there", "greeting");
        phraseToIntent.put("book me a ticket", "book_flight");
        phraseToIntent.put("what’s the weather", "weather_info");
        phraseToIntent.put("bye", "goodbye");
        phraseToIntent.put("see you later", "goodbye");
        phraseToIntent.put("who is", "ask_knowledge");
        phraseToIntent.put("what is", "ask_knowledge");
        phraseToIntent.put("tell me about", "ask_knowledge");
        phraseToIntent.put("define", "ask_knowledge");

    }

    public String match(String input) {
        input = input.toLowerCase();
        for (String phrase : phraseToIntent.keySet()) {
            if (input.contains(phrase)) {
                return phraseToIntent.get(phrase);
            }
        }
        return "unknown";
    }
    

}
