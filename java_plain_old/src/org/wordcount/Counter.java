package org.wordcount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class Counter {

    public static void main(String[] argv) throws IOException {
        String text = readTextFromFile(argv[0]);

        Map<String, Integer> results = new Counter().countWordFrequencies(text);

        displayTopWords(results);
    }

    private static String readTextFromFile(String filename) throws IOException {
        String text;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(" ");
                line = br.readLine();
            }
            text = sb.toString();
        } finally {
            br.close();
        }
        return text;
    }

    private static void displayTopWords(Map<String, Integer> results) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(results.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int count = 0;
        for (Map.Entry<String, Integer> word : list) {
            System.out.println(word.getKey() + ": " + word.getValue());
            count++;
            if (count > 25) {
                break;
            }
        }
    }

    public Map<String, Integer> countWordFrequencies(String text) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : text.split(" ")) {
            if (word.length() == 0) {
                continue;
            }
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
        }

        return map;
    }
}
