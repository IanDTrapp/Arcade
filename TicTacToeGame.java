public class TicTacToeGame 
{
    int[] takenSpaces = {0,0,0,0,0,0,0,0,0};
    GUI gui = null;

    HumanPlayer player1 = new HumanPlayer();
    HumanPlayer player2 = new HumanPlayer();

    boolean humanGame;
    boolean hasMoved = false;

    public void playComputerGame(GUI Gui, ComputerPlayer cp)
    {
	gui = Gui;

	if(gui.getTurn() == 1)
	{
	    return;
	}
	else if(gui.getTurn() == 2)
	{
	    cp.pickSpace(takenSpaces, gui);
	}
    }

    public void setHasMoved(boolean moved)
    {
	hasMoved = moved;
    }

    public void resetArray()
    {
	int size = takenSpaces.length;
	
	for(int i = 0; i < size; i++)
	{
	    takenSpaces[i] = 0;
	}
    }

    public void setGameType(String gameType)
    {
	if(gameType.equalsIgnoreCase("human"))
	{
	    humanGame = true;
	}
	else
	    humanGame = false;
    }

    public String getGameType()
    {
	if(humanGame == true)
	{
	    return "human";
	}
	else
	    return "computer";
    }
    	
    // Fills the array with taken spots
    public void fillArray(int[] spacesArray) 
    {
	for(int i = 0; i < takenSpaces.length; i++)
	{
	    takenSpaces[i] = spacesArray[i];
	}
    } 

    public boolean gameOver()
    {
	if(takenSpaces[6] != 0 && takenSpaces[6] == takenSpaces[7] && takenSpaces[7] == takenSpaces[8])
	    {
		return true;
	    }
	if(takenSpaces[6] != 0 && takenSpaces[6] == takenSpaces[4] && takenSpaces[4] == takenSpaces[2])
	    {
		return true;
	    }
	if(takenSpaces[6] != 0 && takenSpaces[6] == takenSpaces[3] && takenSpaces[3] == takenSpaces[0])
	    {
		return true;
	    }
	if(takenSpaces[3] != 0 && takenSpaces[3] == takenSpaces[4] && takenSpaces[4] == takenSpaces[5])
	    {
		return true;
	    }
	if(takenSpaces[0] != 0 && takenSpaces[0] == takenSpaces[1] && takenSpaces[1] == takenSpaces[2])
	    {
		return true;
	    }
	if(takenSpaces[0] != 0 && takenSpaces[0] == takenSpaces[4] && takenSpaces[4] == takenSpaces[8])
	    {
		return true;
	    }
	if(takenSpaces[7] != 0 && takenSpaces[7] == takenSpaces[4] && takenSpaces[4] == takenSpaces[1])
	    {
		return true;
	    }
	if(takenSpaces[8] != 0 && takenSpaces[8] == takenSpaces[5] && takenSpaces[5] == takenSpaces[2])
	    {
		return true;
	    }
	else 
	    return false;
    }

    
    // Checks to see who is the winner 
    public int isWinner() {
	if((takenSpaces[0] == 1 && takenSpaces[1] == 1 && takenSpaces[2] == 1)
	   || (takenSpaces[3] == 1 && takenSpaces[4] == 1 && takenSpaces[5] == 1)
	   || (takenSpaces[6] == 1 && takenSpaces[7] == 1 && takenSpaces[8] == 1)
	   || (takenSpaces[0] == 1 && takenSpaces[3] == 1 && takenSpaces[6] == 1)
	   || (takenSpaces[1] == 1 && takenSpaces[4] == 1 && takenSpaces[7] == 1)
	   || (takenSpaces[2] == 1 && takenSpaces[5] == 1 && takenSpaces[8] == 1)
	   || (takenSpaces[0] == 1 && takenSpaces[4] == 1 && takenSpaces[8] == 1)
	   || (takenSpaces[2] == 1 && takenSpaces[4] == 1 && takenSpaces[6] == 1)){
	    // If condition is met, return 1 signifing player 1 has won
	    return 1;
	}
	if((takenSpaces[0] == 2 && takenSpaces[1] == 2 && takenSpaces[2] == 2)
	   || (takenSpaces[3] == 2 && takenSpaces[4] == 2 && takenSpaces[5] == 2)
	   || (takenSpaces[6] == 2 && takenSpaces[7] == 2 && takenSpaces[8] == 2)
	   || (takenSpaces[0] == 2 && takenSpaces[3] == 2 && takenSpaces[6] == 2)
	   || (takenSpaces[1] == 2 && takenSpaces[4] == 2 && takenSpaces[7] == 2)
	   || (takenSpaces[2] == 2 && takenSpaces[5] == 2 && takenSpaces[8] == 2)
	   || (takenSpaces[0] == 2 && takenSpaces[4] == 2 && takenSpaces[8] == 2)
	   || (takenSpaces[2] == 2 && takenSpaces[4] == 2 && takenSpaces[6] == 2)){
	    // If condidtion is met, return 2 signifying player 2 has won
	    return 2;
	}
	// If no condition is met, return 0 signifying a draw
	return 0;
    }
}
