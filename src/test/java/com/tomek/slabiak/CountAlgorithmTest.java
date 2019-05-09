package com.tomek.slabiak;

import com.tomek.slabiak.task1.CountAlgorithm;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountAlgorithmTest {

    @Test
    public void shouldReturnTwoIfStringWasAddedTwoTimes(){
        CountAlgorithm algorithm = new CountAlgorithm();
        algorithm.add("cat");
        algorithm.add("cat");
        int catCount = algorithm.count("cat");
        assertEquals(2,catCount);
    }

    @Test
    public void shouldReturnZeroIfStringWasNotAdded(){
        CountAlgorithm algorithm = new CountAlgorithm();
        int catCount = algorithm.count("cat");
        assertEquals(0,catCount);
    }
}
