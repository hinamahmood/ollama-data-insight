package com.hina.ollama;

import java.io.*;
import java.util.*;

public class DataAnalyzer {
    public static Map<String, Double> summarizeCSV(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String header = reader.readLine();
        String[] columns = header.split(",");
        Map<String, Integer> countMap = new HashMap<>();
        int rows = 0;

        while (reader.readLine() != null) {
            rows++;
        }

        reader.close();
        Map<String, Double> summary = new HashMap<>();
        summary.put("rows", (double) rows);
        summary.put("columns", (double) columns.length);
        return summary;
    }
}
