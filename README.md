# hangman-game
This is a Spring Boot application that solves the Hanging game

**How the game is implemented**:
    
- a random word is selected from a statement array of words initialized to the statement (minimum
10 words)
- a maximum number of attempts is set
- at the beginning it shows how many letters it has with "-"
- if a letter has been guessed, replace "-" with the letter, on all its positions
- if a letter has not been guessed, go to a list of wrong letters that will be displayed to the user
- if you enter a letter that has been entered before, ignore it
- if all the letters have been guessed or if the maximum number of attempts has been reached, go
  to end of the game
  
- the game for a new word resumes
- the player will have a score that will be displayed after each word (guessed / missed); when a
  word is guessed, the score will increase by 10

**Prerequisites**: To run the application, you need java installed, as well as maven

**How to run**: After clone, run `make build` in the local project. This will run the Spring Boot application packaging it to an executable JAR

**How to use**: Run `make hangman` in the project directory. The previous step is mandatory here.

**Example:**

Select your preferred stack: Programming/Devops

Programming

Word: _ _ _ _

Write a character:
h

H _ _ _

!! Remaining attempts: 10

Write a character:
e

H E _ _

!! Remaining attempts: 10

Write a character:
l

H E L _

!! Remaining attempts: 10

Write a character:
m

H E L M

You win!

Your score now is: 10

Get other word?: yes/no
