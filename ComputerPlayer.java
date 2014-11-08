public ComputerPlayer {

    public ComputerPlayer() {
	// Default constructor
    }

    // Method for picking the optimal spot
    public int pickSpace(int[] takenSpaces) {
	//Find a win in space 2
	if(((takenSpaces[0]==playerNumber)&&(takenSpaces[1]==playerNumber))||((takenSpaces[5]==playerNumber)&&(takenSpaces[8]==playerNumber))
	   ||((takenSpaces[4]==playerNumber)&&(takenSpaces[6]==playerNumber))){
	    if(takenSpaces[2]==0){
		return 2;
	    }
	}
	//Find a win in space 1
	if(((takenSpaces[0]==playerNumber)&&(takenSpaces[2]==playerNumber))||((takenSpaces[4]==playerNumber)&&(takenSpaces[7]==playerNumber))){
	    if(takenSpaces[1]==0){
		return 1;
	    }
	}
	//Find a win in space 0
	if(((takenSpaces[1]==playerNumber)&&(takenSpaces[2]==playerNumber))||((takenSpaces[3]==playerNumber)&&(takenSpaces[6]==playerNumber))
	   ||((takenSpaces[4]==playerNumber)&&(takenSpaces[8]==playerNumber))){
	    if(takenSpaces[0]==0){
		return 0;
	    }
	}
	//Find a win in space 5
	if(((takenSpaces[2]==playerNumber)&&(takenSpaces[8]==playerNumber))||((takenSpaces[3]==playerNumber)&&(takenSpaces[4]==playerNumber))){
	    if(takenSpaces[5]==0){
		return 5;
	    }
	} 
	//Find a win in space 4
	if(((takenSpaces[3]==playerNumber)&&(takenSpaces[5]==playerNumber))||((takenSpaces[1]==playerNumber)&&(takenSpaces[7]==playerNumber))
	   ||((takenSpaces[0]==playerNumber)&&(takenSpaces[8]==playerNumber))){
	    if(takenSpaces[4]==0){
		return 4;
	    }
	}
	//Find a win in space 3
	if(((takenSpaces[0]==playerNumber)&&(takenSpaces[6]==playerNumber))||((takenSpaces[4]==playerNumber)&&(takenSpaces[5]==playerNumber))){
	    if(takenSpaces[3]==0){
		return 3;
	    }
	}
	//Find a win in space 8
	if(((takenSpaces[2]==playerNumber)&&(takenSpaces[5]==playerNumber))||((takenSpaces[6]==playerNumber)&&(takenSpaces[7]==playerNumber))
	   ||((takenSpaces[0]==playerNumber)&&(takenSpaces[4]==playerNumber))){
	    if(takenSpaces[8]==0){
		return 8;
	    }
	}
	//Find a win in space 7
	if(((takenSpaces[6]==playerNumber)&&(takenSpaces[8]==playerNumber))||((takenSpaces[1]==playerNumber)&&(takenSpaces[4]==playerNumber))){
	    if(takenSpaces[7]==0){
		return 7;
	    }
	}
	//Find a win in space 6
	if(((takenSpaces[7]==playerNumber)&&(takenSpaces[8]==playerNumber))||((takenSpaces[0]==playerNumber)&&(takenSpaces[3]==playerNumber))
	   ||((takenSpaces[4]==playerNumber)&&(takenSpaces[2]==playerNumber))){
	    if(takenSpaces[6]==0){
		return 6;
	    }
	}

	//Block a win in space 2
	if(((takenSpaces[0]==opponentNumber)&&(takenSpaces[1]==opponentNumber))||((takenSpaces[5]==opponentNumber)&&(takenSpaces[8]==opponentNumber))
	   ||((takenSpaces[4]==opponentNumber)&&(takenSpaces[6]==opponentNumber))){
	    if(takenSpaces[2]==0){
		return 2;
	    }
	}
	//Block a win in space 1
	if(((takenSpaces[0]==opponentNumber)&&(takenSpaces[2]==opponentNumber))||((takenSpaces[4]==opponentNumber)&&(takenSpaces[7]==opponentNumber))){
	    if(takenSpaces[1]==0){
		return 1;
	    }
	}
	//Block a win in space 0
	if(((takenSpaces[1]==opponentNumber)&&(takenSpaces[2]==opponentNumber))||((takenSpaces[3]==opponentNumber)&&(takenSpaces[6]==opponentNumber))
	   ||((takenSpaces[4]==opponentNumber)&&(takenSpaces[8]==opponentNumber))){
	    if(takenSpaces[0]==0){
		return 0;
	    }
	}
	//Block a win in space 5
	if(((takenSpaces[2]==opponentNumber)&&(takenSpaces[8]==opponentNumber))||((takenSpaces[3]==opponentNumber)&&(takenSpaces[4]==opponentNumber))){
	    if(takenSpaces[5]==0){
		return 5;
	    }
	}
	//Block a win in space 4
	if(((takenSpaces[3]==opponentNumber)&&(takenSpaces[5]==opponentNumber))||((takenSpaces[1]==opponentNumber)&&(takenSpaces[7]==opponentNumber))
	   ||((takenSpaces[0]==opponentNumber)&&(takenSpaces[8]==opponentNumber))){
	    if(takenSpaces[4]==0){
		return 4;
	    }
	}
	//Block a win in space 3
	if(((takenSpaces[0]==opponentNumber)&&(takenSpaces[6]==opponentNumber))||((takenSpaces[4]==opponentNumber)&&(takenSpaces[5]==opponentNumber))){
	    if(takenSpaces[3]==0){
		return 3;
	    }
	}
	//Block a win in space 8
	if(((takenSpaces[2]==opponentNumber)&&(takenSpaces[5]==opponentNumber))||((takenSpaces[6]==opponentNumber)&&(takenSpaces[7]==opponentNumber))
	   ||((takenSpaces[0]==opponentNumber)&&(takenSpaces[4]==opponentNumber))){
	    if(takenSpaces[8]==0){
		return 8;
	    }
	}
	//Block a win in space 7
	if(((takenSpaces[6]==opponentNumber)&&(takenSpaces[8]==opponentNumber))||((takenSpaces[1]==opponentNumber)&&(takenSpaces[4]==opponentNumber))){
	    if(takenSpaces[7]==0){
		return 7;
	    }
	}
	//Block a win in space 6
	if(((takenSpaces[7]==opponentNumber)&&(takenSpaces[8]==opponentNumber))||((takenSpaces[0]==opponentNumber)&&(takenSpaces[3]==opponentNumber))
	   ||((takenSpaces[4]==opponentNumber)&&(takenSpaces[2]==opponentNumber))){
	    if(takenSpaces[6]==0){
		return 6;
	    }
        }
	
	// Create a fork if player 1
	if (playerNumber == 1){
	    if(takenSpaces[0] == 1 && takenSpaces[8] == 0){
		return 8;
	    }
	    if(takenSpaces[8] == 1 && takenSpaces[0] == 0){
		return 0;
	    }
	    if(takenSpaces[2] == 1 && takenSpaces[6] == 0){
		return 6;
	    }
	    if(takenSpaces[6] == 1 && takenSpaces[2] == 0){
		return 2;
	    }
	        
	    if(takenSpaces[0] == 0){
		return 0;
	    }
	    if(takenSpaces[2] == 0){
		return 2;
	    }
	    if(takenSpaces[6] == 0){
		return 6;
	    }
	    if(takenSpaces[8] == 0){
		return 8;
	    }
	}    

	// Block an opponent's fork if player 2
	if (playerNumber == 2){
	    //Check if opponent has opposite corners
	    if (takenSpaces[0] == 1 && takenSpaces[8] == 1){
		//Play an empty side                         
		if(takenSpaces[1]==0){
		    return 1;
		}
		if(takenSpaces[3]==0){
		    return 3;
		}
		if(takenSpaces[5]==0){
		    return 5;
		}
		if(takenSpaces[7]==0){
		    return 7;
		}
	    }
	    //Check if opponent has opposie corners
	    if (takenSpaces[2] == 1 && takenSpaces[6] == 1){
		//Play an empty side                                                                                                                                 
		if(takenSpaces[1]==0){
		    return 1;
		}
		if(takenSpaces[3]==0){
		    return 3;
		}
		if(takenSpaces[5]==0){
		    return 5;
		}
		if(takenSpaces[7]==0){
		    return 7;
		}
	    }
	}
      
	//Plsite corner
	if((takenSpaces[0]==opponentNumber)&&(takenSpaces[8]==0)){
	    return 8;
	}
	if((takenSpaces[2]==opponentNumber)&&(takenSpaces[6]==0)){
	    return 6;
	}
	if((takenSpaces[6]==opponentNumber)&&(takenSpaces[2]==0)){
	    return 2;
	}
	if((takenSpaces[8]==opponentNumber)&&(takenSpaces[0]==0)){
	    return 0;
	}

	//Play an empty corner
	if(takenSpaces[8]==0){
	    return 8;
	} 
	if(takenSpaces[2]==0){
	    return 2;
	}
	if(takenSpaces[6]==0){
	    return 6;
	}
	if(takenSpaces[0]==0){
	    return 0;
	}

	//Play an empty side
	if(takenSpaces[1]==0){
	    return 1;
	}
	if(takenSpaces[3]==0){
	    return 3;
	}
	if(takenSpaces[5]==0){
	    return 5;
	}
	if(takenSpaces[7]==0){
	    return 7;
	}
	
	return -1;
    }
}
