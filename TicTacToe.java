public class TicTacToe {
    
    public int compPickSpace(String[] spaces, String symbol) {

	if(spaces[0].equals(symbol) && spaces[0].equals(spaces[1]) && spaces[2].equals(" "))

	    {

		return 3;

	    }

	else if(spaces[3].equals(symbol) && spaces[3].equals(spaces[4]) && spaces[5].equals(" "))

	    {

		return 6;

	    }

	else if(spaces[6].equals(symbol) && spaces[6].equals(spaces[7]) && spaces[8].equals(" "))

	    {

		return 9;

	    }

	else if(spaces[6].equals(symbol) && spaces[6].equals(spaces[3]) && spaces[0].equals(" "))

	    {

		return 1;

	    }

	else if(spaces[7].equals(symbol) && spaces[4].equals(spaces[7]) && spaces[1].equals(" "))

	    {

		return 2;

	    }

	else if(spaces[8].equals(symbol) && spaces[5].equals(spaces[8]) && spaces[2].equals(" "))

	    {

		return 3;

	    }

	else if(spaces[2].equals(symbol) && spaces[2].equals(spaces[1]) && spaces[0].equals(" "))

	    {

		return 1;

	    }

	else if(spaces[5].equals(symbol) && spaces[5].equals(spaces[4]) && spaces[3].equals(" "))

	    {

		return 4;

	    }

	else if(spaces[8].equals(symbol) && spaces[8].equals(spaces[7]) && spaces[6].equals(" "))

	    {

		return 7;

	    }

	else if(spaces[0].equals(symbol) && spaces[0].equals(spaces[3]) && spaces[6].equals(" "))

	    {

		return 7;

	    }

	else if(spaces[1].equals(symbol) && spaces[1].equals(spaces[4]) && spaces[7].equals(" "))

	    {

		return 8;

	    }

	else if(spaces[2].equals(symbol) && spaces[2].equals(spaces[5]) && spaces[8].equals(" "))

	    {

		return 9;

	    }

	else if(spaces[6].equals(symbol) && spaces[6].equals(spaces[4]) && spaces[2].equals(" ")

		) {

	    return 3;

	}

	else if(spaces[2].equals(symbol) && spaces[2].equals(spaces[4]) && spaces[6].equals(" "))

	    {

		return 7;

	    }

	else if(spaces[8].equals(symbol) && spaces[8].equals(spaces[4]) && spaces[0].equals(" "))

	    {

		return 1;

	    }

	else if(spaces[0].equals(symbol) && spaces[0].equals(spaces[4]) && spaces[8].equals(" "))

	    {

		return 9;

	    }

	else if(spaces[0].equals(symbol) && spaces[0].equals(spaces[6]) && spaces[3].equals(" "))

	    {

		return 4;

	    }

	else if(spaces[6].equals(symbol) && spaces[8].equals(spaces[6]) && spaces[7].equals(" "))

	    {

		return 8;

	    }

	else if(spaces[8].equals(symbol) && spaces[2].equals(spaces[8]) && spaces[5].equals(" "))

	    {

		return 6;

	    }

	else if(spaces[2].equals(symbol) && spaces[2].equals(spaces[0]) && spaces[1].equals(" "))

	    {

		return 2;

	    }

	else if(spaces[0].equals(symbol) && spaces[0].equals(spaces[8]) && spaces[4].equals(" "))

	    {

		return 5;

	    }

	else if(spaces[2].equals(symbol) && spaces[2].equals(spaces[6]) && spaces[4].equals(" "))

	    {

		return 5;

	    }



	//Block logic. If the opponent has two in a row, play the third to block them.

	if(!spaces[0].equals(symbol) && spaces[0].equals(spaces[1]) && !spaces[0].equals(" ") && spaces[2].equals(" "))

	    {

		return 3;

	    }

	else if(!spaces[3].equals(symbol) && spaces[3].equals(spaces[4]) && !spaces[3].equals(" ") && spaces[5].equals(" "))

	    {

		return 6;

	    }

	else if(!spaces[6].equals(symbol) && spaces[6].equals(spaces[7]) && !spaces[6].equals(" ") && spaces[8].equals(" "))

	    {

		return 9;

	    }

	else if(!spaces[6].equals(symbol) && spaces[6].equals(spaces[3]) && !spaces[6].equals(" ") && spaces[0].equals(" "))

	    {

		return 1;

	    }

	else if(!spaces[7].equals(symbol) && spaces[4].equals(spaces[7]) && !spaces[7].equals(" ") && spaces[1].equals(" "))

	    {

		return 2;

	    }

	else if(!spaces[8].equals(symbol) && spaces[5].equals(spaces[8]) && !spaces[8].equals(" ") && spaces[2].equals(" "))

	    {

		return 3;

	    }

	else if(!spaces[2].equals(symbol) && spaces[2].equals(spaces[1]) && !spaces[2].equals(" ") && spaces[0].equals(" "))

	    {

		return 1;

	    }

	else if(!spaces[5].equals(symbol) && spaces[5].equals(spaces[4]) && !spaces[5].equals(" ") && spaces[3].equals(" "))

	    {

		return 4;

	    }

	else if(!spaces[8].equals(symbol) && spaces[8].equals(spaces[7]) && !spaces[8].equals(" ") && spaces[6].equals(" "))

	    {

		return 7;

	    }

	else if(!spaces[0].equals(symbol) && spaces[0].equals(spaces[3]) && !spaces[0].equals(" ") && spaces[6].equals(" "))

	    {

		return 7;

	    }

	else if(!spaces[1].equals(symbol) && spaces[1].equals(spaces[4]) && !spaces[1].equals(" ") && spaces[7].equals(" "))

	    {

		return 8;

	    }

	else if(!spaces[2].equals(symbol) && spaces[2].equals(spaces[5]) && !spaces[2].equals(" ") && spaces[8].equals(" "))

	    {

		return 9;

	    }

	else if(!spaces[6].equals(symbol) && spaces[6].equals(spaces[4]) && !spaces[6].equals(" ") && spaces[2].equals(" "))

	    {
		
		return 3;
		
	    }
	
	else if(!spaces[2].equals(symbol) && spaces[2].equals(spaces[4]) && !spaces[2].equals(" ") && spaces[6].equals(" "))

	    {

		return 7;

	    }

	else if(!spaces[8].equals(symbol) && spaces[8].equals(spaces[4]) && !spaces[8].equals(" ") && spaces[0].equals(" "))

	    {

		return 1;

	    }

	else if(!spaces[0].equals(symbol) && spaces[0].equals(spaces[4]) && !spaces[0].equals(" ") && spaces[8].equals( " "))

	    {

		return 9;

	    }

	else if(!spaces[0].equals(symbol) && spaces[0].equals(spaces[8]) && !spaces[0].equals(" ") && spaces[4].equals(" "))

	    {

		return 5;

	    }

	else if(!spaces[6].equals(symbol) && spaces[6].equals(spaces[2]) && !spaces[6].equals(" ") && spaces[4].equals(" "))

	    {

		return 5;

	    }

	else if(!spaces[0].equals(symbol) && spaces[0].equals(spaces[6]) && !spaces[0].equals(" ") && spaces[3].equals(" "))

	    {

		return 4;

	    }

	else if(!spaces[6].equals(symbol) && spaces[8].equals(spaces[6]) && !spaces[6].equals(" ") && spaces[7].equals(" "))

	    {

		return 8;

	    }

	else if(!spaces[8].equals(symbol) && spaces[8].equals(spaces[2]) && !spaces[8].equals(" ") && spaces[5].equals(" "))

	    {

		return 6;

	    }

	else if(!spaces[2].equals(symbol) && spaces[0].equals(spaces[2]) && !spaces[0].equals(" ") && spaces[1].equals(" "))

	    {

		return 2;
		
	    }
	
	
	//Play a fork. Create an opportunity where computer can win in two ways.
	
	else if((spaces[0].equals(symbol) && spaces[2].equals(symbol) && spaces[4].equals(" ")) && spaces[6].equals(" ") && spaces[8].equals(" "))
	    
	    {
		
		return 5;

	    }


	else if((spaces[6].equals(symbol) && spaces[8].equals(symbol) && spaces[4].equals(" ")) && spaces[0].equals(" ") && spaces[2].equals(" "))

	    {

		return 5;

	    }

	else if((spaces[6].equals(symbol) && spaces[0].equals(symbol) && spaces[4].equals(" ")) && spaces[8].equals(" ") && spaces[2].equals(" "))

	    {

		return 5;

	    }

	else if((spaces[2].equals(symbol) && spaces[8].equals(symbol) && spaces[4].equals(" ")) && spaces[0].equals(" ") && spaces[6].equals(" "))

	    {

		return 5;

	    }

	else if((spaces[6].equals(symbol) && spaces[2].equals(symbol) && spaces[8].equals(" ")) && spaces[7].equals(" ") && spaces[5].equals(" "))

	    {

		return 9;

	    }
	
	else if((spaces[6].equals(symbol) && spaces[2].equals(symbol) && spaces[0].equals(" ")) && spaces[1].equals(" ") && spaces[3].equals(" "))
	    
	    {
		
		return 1;
		
	    }
	
	else if((spaces[8].equals(symbol) && spaces[0].equals(symbol) && spaces[6].equals(" ")) && spaces[7].equals(" ") && spaces[3].equals(" "))
	    
	    {
		
		return 7;
		
	    }
	
	else if((spaces[8].equals(symbol) && spaces[0].equals(symbol) && spaces[2].equals(" ")) && spaces[5].equals(" ") && spaces[1].equals(" "))
	    
	    {
		
		return 3;
		
	    }
	
	
	
	//Block a fork
	
	if((!spaces[0].equals(syms[6].equals(symbol) && !spaces[6].equals(" ") && spaces[6].equals(spaces[8]) && spaces[4].equals(" ")) && spaces[2].equals(" ") && spaces[0].equals(" "))
	   
	   {
	       
	       return 5;
	       
	   }
	   
	   else if((!spaces[8].equals(symbol) && !spaces[8].equals(" ") && spaces[2].equals(spaces[8]) && spaces[4].equals(" ")) && spaces[6].equals(" ") && spaces[0].equals(" "))

	       {

		   return 5;

	       }

	   else if((!spaces[6].equals(symbol) && !spaces[6].equals(" ") && spaces[2].equals(spaces[6]) && spaces[8].equals([1].equals(" ")) && spaces[2].equals(" ") && spaces[5].equals(" "))

		   {
		       
		       return 3;
		       
		   }
		   
		   
		   //Play center if everything above is fails
		   
		   if(spaces[4].equals(" "))
		       
		       {
			   
			   return 5;
			   
		       }
		   
		   
		   //Play opposite corner. Player corner if opponent is in the corner
		   
		   if(!spaces[0].equals(symbol) && spaces[8].equals(" ") && !spaces[0].equals(" "))
		       
		       
		       {
			   
			   return 9;
			   
		       }
		   
		   else if(!spaces[2].equals(symbol) && spaces[6].equals(" ") && !spaces[2].equals(" "))
		       
		       {
			   
			   return 7;
			   
		       }
		   
		   else if(!spaces[8].equals(symbol) && spaces[0].equals(" ") && !(spaces[7].equals(" "))
			   
			   {
			       
			       return 8;
			       
			   }
			   
			   else if(spaces[1].equals(" "))
			       
			       {
				   
				   return 2;
				   
			       }
			   
			   
			   else
			       
			       return 0;
			   
			   } 
		   
		   }
	   }
    }
    
  

}