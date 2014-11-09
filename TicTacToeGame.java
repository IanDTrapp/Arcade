public class TicTacToeGame 
{
    int[] takenSpaces = {0,0,0,0,0,0,0,0,0};
    GUI gui = new GUI();

    public int playGame(String gameType) 
    {
	TicTacToeGame tic = new TicTacToeGame();
	int turn = 0;

	// Game of human vs human
	if (gameType.equalsIgnoreCase("human")) 
	{
	    HumanPlayer player1 = new HumanPlayer();
	    HumanPlayer player2 = new HumanPlayer();

	    //Start game loop
	    while(tic.isWinner() == 0)
	    {
		//Player 1's move
		while (player1.hasMoved() == false) 
		{
		    gui.movePanelUpdate("Player X, please pick a space!");
		    if (player1.hasMoved() == true)
		    { 
			turn++;
			humanPlayer1.getArray(takenSpaces);
		    }
		}
		
		//Check if there is a winner
		if(tic.isWinner() != 0)
		{
		    break;
		}

		//Player 2's turn
		while(player2.hasMoved() == false)
		{
		    gui.movePanelUpdate("Player O, please pick a space!");
		    if(player2.hasMoved() == true)
		    {
			turn++;
			humanPlayer2.getArray(takenSpaces);
		    }	
		}
		// Display game results in movePanel
		if (tic.isWinner() == 1)
		    {
			gui.movePanelUpdate("Player X has won!");
		    }
		if (tic.isWinner() == 2)
		    {
			gui.movePanelUpdate("Player O has won!");
		    }
		else gui.movePanelUpdate("There is a tie!");
	    }
	}

	// Game of human vs computer
	if (gameType.equalsIgnoreCase("Computer")) 
	{
	    HumanPlayer player1 = new HumanPlayer();
            //ComputerPlayer player2 = new ComputerPlayer();

            //Start game loop
            while(tic.isWinner() == 0)
		{
		    //Player 1's move
		    while (player1.hasMoved() == false)
			{
			    gui.movePanelUpdate("Player X, please pick a space!");
			    if (player1.hasMoved() == true)
				{
				    turn++;
				}
			}

		    //Check if there is a winner
		    if(tic.isWinner() != 0)
			{
			    break;
			}

		    //Player 2's turn
		    gui.movePanelUpdate("Player O, please pick a space!");
		    turn++;
		}
        }
	return tic.isWinner();
    }	

    // Fills the array with taken spots
    public void fillArray(int[] info) 
    {
	int space = info[0];
	int symbol = info[1];
	if (takenSpaces[space-1] == 0) 
	{    
	    takenSpaces[space-1] = symbol;
	}
	else 
	    gui.movePanelUpdate("Please pick another space");
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