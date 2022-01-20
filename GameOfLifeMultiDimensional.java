package Methoden;

import java.util.Scanner;

public class GameOfLifeMultiDimensional {
    public static void main(String[] args) {
        int row=10;
        int col=10;
        int[][] myArray = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("Please enter with a number ");
        int number = Scanner();

        System.out.println("Original: ");
        original(myArray, row, col);
        System.out.println();

        System.out.println("Next Generation: ");
        int[][] changed = nextGeneration(myArray, row, col);
        System.out.println();


       if(number>1){
           for(int i = 1; i<number; i++){
               System.out.println("New Next Generation: ");
               nextGeneration(changed,row,col);
               System.out.println();
           }
       }
    }

    static int Scanner(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        return i;
    }

    static boolean format(int[][] myArray,int i, int j){
        if(myArray[i][j] == 1){
            System.out.print(" # ");
            return true;
        } else {
            System.out.print(" . ");
            return false;
        }
    }


    static int[][] original(int myArray[][], int row, int col){

        for(int i=1; i<row-1;i++){
            for(int j=1; j<col-1; j++){
                if(myArray[i][j] == 1){
                    System.out.print(" # ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        return myArray;
    }

    static int[][] nextGeneration(int myArray[][], int row, int col) {

        // creating an array 8x8
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                // creating an array 3x3
                    int sum = 0;
                    for (int m = i - 1; m <= i + 1; m++) {
                        for (int n = j - 1; n <= j + 1; n++) {
                            sum += myArray[m][n];
                        }
                    }
                    sum -= myArray[i][j];

                // live cell with 2 up to 3 live neighbors
                if(myArray[i][j] == 1){
                    if (sum == 2 || sum == 3) {
                        myArray[i][j] = 1;
                    }else{
                        myArray[i][j] = 0;
                    }
                } else if(myArray[i][j] == 0){ // dead cell
                    if (sum==3){
                        myArray[i][j] = 1;
                    } else {
                        myArray[i][j] = 0;
                    }
                }
                // formating
                if(myArray[i][j] == 1){
                    System.out.print(" # ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        return myArray;
    }
}
