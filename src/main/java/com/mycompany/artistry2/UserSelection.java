
package com.mycompany.artistry2;

import java.util.Map;
import java.util.TreeMap;

public class UserSelection {
    
    private TreeMap<Integer, String> filters;

    public UserSelection() {
        filters = new TreeMap<>();
    }
    
    public void addFilter(String filter) {
        if (filters.isEmpty()) {
            filters.put(0, filter);
        }
        else {
            filters.put(filters.lastKey() + 1, filter);
        }
      
    }
    
    public void removeFilter(String filter) {
        Integer keyToRemove = null;
        for (Map.Entry<Integer, String> entry : filters.entrySet()) {
            if ((entry.getValue()).equals(filter)) {
                keyToRemove = entry.getKey();
                break;
            }
        }
        
        if (keyToRemove != null) {
            filters.remove(keyToRemove);
        }
    }
    
    public void clearFilters() {
        filters.clear();
    }
    
    public TreeMap getFilters() {
        return filters;
    }
    
    
}
