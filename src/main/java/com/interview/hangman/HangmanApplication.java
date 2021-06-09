package com.interview.hangman;

import com.interview.hangman.entities.Game;
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
        Scanner input = new Scanner(System.in);

        Word word = context.getBean(Word.class);
        word.setValue(GeneratorFactory.getGenerator(input.next()).generateNextWord());

        Game game = context.getBean(Game.class);
        game.setWord(word);
        game.setErrorsAllowedNo(10);
        game.play();
    }

}
