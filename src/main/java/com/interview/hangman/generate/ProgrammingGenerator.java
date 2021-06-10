package com.interview.hangman.generate;

import com.interview.hangman.enums.StackOptions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProgrammingGenerator extends Generator {
    @Override
    public List<String> generateWords() {
        return Arrays.asList("JAVA", "GOLANG", "PYTHON", "RUBY", "SCALA", "KOTLIN", "NET", "NODE", "TYPESCRIPT", "JAVASCRIPT");
    }

    @Override
    public String getType() {
        return StackOptions.PROGRAMMING.getValue();
    }
}
