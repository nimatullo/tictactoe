import java.util.*;
public class TicTacToe {
	
	public static String [][] board = new String [3][3];

	public static void main(String[] args) {
		printBoard();
		pickSpot();
	}
	
	public static void printBoard() {
		
		for (String [] a : board) {
            for (String i : a) {
                System.out.print(i + "\t");
            }
            System.out.println("\n");
        }
 
		
	}
	
	public static void pickSpot() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter x: ");
		int x = scan.nextInt();
		
		System.out.println("Enter y: ");
		int y = scan.nextInt();
		
		board[1][1] = "x";
		
		System.out.println(board[1][1]);
		
	}
	
	public static void checkWin() {
		
	}

}
