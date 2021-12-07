package com.company.Strategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Search {
    private SearchStrategy searchStrategy;

    public void setSearchStrategy(SearchStrategy strategy) {
        this.searchStrategy = strategy;
    }

    public Set<Integer> search(Map<String, List<Integer>> invertedIndex, String searchTerm ) {
        return this.searchStrategy.search(invertedIndex, searchTerm);
    }
}
