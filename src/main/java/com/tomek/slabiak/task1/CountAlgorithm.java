package com.tomek.slabiak.task1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountAlgorithm {

    private Map<String, Integer> stringCounts;

    public CountAlgorithm(){
        stringCounts = new HashMap<>();
    }

    public void add(String input){

        if(!stringCounts.containsKey(input)){
            stringCounts.put(input,1);
        } else {
            stringCounts.put(input,stringCounts.get(input)+1);
        }
    }
    public int count(String input){
        if(stringCounts.containsKey(input)){
            return stringCounts.get(input);
        } else{
            return 0;
        }
    }
}
