package game.morrow.ttt;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

	private  String name;
	private static int move;
	private static Scanner scan = new Scanner(System.in);
	private static TicTacToe player1;
	private static TicTacToe player2;
	private static char[] board;
	private static ArrayList<TicTacToe> players;
	
	public TicTacToe() {}
	
	public static void main(String [] args) {	
		createBoard();
		updateBoard();
		player1 = new TicTacToe();
		player2 = new TicTacToe();
		startGame();
	}
	
	public String getPlayerName() {
		return name;
	}
	
	public void setPlayerName(String user) {
		name = user;
	}
	
	//Create the board and number each square
	private static void createBoard() {
		board = new char[9];
		int squareNumber = '1';
		
		for(int i=0; i<9;i++) {	
			board[i] = (char) squareNumber;
			squareNumber++;
		}		
	}
	
	//Prints the board along with updated player moves to the terminal window
	private static void updateBoard() {
		for(int i=0; i< board.length;i++) {
			System.out.print(" " + board[i] + " | ");

			if((i>0) && ((i+1)%3 == 0))
				System.out.println("\n" + "------------");
		}
	}
	
	//Initializes game and starts game loop
	public static void startGame() {		
		//An array list is used to store player names
		players = new ArrayList<>();
		System.out.println("Player 1, what's your name: ");
		player1.setPlayerName(scan.next());
		System.out.println("Player 2, what's your name: ");
		player2.setPlayerName(scan.next());
		players.add(player1);
		players.add(player2);
		
		System.out.println(player1.getPlayerName() + " will be Xs, and " + player2.getPlayerName() + " will be Os.");

		//Main game loop
		while(!checkWinner()) {
			for(int k=0; k<2;k++) {
				char character = 'x';
				System.out.println("What move would you like to play, " + players.get(k).getPlayerName() + "?");

				//Checks for valid input from players.
				isInputValid(k);
								
				//Updates board depending on which player made the move
				switch(k) {
				case 0:
					character = 'X';
					break;
				case 1: 
					character ='O';
					break;
				}
				
				if(checkForValidPlay(move)) {
						board[move-1] = character;
						updateBoard();
				}

				if(checkWinner()) {
					System.out.println("You won " + players.get(k).getPlayerName() + "!!!");
					break;
				}
				
			}
		}
	}
	
	//Checks to see if a position has already been played.
	private static Boolean checkForValidPlay(int move) {
		char compare = board[move-1];
		for(int i=0; i< board.length;i++) {
			if((compare == 'X') || (compare == 'O'))
				return false;
		}
		return true;
	}
	
	//Check board for winner
	private static Boolean checkWinner() {
	
			//Check to see if player1 won
			if(board[0] == 'X' && board[1] =='X' && board[2] == 'X')
				return true;
			else if(board[0] == 'X' && board[1] =='X' && board[2] == 'X')
				return true;
			else if(board[3] == 'X' && board[4] =='X' && board[5] == 'X')
				return true;
			else if(board[6] == 'X' && board[7] =='X' && board[8] == 'X')
				return true;
			else if(board[0] == 'X' && board[3] =='X' && board[6] == 'X')
				return true;
			else if(board[1] == 'X' && board[4] =='X' && board[7] == 'X')
				return true;
			else if(board[2] == 'X' && board[5] =='X' && board[8] == 'X')
				return true;
			else if(board[0] == 'X' && board[4] =='X' && board[8] == 'X')
				return true;
			else if(board[2] == 'X' && board[4] =='X' && board[6] == 'X')
				return true;
			
			//Check to see if player2 won
			else if(board[0] == 'O' && board[1] =='O' && board[2] == 'O')
				return true;
			else if(board[0] == 'O' && board[1] =='O' && board[2] == 'O')
				return true;
			else if(board[3] == 'O' && board[4] =='O' && board[5] == 'O')
				return true;
			else if(board[6] == 'O' && board[7] =='O' && board[8] == 'O')
				return true;
			else if(board[0] == 'O' && board[3] =='O' && board[6] == 'O')
				return true;
			else if(board[1] == 'O' && board[4] =='O' && board[7] == 'O')
				return true;
			else if(board[2] == 'O' && board[5] =='O' && board[8] == 'O')
				return true;
			else if(board[0] == 'O' && board[4] =='O' && board[8] == 'O')
				return true;
			else if(board[2] == 'O' && board[4] =='O' && board[6] == 'O')
				return true;
		
		return false;
	}
	
	//Checks for valid input from players
	private static Boolean isInputValid(int playerNumber) {
		Boolean valid = false;
		do {
			if (scan.hasNextInt()) {
				move = Integer.parseInt(scan.next());
				if(move > 0 && move <10)
					return true;
			}
			else {
				//Advances scanner in case input is not a number
				scan.next();				
			}
			
		System.out.println("That is not a valid move " + players.get(playerNumber).getPlayerName());
		}while(valid == false);
		
		return false;
	}
}
