package com.interview.hangman.entities;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
@Scope("prototype")
public class Word {

    @Getter
    private String value;
    private char[] charactersFound;
    private List<String> enteredLetters;
    @Getter
    private int errorsNo;

    @PostConstruct
    private void init() {
        enteredLetters = new ArrayList<>();
        errorsNo = 0;
    }

    public void setValue(String value) {
        this.value = value;
        this.charactersFound = new char[this.value.length()];
        for (int i = 0; i < charactersFound.length; i++) {
            this.charactersFound[i] = '_';
        }
    }


    public void replaceUnderscoreCharacter(String triedCharacter) {
        if (!this.enteredLetters.contains(triedCharacter)) {
            if (this.value.contains(triedCharacter)) {
                int index = this.value.indexOf(triedCharacter);

                while (index >= 0) {
                    charactersFound[index] = triedCharacter.charAt(0);
                    index = this.value.indexOf(triedCharacter, index + 1);
                }
            } else {
                errorsNo++;
            }

            this.enteredLetters.add(triedCharacter);
        }
    }

    public String getContent() {
        StringBuilder content = new StringBuilder();

        for (int i = 0; i < this.charactersFound.length; i++) {
            content.append(this.charactersFound[i]);

            if (i < this.charactersFound.length - 1) {
                content.append(" ");
            }
        }

        return content.toString();
    }

    public boolean wasFound() {
        return this.value.contentEquals(new String(charactersFound));
    }
}
