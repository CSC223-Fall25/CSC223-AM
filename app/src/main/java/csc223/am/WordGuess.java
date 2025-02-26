
package csc223.am;

import java.util.Scanner;

public class WordGuess implements Game{
    String answer = "egret";
    boolean char_1 = false;
    boolean char_2 = false;
    boolean char_3 = false;
    boolean char_4 = false;
    boolean char_5 = false;
    int guesses = 10;
    public void startGame(){
        printBoard();
    }
    public void printBoard(){
        String out = "";
        for (int i = 0; i < this.answer.length(); i++){
            switch (i) {
                case 0:
                    if(this.char_1 == true){
                        out += this.answer.charAt(i);
                    } else {
                        out += '_';
                    }
                    break;

                case 1:
                    if(this.char_2 == true){
                        out += this.answer.charAt(i);
                    } else {
                        out += '_';
                    }
                    break;

                case 2:
                    if(this.char_3 == true){
                        out += this.answer.charAt(i);
                    } else {
                        out += '_';
                    }
                    break;

                case 3:
                    if(this.char_4 == true){
                        out += this.answer.charAt(i);
                    } else {
                        out += '_';
                    }
                    break;

                case 4:
                    if(this.char_5 == true){
                        out += this.answer.charAt(i);
                    } else {
                        out += '_';
                    }
                    break;
                
            }
        }
            System.out.println(out);
            takeTurn();
        
    }
    public void takeTurn(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(this.guesses + " guesses remaining! Guess a letter: ");
        String curr = scanner.nextLine();
        scanner.close();
        for (int i = 0; i < this.answer.length(); i++){
            if (curr.charAt(0) == this.answer.charAt(i)){
                switch (i) {
                    case 0:
                        this.char_1 = true;
                        break;
                    case 1:
                        this.char_2 = true;
                        break;
                    case 2:
                        this.char_3 = true;
                        break;
                    case 3:
                        this.char_4 = true;
                        break;
                    case 4:
                        this.char_5 = true;
                        break;
                    }
                }
            }
        this.guesses -= 1;
        isGameOver();
    }
    public boolean isGameOver(){
        if (this.guesses == 0){
            if (this.char_1 == false){
                endGame();
            } else if (this.char_2 == false){
                endGame();
            } else if (this.char_3 == false){
                endGame();
            } else if (this.char_4 == false){
                endGame();
            } else if (this.char_5 == false){
                endGame();
            }
        }

        return false;
    }
    public void endGame(){
        if (this.char_1 == true){
            if (this.char_2 == true){
                if (this.char_3 == true){
                    if (this.char_4 == true){
                        if (this.char_5 == true){
                            System.out.println("Good job! You guessed the word " + this.answer + " in " + this.guesses + " guesses!");
                        }
                    }
                }
            }
        } else {
            System.out.println("Sorry, you didn't guess it right! The word was " + this.answer);
        }

    }
    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to play Word Guess? Enter Y or N: ");
        String req = scanner.nextLine();
        scanner.close();
        if (req.charAt(0) == 'Y'){
            if (req.length() == 1){
                System.out.println("Starting game now: ");
                startGame();
            }
        } else {
            System.out.println("See you next time.");
        }
    }
    public static void main(String[] args) {
        WordGuess wordle = new WordGuess();
        wordle.playGame();
    }
}