public class HumanPlayer 
{
    private boolean hasMoved;

    public int[] pickSpace(int space, int symbo)
    {
	int[] info = new int[2];
	info[0] = space;
	info[1] = symbo;

	return info;
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
}

