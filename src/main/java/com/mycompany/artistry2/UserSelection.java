/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.artistry2;

import java.util.TreeMap;

/**
 *
 * @author advikarapolu
 */
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
    
    public void clearFilters() {
        filters.clear();
    }
    
    public TreeMap getFilters() {
        return filters;
    }
    
}
