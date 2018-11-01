import java.util.*;
public class TicTacToe {
	
	public static String [][] board = new String [3][3];
	
	public static String currentPlayer;

	public static void main(String[] args) {
		printBoard();
		pickSpot();
		printBoard();
		checkWinVertical();
	}
	
	public static void changePlayer() {
		if(currentPlayer.equals("x"))
			currentPlayer.equals("o");
		else
			currentPlayer.equalsIgnoreCase("x");
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
		
		board[0][1] = "o";
		board[0][0] = "o";
		board[0][2] = "o";
		
		System.out.println(board[1][1]);
		
	}
	
	public static void checkWinVertical() {
		
		for(int col = 0; col < board.length; col++) {
		
			if((board[col][0].equals(board[col][1])) && (board[col][1].equals(board[0][2]))) {
				System.out.println(board[0][0] + " wins!");
			}
		}
		
	}

}
