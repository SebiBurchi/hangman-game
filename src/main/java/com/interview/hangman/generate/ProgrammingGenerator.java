package com.interview.hangman.generate;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProgrammingGenerator extends Generator {
    @Override
    public List<String> generateWords() {
        return Arrays.asList("JAVA", "GOLANG", "PYTHON", "RUBY");
    }

    @Override
    public String getType() {
        return "Programming";
    }
}
