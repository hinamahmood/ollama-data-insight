package com.hina.ollama;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Analyzing dataset...");
            var summary = DataAnalyzer.summarizeCSV("src/main/resources/sample-data.csv");

            String prompt = String.format(
                    "This dataset has %d rows and %d columns. Provide insights or visualization ideas for educational data.",
                    summary.get("rows").intValue(), summary.get("columns").intValue()
            );

            System.out.println("Querying Ollama...");
            String response = OllamaClient.askOllama(prompt, "llama3");

            System.out.println("\n=== AI-Generated Insights ===\n");
            System.out.println(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
