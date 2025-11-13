# Ollama Data Insight Assistant
A Java project that integrates with [Ollama](https://ollama.ai) to generate AI-powered insights from structured data files.

## Features
- Summarizes dataset size and structure.
- Sends summary to an LLM for analysis via Ollama API.
- Generates natural-language insights and visualization suggestions.

## Tools & Technologies
- Java 17
- Ollama (local LLM inference)
- REST API, JSON handling
- CSV data parsing

## Run Instructions
1. Install Ollama locally: https://ollama.ai
2. Pull a model (example): `ollama pull llama3`
3. Run the app:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.hina.ollama.App"
