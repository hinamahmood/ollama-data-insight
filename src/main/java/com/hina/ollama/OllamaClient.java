package com.hina.ollama;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class OllamaClient {
    private static final String OLLAMA_API_URL = "http://localhost:11434/api/generate";

    public static String askOllama(String prompt, String model) throws IOException {
        String jsonInput = String.format("{\"model\":\"%s\", \"prompt\":\"%s\"}", model, prompt);
        URL url = new URL(OLLAMA_API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonInput.getBytes(StandardCharsets.UTF_8));
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
}
