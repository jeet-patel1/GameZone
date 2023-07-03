package in.cdac.tictactoe;



import java.util.Scanner;

public class TicTacToe {
	
	
	static Scanner sc=new Scanner(System.in);
	
	
	public void gameLogicTTT() {

		System.out.println("=================Welcome to TIC - TAC - TOE.=================");
		
		
		char[][] board=new char[3][3];
		int row,column;
		char player= 'X';
		
		//Initialize the Board
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]= '-';
			}
		}
		
		//Game Logic
		while(true) {
			//Display Board
			System.out.println("-------------");
			for(int i=0;i<3;i++) {
				System.out.print("| ");
				for(int j=0;j<3;j++) {
					System.out.print(board[i][j] + " | ");									
				}
				System.out.println();
				System.out.println("-------------");
			}
			
			try {
				//Input for Player
				System.out.print("Player "+player+ ", enter Row (1-3): ");
				row=sc.nextInt()-1;
				System.out.print("Player "+player+ ", enter Column (1-3): ");
				column=sc.nextInt()-1;
			} catch (RuntimeException ex) {
				System.out.println("Please Enter Numbers between (1-3)");
				sc.nextLine();
				continue;
			}
			
			
			//Validating Input
			if( row<0 || row>2 || column<0 ||column>2) {
				System.out.println("Invalid Input. Try Again.");
				continue;
			}
			
			//Check if move is Valid
			if(board[row][column] != '-') {
				System.out.println("This Spot is already taken! Try Again: ");
				continue;
			}
			
			//Making the Move
			board[row][column]=player;
			
			//Win Condition
			if(winCase(board,player)) {
				System.out.println("Player "+player+" wins!!!");
				break;
			}
			
			//Draw Condition
			if(drawCase(board)) {
				System.out.println("The Game is a Draw.");
				break;
			}
			
			//Player Switching
			player =(player == 'X') ? 'O' : 'X';
			
		}
			
		}

	public static boolean winCase(char[][] board, char player) {
		
		//Check Rows
		for(int i=0;i<3;i++) {
			if(board[i][0]==player && board[i][1]==player &&board[i][2]==player) {
				return true;
			}
		}	
		
		//Check Columns
		for(int i=0;i<3;i++) {
			if(board[0][i]==player && board[1][i]==player &&board[2][i]==player) {
				return true;
			}
		}
		
		//Check Diagonals
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
			return true;
		
		if(board[0][2]==player && board[1][1]==player && board[2][0]==player)
			return true;
		
		return false;
	}
	
	public static boolean drawCase(char[][] board) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]== '-')
					return false;
			}
		}
		return true;
	}
		
}
