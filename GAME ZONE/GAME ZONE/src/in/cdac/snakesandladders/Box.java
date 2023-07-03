package in.cdac.snakesandladders;

public class Box {
	
	private int  boxNo ;
	protected int count ;
	
	static int increment = 1 ;
	
	public void setBox()
	{
		this.boxNo = increment ;
		increment++ ;
		
		    if( this.boxNo == 98 )
			   this.count = -7 ;
			else if( this.boxNo == 62 )
			   this.count = -19 ;
			else if( this.boxNo == 17 )
				   this.count = -3 ;
			else if( this.boxNo == 4 )
				   this.count = 11 ;
			else if( this.boxNo == 20 )
				   this.count = 18 ;
			else if( this.boxNo == 40 )
				   this.count = 19 ;
			else if( this.boxNo == 63 )
				   this.count = 24 ;
			else if( this.boxNo == 71 )
				   this.count = 20 ;			
		
	}
	
}

