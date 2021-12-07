package com.company.Strategy;

import java.util.*;

public class Any implements SearchStrategy {

    @Override
   public Set<Integer> search(Map<String, List<Integer>> invertedIndex, String searchTerm ){
        String[] words = searchTerm.split(" ");
        Set<Integer> result = new HashSet<>();
        for (String word : words) {
            if (invertedIndex.containsKey(word)) {
                result.addAll(invertedIndex.get(word));
            }
        }
        return result;
    }
}
