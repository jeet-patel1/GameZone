package in.cdac.rockpaperscissors;


import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {
	String [] choices= {"ROCK","PAPER","SCISSORS"};
	int win=0;
	int lost=0;
	int draw=0;

	static Scanner sc=new Scanner(System.in);

	public void gameLogicRPS() {
		while(true) {
		System.out.println("=================Welcome to ROCK, PAPER, SCISSORS.=================");
		System.out.println("Score :   " +win+" Wins   "+lost+" Losses   "+draw+" Draws.");
		
		//Input Player Choice
		System.out.println("Enter Rock, Paper OR Scissors. (Type QUIT to exit.)");
		String playerMove=sc.nextLine().toUpperCase();
		
		//Quit Statement
		if(playerMove.equals("QUIT")) {
			System.out.println("Thank You for Playing.");
				break;
				}
				
		//Validate Move		
		if(!playerMove.equals("ROCK") && !playerMove.equals("PAPER") && !playerMove.equals("SCISSORS")) {
			System.out.println("You have given Wrong Input. Try Again");
			continue;
		}
		
		
		//Generating Computer's Move
		Random random=new Random();
		int computerIndex=random.nextInt(choices.length);
		String computerMove=choices[computerIndex];
		
		//Display Moves
		System.out.println("You chose " + playerMove + ", and the computer chose " + computerMove + ".");
		
		//Check Conditions
		if(playerMove.equals(computerMove)) {
			System.out.println("It is a Draw!");
			draw++;
		}
		else if((playerMove.equals("ROCK") && computerMove.equals("SCISSORS")) ||(playerMove.equals("PAPER") && computerMove.equals("ROCK")) || (playerMove.equals("SCISSORS") && computerMove.equals("PAPER")))
				{
			System.out.println("YOU WIN!!");
			win++;
				}
		else {
			System.out.println("YOU LOSE!!");
			lost++;
			}
		}	
	}

	
	@Override
	public String toString() {
	return	String.format("Wins: %-10d	Lost: %-10d	Draw: %-10d",this.win,this.lost,this.draw);
		
	}
	
	
	
}
