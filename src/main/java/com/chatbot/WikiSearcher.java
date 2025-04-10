package com.chatbot;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;

public class WikiSearcher {
    private String cleanQuery(String input) {
        input = input.toLowerCase();
        input = input.replaceAll("(?i)(who is|what is|tell me about|define)\\s+", "");
        return input.trim();
    }
    

    public String search(String query) {
        query = cleanQuery(query);
        String formattedQuery = query.replace(" ", "%20");
        String url = "https://en.wikipedia.org/api/rest_v1/page/summary/" + formattedQuery;
    
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            String response = httpClient.execute(request, httpResponse ->
                EntityUtils.toString(httpResponse.getEntity())
            );
    
            JSONObject json = new JSONObject(response);
            if (json.has("extract")) {
                return json.getString("extract");
            } else {
                return "I couldn't find anything on that topic.";
            }
        } catch (Exception e) {
            return "Sorry, I had trouble looking that up.";
        }
    }
    
}
