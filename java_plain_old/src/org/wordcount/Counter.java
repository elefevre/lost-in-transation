package org.wordcount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Counter {

    public static void main(String[] argv) throws IOException {
        String filename = argv[0];

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

        Map<String, Integer> results = new Counter().countOccurrences(text);
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

    public Map<String, Integer> countOccurrences(String text) {
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
