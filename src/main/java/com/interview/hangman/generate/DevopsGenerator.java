package com.interview.hangman.generate;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DevopsGenerator extends Generator {

    @Override
    public List<String> generateWords() {
        return Arrays.asList("KUBERNETES", "DOCKER", "AWS", "JENKINS");
    }

    @Override
    public String getType() {
        return "Devops";
    }
}
