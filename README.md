# 🤖 JBot - Java AI Chatbot

SmartBot is an intelligent chatbot built in Java using **Machine Learning**, **Natural Language Processing**, **Fuzzy Matching**, and **Wikipedia integration**. It detects user intents, answers general knowledge questions, and can be extended with speech and a GUI.

---

## 🚀 Features

- 🧠 **ML-Based Intent Detection** using Weka (Naive Bayes)
- 🤝 **Fuzzy Matching Fallback** for ambiguous inputs
- 📚 **Wikipedia Integration** to answer real-world knowledge questions
- 💬 **Basic Conversation Handling** (greetings, farewells, etc.)
- 🔄 **Multi-tier Intent Processing**: ML → Fuzzy → Rule-based
- 🧪 Modular design – easy to plug in TTS, voice input, GUI, or more NLP

---

## 🛠️ Tech Stack

| Tech               | Description                                    |
|--------------------|------------------------------------------------|
| Java               | Core programming language                      |
| Weka               | Machine Learning (Intent Classification)       |
| Wikipedia REST API | Knowledge-based responses                      |
| Apache HttpClient  | API calls to Wikipedia                         |
| org.json           | JSON parsing from Wikipedia                    |

---

## 🧩 Project Structure

```
java-chatbot/
│
├── src/main/java/com/chatbot/
│   ├── App.java              # Main bot logic
│   ├── MLIntentDetector.java # Weka-based intent prediction
│   ├── FuzzyMatcher.java     # Fuzzy keyword matching fallback
│   ├── IntentDetector.java   # Rule-based intent detection
│   ├── WikiSearcher.java     # Wikipedia API fetcher
│   ├── ResponseGenerator.java# Returns responses to known intents
│   └── NLPProcessor.java     # (Optional NLP processing)
│
├── src/main/resources/
│   └── intent_dataset.arff   # Training data for Weka
│
├── pom.xml                  # Maven dependencies
└── README.md
```

---

## 🧪 Sample Interaction

```
🤖 SmartBot is ready. Type something...

You: hello  
Bot: Hello! How can I help you today?

You: who is ada lovelace  
Bot: Ada Lovelace was an English mathematician and writer...

You: buk flight  
Bot: Sure! Where would you like to fly to?

You: goodbye  
Bot: Goodbye! Have a great day!
```

---

## 🧠 ML Model (Weka)

The `intent_dataset.arff` file is used to train a **NaiveBayes classifier** which predicts intents such as:
- `greet`
- `goodbye`
- `book_flight`
- `ask_knowledge`
- `unknown`

---

## ▶️ Run Instructions

Make sure you're using Java 8+ and Maven installed.

```bash
# Compile the project
mvn clean install

# Run the chatbot
mvn exec:java -Dexec.mainClass="com.chatbot.App"
```

---

## 📦 Dependencies

In `pom.xml`:

- `weka-stable`
- `org.apache.httpcomponents:httpclient`
- `org.json:json`

---

## 🔮 Future Ideas

- 🗣️ Voice input & TTS response
- 🧠 Context tracking for follow-ups
- 🌐 GUI with JavaFX or Web interface
- 🧪 Chat history and analytics

---

## 📄 License

This project is open-source and free to use for educational purposes.

---

## 🤝 Contributing

Pull requests are welcome! Feel free to fork the repo and submit enhancements.

---

## 💡 Author

Made by Naman Neelabh
