
package csc223.am;
import java.util.Scanner;
public class TicTacToe implements Game{
    char[] A;
    char[] B;
    char[] C;
    char current_player;
    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello! Player 1, please choose X or O: ");
        String choice = scanner.nextLine();
        scanner.close();
        this.current_player = choice.charAt(0);
        printBoard();
        }

    
    public void printBoard(){
        String out1 = "";
        String out2 = "";
        String out3 = "";
        for (int i = 0; i < 3; i++){
            switch (A[i]){
                case 'X':
                    out1 += this.A[i];
                
                case 'O':
                    out1 += this.A[i];

                default:
                    out1 += '_';
            }
            switch (B[i]){
                case 'X':
                    out2 += this.B[i];
                        
                case 'O':
                    out2 += this.B[i];
                
                default:
                    out2 += '_';
            }
            switch (C[i]){
                case 'X':
                    out3 += this.C[i];
                        
                case 'O':
                    out3 += this.C[i];
                
                default:
                    out3 += '_';
            }
        
        System.out.println(out1);
        System.out.println(out2);
        System.out.println(out3);
        takeTurn();
        }
    }

    public void takeTurn(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(this.current_player + "'s turn! Please input your choice of row and column, eg. A3: ");
        String move = scanner.nextLine();
        scanner.close();
        
        int i = move.charAt(1);
        boolean go = false;
            while (go == false){
            switch (move.charAt(0)){
                case 'A':
                    if (this.A[i] == 'X'){
                        System.out.print("That square is already taken. Please input one that is free: ");
                        move = scanner.nextLine();
                        scanner.close();
                    } else if (this.A[i] == 'O'){
                        System.out.print("That square is already taken. Please input one that is free: ");
                        move = scanner.nextLine();
                        scanner.close();
                    } else {
                        this.A[i] = this.current_player;
                        go = true;
                    }
                    
                case 'B':
                    if (this.B[i] == 'X'){
                        System.out.print("That square is already taken. Please input one that is free: ");
                        move = scanner.nextLine();
                        scanner.close();
                    } else if (this.B[i] == 'O'){
                        System.out.print("That square is already taken. Please input one that is free: ");
                        move = scanner.nextLine();
                        scanner.close();
                    } else {
                        this.B[i] = this.current_player;
                        go = true;
                    }
                    
                case 'C':
                    if (this.C[i] == 'X'){
                        System.out.print("That square is already taken. Please input one that is free: ");
                        move = scanner.nextLine();
                        scanner.close();
                    } else if (this.C[i] == 'O'){
                        System.out.print("That square is already taken. Please input one that is free: ");
                        move = scanner.nextLine();
                        scanner.close();
                    } else {
                        this.C[i] = this.current_player;
                        go = true;
                    }
                }
            }
        if (this.current_player == 'X'){
            this.current_player = 'O';
        } else {
            this.current_player = 'X';
        }
        isGameOver();
    }

    public boolean isGameOver(){
        if (this.A[0] == this.A[1]){
            if (this.A[1] == this.A[2]){
                this.current_player = this.A[0];
                endGame();
                return true;
            }
        } else if (this.A[0] == this.B[0]){
            if (this.B[0] == this.C[0]){
                this.current_player = this.A[0];
                endGame();
                return true;
            }
        } else if (this.A[1] == this.B[1]){
            if (this.B[1] == this.C[1]){
                this.current_player = this.A[1];
                endGame();
                return true;
            }
        } else if (this.A[2] == this.B[2]){
            if (this.B[2] == this.C[2]){
                this.current_player = this.A[2];
                endGame();
                return true;
            }
        } else if (this.B[0] == this.B[1]){
            if (this.B[1] == this.B[2]){
                this.current_player = this.B[0];
                endGame();
                return true;
            }
        } else if (this.C[0] == this.C[1]){
            if (this.C[1] == this.C[2]){
                this.current_player = this.C[0];
                endGame();
                return true;
            }
        } else if (this.A[0] == this.B[1]){
            if (this.B[1] == this.C[2]){
                this.current_player = this.A[0];
                endGame();
                return true;
            }
        } else if (this.A[2] == this.B[1]){
            if (this.B[1] == this.C[0]){
                this.current_player = this.A[2];
                endGame();
                return true;
            }
        }
        return false;
    }
    public void endGame(){
        System.out.println("Good game! The winner was " + this.current_player);
    }
    public void playGame(){
        startGame();
    }
    public static void main(String[] args) {
        TicTacToe newgame = new TicTacToe();
        for (int i = 0; i < 3; i++) {
            newgame.A[i] = 0;
            newgame.B[i] = 0;
            newgame.C[i] = 0;
        }
        newgame.playGame();
    }
}