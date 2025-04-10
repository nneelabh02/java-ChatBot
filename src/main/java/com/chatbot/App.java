package com.chatbot;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        FuzzyMatcher fuzzyMatcher = new FuzzyMatcher();
        WikiSearcher wiki = new WikiSearcher();

        Scanner scanner = new Scanner(System.in);
        NLPProcessor nlp = new NLPProcessor();
        IntentDetector detector = new IntentDetector();
        ResponseGenerator responder = new ResponseGenerator();

        System.out.println("🤖 SmartBot is ready. Type something...");

        MLIntentDetector mlDetector = null; 
        try {
            mlDetector = new MLIntentDetector(App.class.getResource("/intent_dataset.arff").getPath());

        } catch (Exception e) {
            System.out.println("❌ Failed to load ML model.");
            e.printStackTrace();
            return;
        }

        ConversationMemory memory = new ConversationMemory();

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine();

            String intent = "unknown";
            try {
                intent = mlDetector.predictIntent(input);
            } catch (Exception e) {
                System.out.println("❌ ML prediction failed.");
            }


            if (intent.equals("unknown")) {
                intent = fuzzyMatcher.match(input);
            }

    
            if (intent.equals("unknown") && memory.getLastIntent().equals("book_flight")) {
                memory.setSlot("date", input);  // store response to previous question
                System.out.println("Bot: Got it! Booking your flight for " + input + ".");
                continue;
            }

            memory.setLastIntent(intent);

            switch (intent) {
                case "greeting" ->
                    System.out.println("Bot: Hey there! How can I help you today?");
                case "book_flight" ->
                    System.out.println("Bot: Sure! Where would you like to go?");
                case "ask_knowledge" -> {
                    System.out.println("Bot: Let me look that up...");
                    String answer = wiki.search(input);
                    System.out.println("Bot: " + answer);
                }

                case "weather_info" ->
                    System.out.println("Bot: Which city would you like the weather for?");
                case "goodbye" -> {
                    System.out.println("Bot: Goodbye! 👋");
                    return;
                }
                default ->
                    System.out.println("Bot: I'm not sure I understand.");
            }
        }

    }
}
