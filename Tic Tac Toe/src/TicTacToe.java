import java.util.*;

/**
 * @author: Sherzod Nimatullo
 */

public class TicTacToe {

 public static String[][] board = {
  {"1","2","3"},
  {"4","5","6"},
  {"7","8","9"}
 };

 /**
  * Keeps track of number of rounds.
  */
 public static int round = 1;
 /**
  * The X mark
  */
 public static final String COMPUTER_PLAYER = "X";
 /**
  * The O Mark
  */
 public static final String O_PLAYER = "O";
  /**
  * The current player. Assigned by method that determines the first move.
  */
 public static String currentPlayer = randomPlayerPick();


 public static void main(String[] args) {

  while (!winner()) {
   changePlayer();
   printBoard();
   System.out.println(currentPlayer + "'s turn.");
   if(currentPlayer.equals(O_PLAYER)) {
	   pickSpot();
   }
   else
	   pickCPU();
   round++;
  }
  printBoard();
 }

 /**
  * If the currentPlayer is 'O', then change the currentPlayer.
  * If the currentPlayer is not 'O', that means the currentPlayer
  * is 'X', therefore, changing it to 'X'
  */
 public static void changePlayer() {
  if (currentPlayer.equals(O_PLAYER))
   currentPlayer = COMPUTER_PLAYER;
  else
   currentPlayer = O_PLAYER;
 }

 /**
  * Prints the board to console
  */
 public static void printBoard() {
  System.out.println("  |-----------------|");

  for (int row = 0; row < board[0].length; row++) {
   for (int col = 0; col < board[0].length; col++) {
    System.out.print("  |  " + board[row][col]);
   }
   System.out.println("  |\n  |-----|-----|-----|");
  }
 }

 /**
  * Allows user to input location where they'd like their mark to be placed
  */
 public static void pickSpot() {

  Scanner scan = new Scanner(System.in);

  System.out.print("Enter Number: ");

  String num = scan.next();

  for (int i = 0; i < board.length; i++) {
   for (int j = 0; j < board[i].length; j++) {
    if (board[i][j].equals(num)) {
     board[i][j] = currentPlayer;
    }
   }
  }
 }

 /**
  * Determines if the there is a winner after round ends.
  * @return boolean (true/false)
  */
 public static boolean winner() {
  if (checkWinHorizontal() || checkWinVertical() || checkWinDiagonalL() || checkWinDiagonalR()) {
   System.out.println("Winner is " + currentPlayer);
   return true;
  } else if (round > 9) {
   System.out.println("TIE!");
   return true;
  }
  return false;
 }

 /**
  * Determines if there is a a row with 3 marks that are the same.
  * @return true if there is 3 in a row, false if not.
  */
 public static boolean checkWinHorizontal() {

  for (int row = 0; row < board.length; row++) {
   String horizontal = "";
   for (int col = 0; col < board[row].length; col++) {
    horizontal += board[row][col];
   }

   if (horizontal.equals("XXX") || horizontal.equals("OOO"))
    return true;
  }
  return false;
 }

 /**
  * Determines if there is a column with 3 marks that are the same.
  * @return true if there is a 3 in a column, false if not.
  */
 public static boolean checkWinVertical() {

  for (int col = 0; col < board.length; col++) {
   String vertical = "";
   for (int row = 0; row < board[col].length; row++) {
    vertical += board[row][col];
   }

   if (vertical.equals("XXX") || vertical.equals("OOO"))
    return true;
  }
  return false;
 }

 /**
  * Determines if there are 3 marks that are diagonal on the board.
  * @return true if there are 3 marks that span from the left to the right, false if not.
  */
 public static boolean checkWinDiagonalL() {

  String diagonal = "";
  int row = 0;
  for (int j = 0; j < board[0].length; j++) {
   diagonal += board[row][j];
   row++;
  }

  if (diagonal.equals("XXX") || diagonal.equals("OOO")) {
   return true;
  } else
   return false;
 }

 /**
  * Determines if there are 3 marks that are diagonal on the board.
  * @return true if there are 3 marks that span from the right to the left, false if not.
  */
 public static boolean checkWinDiagonalR() {

  String diagonal = "";
  int row = 0;
  for (int j = board[0].length - 1; j >= 0; j--) {
   diagonal += board[row][j];
   row++;
  }

  if (diagonal.equals("XXX") || diagonal.equals("OOO")) {
   return true;
  } else
   return false;
 }
 
 public static void pickCPU() {
	 
	 for(int row = 0; row < board.length; row++) {
		 int roweval = 0;
		 for(int col = 0; col < board[0].length; col++) {
			 if(board[row][col].equals(O_PLAYER)) {
				roweval += 100; 
			 }
			 else if(board[row][col].equals(COMPUTER_PLAYER)) {
				 roweval -= 100;
			 }
		 }
		 if(roweval == 200)
		 {
			 winBlock(row);
			 return;
		 }
	 }
	 
	 if(!board[1][1].equals(COMPUTER_PLAYER) && !board[1][1].equals(O_PLAYER)) {
		 board[1][1] = (COMPUTER_PLAYER);
		 return;
	 }
	 
	 for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(!board[i][j].equals(COMPUTER_PLAYER) && !board[i][j].equals(O_PLAYER)) {
					board[i][j] = "X";
					return;
				}
			}
		}
 }
 
 
 public static void winBlock(int row) {
	 for(int i = 0; i < board[row].length; i++) {
		 if(!board[row][i].equals(COMPUTER_PLAYER) && !board[row][i].equals(O_PLAYER)) {
			 board[row][i] = COMPUTER_PLAYER;
			 return;
		 }
	 }
 }

 /**
  * Determines first move by generating a number number from 0 to 1. If it is a zero, 
  * X mark goes first, else, O mark goes first.
  * @return player that is going first.
  */
 public static String randomPlayerPick() {

  int num = (int)(Math.random() * 2);

  if (num == 0) {
   return COMPUTER_PLAYER;
  } else
   return O_PLAYER;
 }
}