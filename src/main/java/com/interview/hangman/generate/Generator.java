package com.interview.hangman.generate;

import java.util.List;
import java.util.Random;

public abstract class Generator {

    abstract List<String> generateWords();

    abstract String getType();

    public String generateNextWord() {
        List<String> words = generateWords();
        return words.get(new Random().nextInt(words.size()));
    }
}