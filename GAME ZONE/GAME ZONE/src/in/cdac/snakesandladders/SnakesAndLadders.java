package in.cdac.snakesandladders;




import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class SnakesAndLadders {
	
	private int player1 ;
	private int player2 ;
	private static final int WINNING_POSITION = 100;
	
	protected List<Box> board;			//ArrayList
	
	static Scanner scan = new Scanner(System.in);
	
	public void setBoard(List<Box> board1) {
		this.board=board1;
	}
	
    public void generateBoard() { 
    	for( int i =0 ; i < 101 ; i++ ){ 
    		Box b = new Box();
    		b.setBox();
    		this.board.add(b); 
    		
    	}    	
    }

    public static int[][] getArray(){
    	 //Initializing the Board
	   	int [][] boardArray=new int[10][10];
		int x = 1;				
			for(int i= 9 ; i >= 0;i--) {   
				if(i % 2 != 0 ){
				     for(int j=0; j<10; j++){
					     boardArray[i][j]= x++;
				     }
				}
				else{
				     for(int j=9;j >=0; j--){
					     boardArray[i][j]= x++;
				     }
				}
			} return boardArray;
    }

    public void printBoard() {
    	//Printing the Board
    	int[][] boardArray=getArray();
    	System.out.println("-----------------------------------------------------------------------");
		for(int i=0;i<10;i++) {
			System.out.print("| ");
			for(int j=0;j<10;j++) {   
				if(this.player2 == boardArray[i][j] && this.player1 == boardArray[i][j] ){
					System.out.printf("%3s| ","P1,P2");
				}
				 else if(this.player1 == boardArray[i][j] ){
					System.out.printf("%3s  | ","*P1");
				}
				else if(this.player2 == boardArray[i][j] ){
					System.out.printf("%3s  | ","*P2");
				}
				else 
				System.out.printf( "%3d  | ",boardArray[i][j] );							
			}				
			System.out.println();
			System.out.println("-----------------------------------------------------------------------");
		} 
		
    }

    public int playerMove(int dice, int playerPosition) {
    	int newPosition=0;
    	 newPosition=playerPosition+dice;  
	     	if(newPosition > WINNING_POSITION ){
	     		System.out.println("You need "+ ( WINNING_POSITION - playerPosition )+ " Point To Win The Game .Kindly  Wait for next turn ....");
	     	}
	     	else{   
	     		playerPosition =newPosition ;   
	     		if(board.get(playerPosition).count < 0 ){
	     			System.out.println("Oh No!! You've got Snake . You move down "+board.get(playerPosition).count+" Position");
	     			playerPosition += board.get(playerPosition).count ;
	     		}
	     		else if( board.get(playerPosition).count > 0 ){
	     			System.out.println("Hooray!! You've got a Ladder. You move up additional "+board.get(playerPosition).count+" Position");
	     			playerPosition += board.get(playerPosition).count ; 
	     		}
	     	}
	     	return playerPosition;
    }
    
    
    public void gameLogicSNL() {
        	
        	Random random=new Random();
	    	System.out.println("==========WELCOME TO SNAKES AND LADDERS!===========");
	    	System.out.println("Position of Player 1: "+this.player1);
	     	System.out.println("Position of Player 2: "+this.player2);
	     	int change=1;
	     	
		    while( this.player1 < WINNING_POSITION  && this.player2 < WINNING_POSITION ) { 
		    	
		    	printBoard();
				
				 //Making the Move
			     System.out.println("Press Enter to Roll the Dice: "); 
			     scan.nextLine();
			     int dice=random.nextInt(6)+1;
		       	 System.out.println("You have got : "+dice);
		       	 
		       	 //Condition for Player 1
		      	 if(change % 2 != 0 ){						 
		      		this.player1=playerMove(dice,this.player1);
			     }
		      	 //Condition for Player 2
			     else{		    								
			    	 this.player2=playerMove(dice,this.player2);
			     }
		      	 
		      	 //Print Score
		      	 System.out.println("Player 1 : "+ this.player1 );
		      	 System.out.println("Player 2 : "+ this.player2 );
			     ++change ;			     
	         }
		    
		    //Check Winning Position
			 if( this.player1 == WINNING_POSITION )
		     	 System.out.println("Congratulations ! Player 1 won the Game .");
		     else if( this.player2 == WINNING_POSITION)
		     	 System.out.println("Congratulations ! Player 2 won the Game .");
		}
}
		
		
    
    
    
    
    
    
    
    

