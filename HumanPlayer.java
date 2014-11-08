public class HumanPlayer 
{
    
    private int sym;

    public HumanPlayer (int symbol) 
    {
	sym = symbol;
    }

    public int[] pickSpace(int space, int symbo)
    {
	int[] info = new int[2];
	info[0] = space;
	info[1] = symbo;
    }
}

