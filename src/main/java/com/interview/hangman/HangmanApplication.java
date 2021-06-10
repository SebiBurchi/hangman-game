package com.interview.hangman;

import com.interview.hangman.entities.Game;
import com.interview.hangman.enums.StackOptions;
import com.interview.hangman.entities.Word;
import com.interview.hangman.generate.GeneratorFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;


@SpringBootApplication
public class HangmanApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HangmanApplication.class, args);

        System.out.println("\nSelect your preferred stack: Programming/Devops");
        // set default stack type
        String type = StackOptions.PROGRAMMING.getValue();

        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            type = sc.next();
        }

        Game game = context.getBean(Game.class);

        while (game.isNewGame()) {
            Word word = context.getBean(Word.class);
            word.setValue(GeneratorFactory.getGenerator(type).generateNextWord());

            game.setWord(word);
            game.setErrorsAllowedNo(10);
            game.play(sc);
        }
        sc.close();
    }

}
