package in.cdac.miniproject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;



import in.cdac.rockpaperscissors.RockPaperScissors;
import in.cdac.snakesandladders.Box;
import in.cdac.snakesandladders.SnakesAndLadders;
import in.cdac.tictactoe.TicTacToe;


public class Program {
	static Scanner sc=new Scanner(System.in);
	
	enum Choice {
		
		EXIT , TICTACTOE , SNAKESANDLADDERS, ROCKPAPERSCISSORS ;
	}
	
	
	public static Choice menuList()
	{
		System.out.println(" ------------Enter Your Choice------------- ");
		System.out.println("0. EXIT ");
		System.out.println("1. Tic-Tac-Toe ");
		System.out.println("2. Snakes & Ladder ");
		System.out.println("3. Rock, Paper & Scissors ");
		System.out.println(" ------------------------------------------ ");
		
		return Choice.values()[sc.nextInt()];
	}
	
	

	public static void main(String[] args) {
		
		Choice choice;		
		TicTacToe ttt=new TicTacToe();
		SnakesAndLadders snl=new SnakesAndLadders();
		RockPaperScissors rps=new RockPaperScissors();		
		snl.setBoard(new ArrayList<Box>());
		//snl.setBoard(new LinkedList<Box>());				//UpCasting
		
		try {
			while((choice=Program.menuList())!=Choice.EXIT) {
				switch(choice) {
				
				case TICTACTOE: ttt.gameLogicTTT();
								break;
					
				case SNAKESANDLADDERS:  snl.generateBoard();
										snl.gameLogicSNL();							 							
				
								  break;
								  
				case ROCKPAPERSCISSORS: rps.gameLogicRPS();
									 	System.out.println(rps.toString());
				break;
				
				default:
					break;						  
				
				}
			}
		} catch (RuntimeException ex) {
			System.out.println("Please Select Between Given Options Only!");
			throw new ArrayIndexOutOfBoundsException("Invalid Input");
		}
		
	}

}
