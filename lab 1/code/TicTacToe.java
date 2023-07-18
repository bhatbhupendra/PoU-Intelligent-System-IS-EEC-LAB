package com.mycompany.tttgame;

public class TicTacToe{
    char[][] board = new char[3][3]; // TicTacToe board has 3 rows and 3 columns.
    char PLAYER_1 = 'X';
    char PLAYER_2 = 'O';
    char turn; // Whose turn is it? - current turn

    //the constructure
    public TicTacToe() {
        //Initialize the 2D array.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        turn ='X';  //X always start's first.
    }
    /*
    * Check 3 rows, 3 cols and 2 diagonals for a win
    * If there is a winner return who won : X or O
    * Otherwise return a blank (space) character.
    */
    public char getWinner() {
        //Checking 3 rows, 3 cols and 2 diagonals for a win
        for (int a = 0; a < 8; a++) {
            String line = "";
 
            switch (a) {
            case 0:
                for (int i = 0; i < 3; i++) {
                    line += board[0][i];
                }
                break;
            case 1:
                for (int i = 0; i < 3; i++) {
                    line += board[1][i];
                }
                break;
            case 2:
                for (int i = 0; i < 3; i++) {
                    line += board[2][i];
                }
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    line += board[i][0];
                }
                break;
            case 4:
//                line = board[0][1] + board[1][1] + board[2][1];       //this suppose to work but it's not
                for (int i = 0; i < 3; i++) {
                    line += board[i][1];
                }
                break;
            case 5:
                for (int i = 0; i < 3; i++) {
                    line += board[i][2];
                }
                break;
            case 6:
                for (int i = 0; i < 3; i++) {
                    line += board[i][i];
                }
                break;
            case 7:
                for (int i = 0; i < 3; i++) {
                    line += board[i][2-i];
                }
                break;
            }
            //If there is a winner return who won : X or O
            //For X winner
            if("XXX".equals(line)) {
                return 'X';
            }
             
            // For O winner
            else if ("OOO".equals(line)) {
                return 'O';
            }   
        }
        return ' '; //Otherwise return a blank (space) character.
    }
    
    /*
    * Pretty print the TTT board.
    */
    public void displayBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0][0] + " | "+ board[0][1] + " | " + board[0][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
        System.out.println("|---|---|---|");
    }
    
    /*
    * Return the Player who has to put a mark.
    */
    public char whoseTurn() {
        return turn;
    }
    
    /*
    * Fill the board at [row,col] with X or O
    * depending on whose turn it is
    * then change turn from X to O or O to X.
    */
    public void putMark(int row, int col) {
        board[row][col]=turn;   //Filling board at [row,col] with X or O according 2 turn
        //change turn from X to O or O to X.
        if(turn=='X')
            turn='O';
        else if(turn=='O')
            turn='X';
    }
    
    /*
    * Return the mark at [row,col] in the board.
    */
    public char getMark(int row, int col) {
        return board[row][col];
    }
}