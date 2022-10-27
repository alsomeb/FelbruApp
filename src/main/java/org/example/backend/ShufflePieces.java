package org.example.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ShufflePieces {
    public List<Integer> getShuffledNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            randomNumberList.add(i);
        }

        Collections.shuffle(randomNumberList);
        return randomNumberList;
    }
}
