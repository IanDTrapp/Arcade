package arcade;

import javax.swing.*;

public class TicTacToeGame 
{
    int[] takenSpaces = {0,0,0,0,0,0,0,0,0};
    GUI gui = new GUI();

    HumanPlayer player1 = new HumanPlayer();
    HumanPlayer player2 = new HumanPlayer();

    private boolean hasMoved;
    private boolean humanGame;

    public int playGame(String gameType) 
    {
	try
	{
	    JOptionPane gameOverPane = new JOptionPane();
	    int turn = 0;

	    // Game of human vs human
	    if (gameType.equalsIgnoreCase("human")) 
	    {
		setGameType("human");

		//Start game loop
		while(isWinner() == 0)
		{
		    hasMoved = false;
		    turn = 0;

		    //Player 1's move
		    while(hasMoved == false) 
		    {
			if(hasMoved == true)
			{
			    turn++;
			    break;
			}
			else
			    Thread.sleep(2000);	
		    }
		
		    //Check if there is a winner
		    if(isWinner() == 1)
		    {
			gameOverPane.showConfirmDialog(null, "Player X won!", "Game over!", JOptionPane.OK_OPTION);
		    }
		    else if(isWinner() == 0 && turn == 9)
		    {
			gameOverPane.showConfirmDialog(null, "There was a tie!", "Game over!", JOptionPane.OK_OPTION);
		    }

		    hasMoved = false;
		
		    //Player 2's turn
		    while(hasMoved == false)
		    {
			if(hasMoved == true)
			{
			    turn++;
			    break;
			}	
			else
			    Thread.sleep(2000);
		    }
		    //Display game results in movePanel
		    if (isWinner() == 1)
		    {
			gameOverPane.showConfirmDialog(null, "Player X has won!", "Game over!", JOptionPane.OK_OPTION);
		    }
		    else if (isWinner() == 2)
		    {
			gameOverPane.showConfirmDialog(null, "Player O has won!", "Game over!", JOptionPane.OK_OPTION);
		    }
		    else if(isWinner() == 0 && turn == 9)
		    {
			gameOverPane.showConfirmDialog(null, "There was a tie!", "Game over!", JOptionPane.OK_OPTION);
		    }
		}
	    }
	
	
	    // Game of human vs computer
	    if (gameType.equalsIgnoreCase("Computer")) 
	    {
		
		setGameType("computer");

		//Start game loop
		while(isWinner() == 0)
		{
		    turn = 0;
		
		    //Player 1's move
		    while (hasMoved == false)
		    {
		    
			hasMoved = false;
		    
			gui.movePanelUpdate("Player X, please pick a space!");
			if(hasMoved == true)
			{
			    turn++;
			    break;
			}
		    }
		    
		    //Check if there is a winner
		    if(isWinner() != 0)
		    {
			break;
		    }
		    
		    //Player 2's turn
		    gui.movePanelUpdate("Player O, please pick a space!");
		    turn++;
		}
	    }
	}
	catch(Exception e)
	{
	    System.out.println(e.getMessage());
	}
	return isWinner();
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
	
    
    public void setHasMoved()
    {
	hasMoved = true;
    }
	

    // Fills the array with taken spots
    public void fillArray(int[] spacesArray) 
    {
	for(int i = 0; i < takenSpaces.length; i++)
		{
		    takenSpaces[i] = spacesArray[i];
		    System.out.println(takenSpaces[i]);
		}

	} 
    
    // Checks to see if there is a winner 
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