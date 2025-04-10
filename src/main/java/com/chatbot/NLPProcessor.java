package com.chatbot;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class NLPProcessor {
    private StanfordCoreNLP pipeline;

    public NLPProcessor() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
        pipeline = new StanfordCoreNLP(props);
    }

    public List<String> getLemmas(String text){
        List<String> lemmas = new ArrayList<>();
        CoreDocument doc = new CoreDocument(text);
        pipeline.annotate(doc);
        for (CoreLabel token : doc.tokens()){
            lemmas.add(token.lemma().toLowerCase());
        }
        
        return lemmas;
    }
}
