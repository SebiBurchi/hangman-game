package com.interview.hangman.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StackOptions {

    PROGRAMMING("Programming"),
    DEVOPS("Devops");

    @Getter private final String value;
}
