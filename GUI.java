import javax.swing.*;

public class GUI
{
    private Frame frame;
    private JPanel titlePanel, movePanel;
    private JPanel playerXPanel, playerOPanel;
    private JPanel boardPanel;
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;

    private void GUI()
    {
	// come back and fix for different methods
	generateTicTacToeGUI();
    }

    private void generateTicTacToeGUI()
    {

	frame = new Frame("Arcade", new BorderLayout());
	titlePanel = new JPanel();
	movePanel = new JPanel();
	playerXPanel = new JPanel();
	playerOPanel = new JPanel();
	boardPanel = new JPanel(new GridLayout(3,3));
	
	button1 = new JButton();
	button2 = new JButton();
	button3 = new JButton();
	button4 = new JButton();
	button5 = new JButton();
	button6 = new JButton();
	button7 = new JButton();
	button8 = new JButton();
	button9 = new JButton();

	boardPanel.add(button7);
	boardPanel.add(button8);
	boardPanel.add(button9);
	boardPanel.add(button4);
	boardPanel.add(button5);
	boardPanel.add(button6);
	boardPanel.add(button1);
	boardPanel.add(button2);
	boardPanel.add(button3);
	
	frame.add(titlePanel, BorderLayout.NORTH);
	frame.add(playerXPanel, BorderLayout.WEST);
	frame.add(playerOPanel, BorderLayout.EAST);
	frame.add(boardPanel, BorderLayout.CENTER);
	frame.add(movePanel, BorderLayout.SOUTH);
    }
    
    public void mainMenuGUI() 
    {
	JPanel main = new JPanel(new GridLayout(3,1));
	JPanel titlePanel = new JPanel();
	JLabel titleLabel = new JLabel("Tic Tac Toe");
	titlePanel.add(titleLabel);
	main.add(titlePanel);
	JButton ticButton = new JButton("Tic Tac Toe");
	JButton blackButton = new JButton("Black Jack");
	main.add(ticButton);
	main.add(blackButton);
    }

    public void numDeckGUI() 
    {
	JPanel main = new JPanel(new GridLayout(2,1));
	JPanel titlePanel = new JPanel();
	JLabel titleLabel = new JLabel("Select number of decks");
	JSlider slider = new JSlider(2,8);
	titlePanel.add(titleLabel);
        main.add(titlePanel);
	main.add(slider);
    }
	
    public void blackJackGUI()
    {
	JPanel main = new JPanel(new GridLayout(3,1));
	JPanel dealerPanel = new JPanel();
	JPanel playerPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JButton hit = new JButton("Hit");
	JButton stand = new JButton("Stand");
	JButton split = new JButton("Split");
	buttonPanel.add(hit);
	buttonPanel.add(stand);
	if (split.canSplit()){
	    buttonPanel.add(split);
	}
	main.add(dealerPanel);
	main.add(playerPanel);
	main.add(buttonPanel);
	
    }

    public void selectPlayerTicGUI()
    {
	JPanel main = new JPanel();
	JPanel buttonPanel = new JPanel(new GridLayout(2,1));
	JPanel titlePanel = new JPanel();
	JLabel titleLabel = new JLabel("Select player type");
	titlePanel.add(titleLabel);
	JButton humanButton = new JButton("Human vs Human");
	JButton computerButton = new JButton("Human vs. Computer");
	buttonPanel.add(humanButton);
	buttonPanel.add(computerButton);
	
	main.add(titlePanel);
	main.add(buttonPanel);
    }
    
    public void leaderBoardGUI()
    {
	JPanel main = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel textPanel = new JPanel();
	JTextArea textArea = new JTextArea();
	textPanel.add(textArea);

	JButton allTime = new JButton("All Time");
	JButton sinceStart = new JButton("Since Start");
	buttonPanel.add(allTime);
	buttonPanel.add(sinceStart);

	main.add(buttonPanel);
	main.add(textPanel);
    }
}