public class TicTacToe {

    public int playGame(String playerType) {
	// if human vs human game
	int turn = 0;
	TicTacToe tic = new TicTacToe();
	if (playerType.equalsIgnoreCase("human")) {
	    HumanPlayer human1 = new HumanPlayer();
	    HumanPlayer human2 = new HumanPlayer();
	    while (turn <= 5) {
		human1.pickSpace();
		turn++;
		if (turn >= 5) break;
		if (tic.isWinner() != 0) break;
		human2.pickSpace();
		if (tic.isWinner() != 0) break;
	    }
	    return tic.isWinner();
	}
	
	if (playerType.equalsIgnoreCase("computer")) {
	    HumanPlayer human1 = new HumanPlayer();
            ComputerPlayer comp2 = new ComputerPlayer();
            while (turn <= 5) {
                human1.pickSpace();
                turn++;
                if (turn >=5) break;
                if (tic.isWinner() != 0) break;
                comp2.pickSpace();
                if (tic.isWinner() != 0) break;
	    }
	    return tic.isWinner();
        }
	
   }

    pubic int isWinner() {
	
	// Winning conditions
	if((takenSpaces[0] == 1 && takenSpaces[1] == 1 && takenSpaces[2] == 1)
	   || (takenSpaces[3] == 1 && takenSpaces[4] == 1 && takenSpaces[5] == 1)
	   || (takenSpaces[6] == 1 && takenSpaces[7] == 1 && takenSpaces[8] == 1)
	   || (takenSpaces[0] == 1 && takenSpaces[3] == 1 && takenSpaces[6] == 1)
	   || (takenSpaces[1] == 1 && takenSpaces[4] == 1 && takenSpaces[7] == 1)
	   || (takenSpaces[2] == 1 && takenSpaces[5] == 1 && takenSpaces[8] == 1)
	   || (takenSpaces[0] == 1 && takenSpaces[4] == 1 && takenSpaces[8] == 1)
	   || (takenSpaces[2] == 1 && takenSpaces[4] == 1 && takenSpaces[6] == 1)){
	    // If any condition is satisfied, player 1 has won and the method returns 1;
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
	    // If any condition is satisfied, player 2 has won and the method returns 2;
	    return 2;

	}
	// If no condition is met and game has either drawn or not yet been won
	return 0;
	
    }
}