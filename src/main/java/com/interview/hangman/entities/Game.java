package com.interview.hangman.entities;


import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@NoArgsConstructor
@Component
public class Game {

    @Setter
    public int errorsAllowedNo;

    private Word word;

    @Autowired
    public void setWord(Word word) {
        this.word = word;
    }

    public void play() {
        try (Scanner input = new Scanner(System.in)) {
            while (this.word.getErrorsNo() < errorsAllowedNo) {
                System.out.println("\nEnter a letter : ");
                String letter = input.next();

                if (letter.length() > 1) {
                    System.out.println("\nOnly one letter must be entered");
                    continue;
                }

                letter = letter.toUpperCase();

                this.word.replaceUnderscoreCharacter(letter);

                System.out.println("\n" + this.word.getContent());

                if (this.word.wasFound()) {
                    System.out.println("\nYou win!");
                    break;
                } else {
                    System.out.println("\n!! Remaining attempts: " + (this.errorsAllowedNo - this.word.getErrorsNo()));
                }
            }

            if (this.errorsAllowedNo == this.word.getErrorsNo()) {
                System.out.println("\nYou lose!");
                System.out.println("=> Word to find was : " + this.word.getValue());
            }
        }
    }
}
