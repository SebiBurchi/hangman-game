package com.interview.hangman.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@NoArgsConstructor
@Component
public class Game {

    private Word word;
    private int score;
    @Getter
    private boolean newGame;
    @Setter
    private int errorsAllowedNo;

    @PostConstruct
    private void init() {
        this.newGame = true;
    }

    @Autowired
    public void setWord(Word word) {
        this.word = word;
    }

    public void play(Scanner input) {
        System.out.println("\n" + this.word.getContent());
        while (this.word.getErrorsNo() < errorsAllowedNo) {
            System.out.println("\nWrite a character: ");
            String letter = "";
            if (input.hasNext()) {
                letter = input.next();
            }

            if (letter.length() != 1) {
                System.out.println("\nOnly one letter must be entered");
                continue;
            }

            letter = letter.toUpperCase();

            this.word.replaceUnderscoreCharacter(letter);

            System.out.println("\n" + this.word.getContent());

            if (this.word.wasFound()) {
                this.score += 10;
                System.out.println("\nYou win!");
                System.out.println("\nYour score now is: " + this.score);
                this.getNewWord(input);
                break;
            } else {
                System.out.println("\n!! Remaining attempts: " + (this.errorsAllowedNo - this.word.getErrorsNo()));
            }
        }

        if (this.errorsAllowedNo == this.word.getErrorsNo()) {
            System.out.println("\nYou lose!");
            System.out.println("\nYour score is: " + this.score);
            System.out.println("=> Word to find was : " + this.word.getValue());
            this.getNewWord(input);
        }

    }

    private void getNewWord(Scanner input) {
        System.out.println("\nGet other word?: yes/no ");
        String response = "no";
        if (input.hasNext()) {
            response = input.next();
        }
        this.newGame = response.equalsIgnoreCase("yes");

    }
}
