package com.chatbot;

public class ResponseGenerator {
    public String generate(String intent) {
        return switch (intent) {
            case "greeting" -> "Hello! How can I assist you today?";
            case "book_flight" -> "Sure, I can help you book a flight. Where are you heading?";
            case "weather_info" -> "Please tell me which city's weather you'd like to know.";
            case "goodbye" -> "Goodbye! Have a great day.";
            default -> "I'm sorry, I didn't understand that. Could you rephrase?";
        };
    }
}
