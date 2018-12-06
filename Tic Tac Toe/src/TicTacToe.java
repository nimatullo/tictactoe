import java.util.*;
public class TicTacToe {

 public static String[][] board = {
  {"1","2","3"},
  {"4","5","6"},
  {"7","8","9"}
 };

 public static int round = 1;

 public static final String X_PLAYER = "X";
 public static final String O_PLAYER = "O";

 public static String currentPlayer = randomPlayerPick();


 public static void main(String[] args) {

  while (!winner()) {
   changePlayer();
   printBoard();
   System.out.println(currentPlayer + "'s turn.");
   pickSpot();
   round++;
  }
  printBoard();
 }
 
 /* If the currentPlayer is 'O', then change the currentPlayer.
  * If the currentPlayer is not 'O', that means the currentPlayer
  * is 'X', therefore, changing it to 'X'
  */

 public static void changePlayer() {
  if (currentPlayer.equals(O_PLAYER))
   currentPlayer = X_PLAYER;
  else
   currentPlayer = O_PLAYER;
 }

 public static void printBoard() {
	 System.out.println("  |-----------------|");
	 
	for(int row = 0; row < board[0].length; row++) {
		for(int col = 0; col < board[0].length; col++) {
			System.out.print("  |  " + board[row][col]);
	}
		System.out.println("  |\n  |-----|-----|-----|");
	}
	 

 }

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

 public static String randomPlayerPick() {

  int num = (int)(Math.random() * 2);

  if (num == 0) {
   return X_PLAYER;
  } else
   return O_PLAYER;
 }
}
