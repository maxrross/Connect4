import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        //taking input of size of board
        Scanner scan = new Scanner (System.in);
        System.out.print("What would you like the height of the board to be? ");
        final int ROWS = scan.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        final int COLUMNS = scan.nextInt();

        //declaring, initializing, and printing board
        char[][] board = new char[ROWS][COLUMNS];

        initializeBoard(board);
        printBoard(board);

        //tell players what their respective chip types are
        System.out.println("Player 1: x \nPlayer 2: o\n");

        //repeats for entire game
        while (true) {
            int sCol;
            int sRow;

            //player 1's turn accepts their column input, inserts their chip, prints the board, then checks if they won the game based on that chip placement.
            //if they won the game, ends program
            System.out.print("Player 1: Which column would you like to choose? ");
            sCol = scan.nextInt();
            sRow = insertChip(board, sCol, 'x');
            printBoard(board);
            if(checkIfWinner(board,sCol,sRow,'x')==true){
                System.out.print("Player 1 won the game!");
                break;
            }

            //player 2's turn accepts their column input, inserts their chip, prints the board, then checks if they won the game based on that chip placement.
            //if they won the game, ends program
            System.out.print("Player 2: Which column would you like to choose? ");
            sCol = scan.nextInt();
            sRow = insertChip(board, sCol, 'o');
            printBoard(board);
            if (checkIfWinner(board,sCol,sRow,'o')==true){
                System.out.print("Player 2 won the game!");
                break;
            }
            //checks if the game is a draw and if it is, ends the game and declares it.
            if (checkIfDraw(board) == true){
                System.out.println("Draw. Nobody wins.");
                break;
            }

        }
    }
    //initalizes board by setting every element in 2d array equal to '-'
    public static void initializeBoard(char[][] array) {
        System.out.println();
        for (int row = 0; row< array.length; row++){
            for (int col=0; col<array[0].length; col++){
                array[row][col]='-';
            }
        }
    }

    //prints board by printing every element in 2d array with a space in between
    public static void printBoard(char[][]array){
        for (int row = array.length-1; row >=0; row--){
            for (int col=0; col<array[0].length; col++){
                System.out.print(array[row][col]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //inserts chip into the row that there is a - left in and returns the row it is put in.
    public static int insertChip(char[][]array, int col, char chipType){
        int row = -1;
        for (row = 0; row< array.length; row++) {
            if (array[row][col]=='-'){
                array[row][col]=chipType;
                return row;
            }
        }
        return row;
    }
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){
        // if 4 of the same element is present in the same row or column based on chip placed, return true
        //iterate through whole row and see if there are 4 of same element
        //do same for column
        int rCount=0;
        int cCount=0;
        for (int r = 0; r< array.length; r++){
            for (int c=0; c<array[0].length; c++){
                if (r==row && array[r][c]==chipType){
                    rCount++;
                }
                if (c==col && array[r][c]==chipType){
                    cCount++;
                }
            }
        }
        if (rCount==4||cCount==4){
            return true;
        } else{
            return false;
        }
    }
    public static boolean checkIfDraw(char[][] array){
        //checks if there are any elements left in the array as -;
        //if none are left, declares draw;
        int count = 0;
        for (int row = 0; row< array.length; row++){
            for (int col=0; col<array[0].length; col++){
                if (array[row][col]=='-'){
                    count++;
                }
            }
        }
        if (count==0){
            return true;
        } else {
            return false;
        }
    }
}
