package org.wordcount;

import java.util.HashMap;
import java.util.Map;

public class Counter {

    public Map<String, Integer> countOccurrences(String text) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : text.split(" ")) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
        }

        return map;
    }
}
