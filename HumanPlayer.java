public class HumanPlayer 
{
    private boolean hasMoved;
    int[] takenSpaces = new int[9];

    public int pickSpace(int space)
    {
	return space;
    }

    public boolean hasMoved()
    {
	hasMoved = false;

	while(hasMoved == false)
	{
	    int counter = 0;
	    counter++;
	}
	return true;
    }

    public void setHasMoved()
    {
	hasMoved = true;
    }

    public int getTurn()
    {
	int count = 0;

	for(int j = 0; j < takenSpaces.length; j++)
	    {
		if(takenSpaces[j] != 0)
		    {
			count++;
		    }
	    }
	if(count%2 == 0)
	    {
		return 2;
	    }
	else
	    return 1;
    }

    public void getArray(int[] takenSpacesArray)
    {
	for(int i = 0; i < takenSpaces.length; i++)
	    {
		takenSpaces[i] = takenSpacesArray[i];
	    }
    }

    public void debugArray()
    {
	for(int k = 0; k < takenSpaces.length; k++)
	    {
		System.out.println(takenSpaces[k]);
	    }
    }
}

