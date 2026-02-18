package com.homework;

import java.util.Random;

public class WordInfo {
    private final String[][][] words = {{{"кот", "пёс", "лев"},
            {"тигр", "зебра", "кролик"},
            {"крокодил", "хамелеон", "муравьед"}
            },
            {
            {"суп", "сыр", "рис"},
            {"хлеб", "борщ", "яйцо"},
            {"баклажан", "картофель", "котлета"}
            },
            {
            {"пеле", "месси", "роналду"},
            {"мбаппе", "неймар", "роналдиньо"},
            {"мальдини", "кержаков", "зидан"}
            }};

    private final Integer[] attemptsByDifficulty = {7, 6, 5};

    public Session createSession(Integer category, Integer difficulty) {
        String[] wordList = words[category][difficulty];
        final Random random = new Random();
        String word = wordList[random.nextInt(wordList.length)];
        Integer maxAttempts = attemptsByDifficulty[difficulty];
        return new Session(word, maxAttempts);
    }
}
