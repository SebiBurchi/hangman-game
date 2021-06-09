package com.interview.hangman.generate;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeneratorFactory {

    private static final Map<String, Generator> generatorsCache = new HashMap<>();

    private GeneratorFactory(List<Generator> generators) {
        for (Generator generator : generators) {
            generatorsCache.put(generator.getType(), generator);
        }
    }

    public static Generator getGenerator(String type) {
        Generator generator = generatorsCache.get(type);
        if (generator == null) {
            throw new RuntimeException("Unknown generator type: " + type);
        }
        return generator;
    }

}
