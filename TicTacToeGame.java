public class TicTacToeGame {

    int[] takenSpaces = {0,0,0,0,0,0,0,0,0};
    GUI gui = new GUI();

    public int playGame(String gameType) {
	TicTacToeGame tic = new TicTacToeGame();
	int turn = 0;
	// Game of human vs human
	if (gameType.equalsIgnoreCase("human")) {
	    HumanPlayer player1 = new HumanPlayer(1);
	    HumanPlayer player2 = new HumanPlayer(2);
	    while (turn <= 5) {
		gui.movePanelUpdate("Player 1, please pick a space!");
		fillArray(player1.pickSpace());
		if (turn >= 5) break;
		if (tic.isWinner != 0) break;
		gui.movePanelUpdate("Player 2, please pick a space!");
		fillArray(player2.pickSpace());
		if (tic.isWinner != 0) break;
	    }
	    return tic.isWinner();
	}
	// Game of human vs computer
	if (gameType.equalsIgnoreCase("Computer")) {
	    HumanPlayer player1 = new HumanPlayer(1);
	    ComputerPlayer player2 = new ComputerPlayer();
	    while (turn  >= 5) {
		gui.movePanelUpdate("Player 1, please pick a space!");
		fillArray(player1.pickSpace());
		if (turn >= 5) break;
		if (tic.isWinner != 0) break;
		gui.movePanelUpdate("Player 2, please pick a space!");
		player2.pickSpace();
		if (tic.isWinner != 0) break;
	    }
	    return tic.isWinner();
	}
	
    }
    // Fills the array with taken spots
    public void fillArray(int[] info) {
	int space = info[0];
	int symbol = info[1];
	if (space == 0) {    
	    takenSpaces[space] = symbol;
	}
	else gui.movePanelUpdate("Please pick another space");
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
	// If no condition is met, return 9 signifying a draw
	return 0;
    }
}