public class ComputerPlayer {

    private TicTacToeGame tic = new TicTacToeGame();
    private String[] spaces;
    private GUI gui;

    public void convertArray(int[] array)
    {
	spaces = new String[9];
	
	for(int i = 0; i < array.length; i++)
	{
	    if(array[i] == 1)
	    {
		spaces[i] = "X";
	    }
	    else if(array[i] == 2)
	    {
		spaces[i] = "O";
	    }
	    else if(array[i] == 0)
	    {
		spaces[i] = " ";
	    }
	}
    }

    // Method for picking the optimal spot
    public void pickSpace(int[] takenSpaces, GUI Gui) 
    {

	convertArray(takenSpaces);
	
	String symbol = "O";

	gui = Gui;
	
	//Win logic. Checks if you have two in a row, play the third to get three in a row.
	if(spaces[0].equals(symbol) && spaces[0].equals(spaces[1]) && spaces[2].equals(" "))
	{
	    gui.computerPress(3);
	}
	else if(spaces[3].equals(symbol) && spaces[3].equals(spaces[4]) && spaces[5].equals(" "))
	{
	    gui.computerPress(6);
	}
	else if(spaces[6].equals(symbol) && spaces[6].equals(spaces[7]) && spaces[8].equals(" "))
	{
	    gui.computerPress(9);
	}
	else if(spaces[6].equals(symbol) && spaces[6].equals(spaces[3]) && spaces[0].equals(" "))
	{
	    gui.computerPress(1);
	}
	else if(spaces[7].equals(symbol) && spaces[4].equals(spaces[7]) && spaces[1].equals(" "))
	{
	    gui.computerPress(2);
	}
	else if(spaces[8].equals(symbol) && spaces[5].equals(spaces[8]) && spaces[2].equals(" "))
	{
	    gui.computerPress(3);
	}
	else if(spaces[2].equals(symbol) && spaces[2].equals(spaces[1]) && spaces[0].equals(" "))
	{
	    gui.computerPress(1);
	}
	else if(spaces[5].equals(symbol) && spaces[5].equals(spaces[4]) && spaces[3].equals(" "))
	{
	    gui.computerPress(4);
	}
	else if(spaces[8].equals(symbol) && spaces[8].equals(spaces[7]) && spaces[6].equals(" "))
	{
	    gui.computerPress(7);
	}
	else if(spaces[0].equals(symbol) && spaces[0].equals(spaces[3]) && spaces[6].equals(" "))
	{
	    gui.computerPress(7);
	}
	else if(spaces[1].equals(symbol) && spaces[1].equals(spaces[4]) && spaces[7].equals(" "))
	{
	    gui.computerPress(8);
	}
	else if(spaces[2].equals(symbol) && spaces[2].equals(spaces[5]) && spaces[8].equals(" "))
	{
	    gui.computerPress(9);
	}
	else if(spaces[6].equals(symbol) && spaces[6].equals(spaces[4]) && spaces[2].equals(" "))
	{
	    gui.computerPress(3);
	}
	else if(spaces[2].equals(symbol) && spaces[2].equals(spaces[4]) && spaces[6].equals(" "))
	{
	    gui.computerPress(7);
	}
	else if(spaces[8].equals(symbol) && spaces[8].equals(spaces[4]) && spaces[0].equals(" "))
	{
	    gui.computerPress(1);
	}
	else if(spaces[0].equals(symbol) && spaces[0].equals(spaces[4]) && spaces[8].equals(" "))
	{
	    gui.computerPress(9);
	}
	else if(spaces[0].equals(symbol) && spaces[0].equals(spaces[6]) && spaces[3].equals(" "))
	{
	    gui.computerPress(4);
	}
	else if(spaces[6].equals(symbol) && spaces[8].equals(spaces[6]) && spaces[7].equals(" "))
	{
	    gui.computerPress(8);
	}
	else if(spaces[8].equals(symbol) && spaces[2].equals(spaces[8]) && spaces[5].equals(" "))
	{
	    gui.computerPress(6);
	}
	else if(spaces[2].equals(symbol) && spaces[2].equals(spaces[0]) && spaces[1].equals(" "))
	{
	    gui.computerPress(2);
	}
	else if(spaces[0].equals(symbol) && spaces[0].equals(spaces[8]) && spaces[4].equals(" "))
	{
	    gui.computerPress(5);
	}
	else if(spaces[2].equals(symbol) && spaces[2].equals(spaces[6]) && spaces[4].equals(" "))
	{
	    gui.computerPress(5);
	}
	
	
	//Block logic. If the opponent has two in a row, play the third to block them.
	else if(!spaces[0].equals(symbol) && spaces[0].equals(spaces[1]) && !spaces[0].equals(" ") && spaces[2].equals(" "))
	{
	    gui.computerPress(3);
	}
	else if(!spaces[3].equals(symbol) && spaces[3].equals(spaces[4]) && !spaces[3].equals(" ") && spaces[5].equals(" "))
	{
	    gui.computerPress(6);
	}
	else if(!spaces[6].equals(symbol) && spaces[6].equals(spaces[7]) && !spaces[6].equals(" ") && spaces[8].equals(" "))
	{
	    gui.computerPress(9);
	}
	else if(!spaces[6].equals(symbol) && spaces[6].equals(spaces[3]) && !spaces[6].equals(" ") && spaces[0].equals(" "))
	{
	    gui.computerPress(1);
	}
	else if(!spaces[7].equals(symbol) && spaces[4].equals(spaces[7]) && !spaces[7].equals(" ") && spaces[1].equals(" "))
	{
	    gui.computerPress(2);
	}
	else if(!spaces[8].equals(symbol) && spaces[5].equals(spaces[8]) && !spaces[8].equals(" ") && spaces[2].equals(" "))
	{
	    gui.computerPress(3);
	}
	else if(!spaces[2].equals(symbol) && spaces[2].equals(spaces[1]) && !spaces[2].equals(" ") && spaces[0].equals(" "))
	{
	    gui.computerPress(1);
	}
	else if(!spaces[5].equals(symbol) && spaces[5].equals(spaces[4]) && !spaces[5].equals(" ") && spaces[3].equals(" "))
	{
	    gui.computerPress(4);
	}
	else if(!spaces[8].equals(symbol) && spaces[8].equals(spaces[7]) && !spaces[8].equals(" ") && spaces[6].equals(" "))
	{
	    gui.computerPress(7);
	}
	else if(!spaces[0].equals(symbol) && spaces[0].equals(spaces[3]) && !spaces[0].equals(" ") && spaces[6].equals(" "))
	{
	    gui.computerPress(7);
	}
	else if(!spaces[1].equals(symbol) && spaces[1].equals(spaces[4]) && !spaces[1].equals(" ") && spaces[7].equals(" "))
	{
	    gui.computerPress(8);
	}	    
	else if(!spaces[2].equals(symbol) && spaces[2].equals(spaces[5]) && !spaces[2].equals(" ") && spaces[8].equals(" "))
	{
	    gui.computerPress(9);
	}
	else if(!spaces[6].equals(symbol) && spaces[6].equals(spaces[4]) && !spaces[6].equals(" ") && spaces[2].equals(" "))
	{
	    gui.computerPress(3);
	}
	else if(!spaces[2].equals(symbol) && spaces[2].equals(spaces[4]) && !spaces[2].equals(" ") && spaces[6].equals(" "))
	{
	    gui.computerPress(7);
	}
	else if(!spaces[8].equals(symbol) && spaces[8].equals(spaces[4]) && !spaces[8].equals(" ") && spaces[0].equals(" "))
	{
	    gui.computerPress(1);
	}
	else if(!spaces[0].equals(symbol) && spaces[0].equals(spaces[4]) && !spaces[0].equals(" ") && spaces[8].equals( " "))
	{
	    gui.computerPress(9);
	}
	else if(!spaces[0].equals(symbol) && spaces[0].equals(spaces[8]) && !spaces[0].equals(" ") && spaces[4].equals(" "))
	{
	    gui.computerPress(5);
	}	    
	else if(!spaces[6].equals(symbol) && spaces[6].equals(spaces[2]) && !spaces[6].equals(" ") && spaces[4].equals(" "))
	{
	    gui.computerPress(5);
	}
	else if(!spaces[0].equals(symbol) && spaces[0].equals(spaces[6]) && !spaces[0].equals(" ") && spaces[3].equals(" "))
	{
	    gui.computerPress(4);
	}
	else if(!spaces[6].equals(symbol) && spaces[8].equals(spaces[6]) && !spaces[6].equals(" ") && spaces[7].equals(" "))
	{
	    gui.computerPress(8);
	}
	else if(!spaces[8].equals(symbol) && spaces[8].equals(spaces[2]) && !spaces[8].equals(" ") && spaces[5].equals(" "))
	{
	    gui.computerPress(6);
	}
	else if(!spaces[2].equals(symbol) && spaces[0].equals(spaces[2]) && !spaces[0].equals(" ") && spaces[1].equals(" "))
	{
	    gui.computerPress(2);
	}
	
	//Play a fork. Create an opportunity where computer can win in two ways.
	else if((spaces[0].equals(symbol) && spaces[2].equals(symbol) && spaces[4].equals(" ")) && spaces[6].equals(" ") && spaces[8].equals(" "))
	{
	    gui.computerPress(5);
	}
	else if((spaces[6].equals(symbol) && spaces[8].equals(symbol) && spaces[4].equals(" ")) && spaces[0].equals(" ") && spaces[2].equals(" "))
	{
	    gui.computerPress(5);
	    }
	else if((spaces[6].equals(symbol) && spaces[0].equals(symbol) && spaces[4].equals(" ")) && spaces[8].equals(" ") && spaces[2].equals(" "))
	{
	    gui.computerPress(5);
	}
	else if((spaces[2].equals(symbol) && spaces[8].equals(symbol) && spaces[4].equals(" ")) && spaces[0].equals(" ") && spaces[6].equals(" "))
	{
	    gui.computerPress(5);
	}
	else if((spaces[6].equals(symbol) && spaces[2].equals(symbol) && spaces[8].equals(" ")) && spaces[7].equals(" ") && spaces[5].equals(" "))
	{
	    gui.computerPress(9);
	}
	else if((spaces[6].equals(symbol) && spaces[2].equals(symbol) && spaces[0].equals(" ")) && spaces[1].equals(" ") && spaces[3].equals(" "))
	{
	    gui.computerPress(1);
	}
	else if((spaces[8].equals(symbol) && spaces[0].equals(symbol) && spaces[6].equals(" ")) && spaces[7].equals(" ") && spaces[3].equals(" "))
	{
	    gui.computerPress(7);
	}
	else if((spaces[8].equals(symbol) && spaces[0].equals(symbol) && spaces[2].equals(" ")) && spaces[5].equals(" ") && spaces[1].equals(" "))
	{
	    gui.computerPress(3);
	}
	
	
	//Block a fork
	else if((!spaces[0].equals(symbol) && !spaces[0].equals(" ") && spaces[2].equals(spaces[0]) && spaces[4].equals(" ")) && spaces[6].equals(" ") && spaces[8].equals(" "))
	    {
		gui.computerPress(5);
	    }
	else if((!spaces[0].equals(symbol) && !spaces[0].equals(" ") && spaces[6].equals(spaces[0]) && spaces[4].equals(" ")) && spaces[2].equals(" ") && spaces[8].equals(" "))
	    {
		gui.computerPress(5);
	    }
	else if((!spaces[6].equals(symbol) && !spaces[6].equals(" ") && spaces[6].equals(spaces[8]) && spaces[4].equals(" ")) && spaces[2].equals(" ") && spaces[0].equals(" "))
	    {
		gui.computerPress(5);
	    }
	else if((!spaces[8].equals(symbol) && !spaces[8].equals(" ") && spaces[2].equals(spaces[8]) && spaces[4].equals(" ")) && spaces[6].equals(" ") && spaces[0].equals(" "))
	    {
		gui.computerPress(5);
	    }
	else if((!spaces[6].equals(symbol) && !spaces[6].equals(" ") && spaces[2].equals(spaces[6]) && spaces[8].equals(" ")) && spaces[7].equals(" ") && spaces[5].equals(" "))
	    {
		gui.computerPress(9);
	    }
	else if((!spaces[6].equals(symbol) && !spaces[6].equals(" ") && spaces[2].equals(spaces[6]) && spaces[0].equals(" ")) && spaces[3].equals(" ") && spaces[1].equals(" "))
	    {
		gui.computerPress(1);
	    }
	else if((!spaces[8].equals(symbol) && !spaces[8].equals(" ") && spaces[0].equals(spaces[8]) && spaces[6].equals(" ")) && spaces[3].equals(" ") && spaces[7].equals(" "))
	    {
		gui.computerPress(7);
	    }
	else if((!spaces[8].equals(symbol) && !spaces[8].equals(" ") && spaces[0].equals(spaces[8]) && spaces[1].equals(" ")) && spaces[2].equals(" ") && spaces[5].equals(" "))
	    {
		gui.computerPress(3);
	    }
	
	//Play center if everything above is fails
	else if(spaces[4].equals(" "))
	{
	    gui.computerPress(5);
	}
	
	//Play opposite corner. Player corner if opponent is in the corner
	else if(!spaces[0].equals(symbol) && spaces[8].equals(" ") && !spaces[0].equals(" ")) 
	{
	    gui.computerPress(9);
	}
	else if(!spaces[2].equals(symbol) && spaces[6].equals(" ") && !spaces[2].equals(" "))
	{
	    gui.computerPress(7);
	}
	else if(!spaces[8].equals(symbol) && spaces[0].equals(" ") && !spaces[8].equals(" "))
	{
	    gui.computerPress(1);
	}
	else if(!spaces[6].equals(symbol) && spaces[2].equals(" ") && !spaces[6].equals(" "))
	{
	    gui.computerPress(3);
	}
	
	//Play an empty corner
	else if(spaces[6].equals(" "))
	{
	    gui.computerPress(7);
	}
	else if(spaces[8].equals(" "))
	{
	    gui.computerPress(9);
	}
	else if(spaces[0].equals(" "))
	{
	    gui.computerPress(1);
	}
	else if(spaces[2].equals(" "))
	{
	    gui.computerPress(3);
	}
	
	//Play an empty side. if everything above fails.
	else if(spaces[3].equals(" "))
	{
	    gui.computerPress(3);
	}
	else if(spaces[5].equals(" "))
	{
	    gui.computerPress(3);
	}
	else if(spaces[7].equals(" "))
	{
	    gui.computerPress(8);
	}
	else if(spaces[1].equals(" "))
	{
	    gui.computerPress(2);
	}
    }
}

