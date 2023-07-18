package com.mycompany.tttgame;

import java.util.Scanner;

public class TTTGame {
    TicTacToe game = new TicTacToe(); // For all TTT board related tasks.
    char winner; // Who won? - For storing the Winner
    
    /*
    * Start the game
    * Display the results after it is completed.
    */
    public void startGame() {
        game.displayBoard();        //display initial Board
        playGame();                 //starting the game
        winner = game.getWinner();  //if game ends it gets the winner
        printMessage();             //print the winning message
    }
    
    /*
    * Scanner class is used to get [row,col] from standard input
    * Game is completed if there is a winner or 9 moves have been made.
    */
    public void playGame(){
        Scanner in = new Scanner(System.in);
        int count = 0; // Count number of turns. If it is 9 it is a draw.
        char turn; // Is it X's turn or O's turn?
        int row, col; // Hold board position.
        // while no one has won and not yet a draw
        while(game.getWinner() == ' ' && count<9){
            turn = game.whoseTurn();
            System.out.println(turn+"'s turn. Type row and col:");
            do {
                row = in.nextInt();
                col = in.nextInt();
                System.out.println("check");
            }while(game.getMark(row,col)!=' '); // Is this cell empty?
            game.putMark(row, col);
            game.displayBoard();
            count++;
        }
        in.close();
    }
    /*
    * Print Win or Draw message.
    */
    public void printMessage() {
        if(winner=='X')
            System.out.println("X has won!");
        else if(winner=='O')
            System.out.println("O has won!");
        else
            System.out.println("It's a draw!");
    }
    
    
    public static void main(String[] args){
        TTTGame ttt = new TTTGame();
        ttt.startGame();
    }
}
