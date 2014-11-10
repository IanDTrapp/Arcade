package arcade;

import javax.swing.*;
import java.awt.*;
import java.awt.Component.*;
import java.awt.event.*;
import java.awt.Dimension;

public class GUI implements ActionListener
{
    private JFrame frame;
    private JPanel master;
    private JPanel titlePanel, movePanel, playerXPanel, playerOPanel, boardPanel, ticPanel;
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JLabel ticLabel, moveLabel, playerXLabel, playerOLabel;
    private JPanel mainMenuPanel, mainTitlePanel;
    private JLabel mainTitleLabel;
    private JButton ticButton, blackButton;
    private JPanel deckMain, deckTitlePanel;
    private JLabel deckTitleLabel;
    private JSlider slider;
    private JButton okButton;
    private JPanel blackJackMain, dealerPanel, BJButtonPanel, playerPanel;
    private JButton hit, stand, split;
    private JPanel selectPlayerMain, selectButtonPanel, selectTitlePanel;
    private JLabel selectTitleLabel;
    private JButton computerButton, humanButton;
    private JPanel leaderMain, leaderButtonPanel,leaderTextPanel;
    private JTextArea leaderTextArea;
    private JButton allTime, sinceStart;
    private CardLayout cardLayout;
    //private ComputerPlayer computerPlayer;
    public static String mainMenu = "Main Menu";
    public static String ticTacToe = "Tic Tac Toe";
    public static String numDecks = "Num Decks";
    public static String blackJack = "Black Jack";
    public static String selectPlayer = "Select Player";
    public static String leaderBoard = "Leaderboard";
    public static TicTacToeGame tic = new TicTacToeGame();
    public static HumanPlayer humanPlayer = new HumanPlayer();
    public static HumanPlayer humanPlayer2 = new HumanPlayer();
    public int[] takenSpaces = {0,0,0,0,0,0,0,0,0};

    public static void main(String[] args)
    {
	GUI gui = new GUI();
	gui.GUI();
    }

    private void GUI()
    {
	//Declaring basic frames and layouts, setting some size
	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	frame = new JFrame("Arcade");
	frame.setLayout(new BorderLayout());
	frame.setPreferredSize(size);
	frame.setVisible(true);
	cardLayout = new CardLayout();
	master = new JPanel(cardLayout);

	//TicTacToe GUI
	titlePanel = new JPanel();
	ticLabel = new JLabel("Tic Tac Toe");
	titlePanel.add(ticLabel);
	movePanel = new JPanel();
	moveLabel = new JLabel("Player X, it's your turn!");
	movePanel.add(moveLabel);
	playerXPanel = new JPanel();
	playerXLabel = new JLabel("Test");
	playerOPanel = new JPanel();
	playerOLabel = new JLabel("Test2");
	boardPanel = new JPanel(new GridLayout(3,3));
	ticPanel = new JPanel(new BorderLayout());
	
	//Adding panels to the ticPanel
	ticPanel.add(titlePanel, BorderLayout.NORTH);
	ticPanel.add(boardPanel, BorderLayout.CENTER);
	ticPanel.add(playerXPanel, BorderLayout.WEST);
	ticPanel.add(playerOPanel, BorderLayout.EAST);
	ticPanel.add(movePanel, BorderLayout.SOUTH);

	//Declaring buttons and action listeners
	button1 = new JButton();
	button1.addActionListener(this);
	button2 = new JButton();
	button2.addActionListener(this);
	button3 = new JButton();
	button3.addActionListener(this);
	button4 = new JButton();
	button4.addActionListener(this);
	button5 = new JButton();
	button5.addActionListener(this);
	button6 = new JButton();
	button6.addActionListener(this);
	button7 = new JButton();
	button7.addActionListener(this);
	button8 = new JButton();
	button8.addActionListener(this);
	button9 = new JButton();
	button9.addActionListener(this);

	boardPanel.add(button7);
	boardPanel.add(button8);
	boardPanel.add(button9);
	boardPanel.add(button4);
	boardPanel.add(button5);
	boardPanel.add(button6);
	boardPanel.add(button1);
	boardPanel.add(button2);
	boardPanel.add(button3);
	   
	//Main menu GUI
	mainMenuPanel = new JPanel(new GridLayout(3,1));
	mainTitlePanel = new JPanel();
	mainTitleLabel = new JLabel("Tic Tac Toe");
	mainTitlePanel.add(mainTitleLabel);
	mainMenuPanel.add(mainTitlePanel);
        ticButton = new JButton("Tic Tac Toe");
	ticButton.addActionListener(this);
	blackButton = new JButton("Black Jack");
	blackButton.addActionListener(this);

	//Adding buttons
	mainMenuPanel.add(ticButton);
	mainMenuPanel.add(blackButton);
	
	//Adding panels and setting size/visibility
	frame.add(mainMenuPanel);
	frame.getContentPane().add(mainMenuPanel);
	mainMenuPanel.setPreferredSize(size);
	mainMenuPanel.setVisible(true);
	

	//numDeck GUI
	deckMain = new JPanel(new GridLayout(3,1));
	deckTitlePanel = new JPanel();
	deckTitleLabel = new JLabel("Select number of decks");
	slider = new JSlider(2,8);
	okButton = new JButton("Okay");
	okButton.addActionListener(this);

	deckTitlePanel.add(deckTitleLabel);
        deckMain.add(deckTitlePanel);
	deckMain.add(slider);
	deckMain.add(okButton);
    
	//Blackjack GUI
	blackJackMain = new JPanel(new GridLayout(3,1));
	dealerPanel = new JPanel();
	playerPanel = new JPanel();
	BJButtonPanel = new JPanel();
	hit = new JButton("Hit");
	hit.addActionListener(this);
	stand = new JButton("Stand");
	stand.addActionListener(this);
	split = new JButton("Split");
	split.addActionListener(this);

	//Adding buttons to button panel
	BJButtonPanel.add(hit);
	BJButtonPanel.add(stand);
	BJButtonPanel.add(split);

	//Adding panels to main blackjack panel
	blackJackMain.add(dealerPanel);
	blackJackMain.add(playerPanel);
	blackJackMain.add(BJButtonPanel);
	
	//selectPlayer GUI
	selectPlayerMain = new JPanel(new GridLayout(2,1));
	selectButtonPanel = new JPanel(new GridLayout(2,1));
	selectTitlePanel = new JPanel();
	selectTitleLabel = new JLabel("Select player type");
	selectTitlePanel.add(selectTitleLabel);
	humanButton = new JButton("Human vs Human");
	humanButton.addActionListener(this);
	computerButton = new JButton("Human vs. Computer");
	computerButton.addActionListener(this);

	//Organizing selectPlayer panels
	selectButtonPanel.add(humanButton);
	selectButtonPanel.add(computerButton);
	selectPlayerMain.add(selectTitlePanel);
	selectPlayerMain.add(selectButtonPanel);
   
	//Leaderboard GUI
	leaderMain = new JPanel();
        leaderButtonPanel = new JPanel();
	leaderTextPanel = new JPanel();
	leaderTextArea = new JTextArea();
	leaderTextPanel.add(leaderTextArea);
	allTime = new JButton("All Time");
	allTime.addActionListener(this);
	sinceStart = new JButton("Since Start");
	sinceStart.addActionListener(this);

	//Organizing leaderboard panels
	leaderButtonPanel.add(allTime);
	leaderButtonPanel.add(sinceStart);
	leaderMain.add(leaderButtonPanel);
	leaderMain.add(leaderTextPanel);

	//Master panel for card layout
	master.add(mainMenuPanel, mainMenu);
	master.add(blackJackMain, blackJack);
	master.add(selectPlayerMain, selectPlayer);
	master.add(leaderMain, leaderBoard);
	master.add(ticPanel, ticTacToe);
	master.add(deckMain, numDecks);
	
	//Setting visibility, size, close operation
	master.setPreferredSize(size);
	master.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.add(master, BorderLayout.CENTER);
    }

    public void movePanelUpdate(String update)
    {
	moveLabel.setText(update);
	moveLabel.revalidate();
	moveLabel.repaint();
    }

    public void updateArray(int space)
    {
	takenSpaces[space-1] = getTurn();
    }

    public int[] passArray()
    {
	return takenSpaces;
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
                return 1;
            }
        else
            return 2;
    }

    //Action listeners
    public void actionPerformed(ActionEvent e)
    {
	if(e.getSource() == button1)
	{   
	    if(getTurn() == 2)
	    {
		updateArray(1);
		tic.fillArray(passArray());
		button1.setText("O");
		tic.setHasMoved();
		button1.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(1);
		tic.fillArray(passArray());
		button1.setText("X");
		tic.setHasMoved();
		button1.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }

	    button1.setFont(new Font("Serif", Font.BOLD, 25));
	    button1.revalidate();
	    button1.repaint();
	}
	if(e.getSource() == button2)
	{
		if(getTurn() == 2)
                {
		    updateArray(2);
		    tic.fillArray(passArray());
		    button2.setText("O");
		    tic.setHasMoved();
		    button2.setEnabled(false);
		    movePanelUpdate("Player X, it's your turn!");
		}
                else if(getTurn() == 1)
                {
		    updateArray(2);
		    tic.fillArray(passArray());
		    button2.setText("X");
		    tic.setHasMoved();
		    button2.setEnabled(false);
		    movePanelUpdate("Player O, it's your turn!");
		}
		
                button2.setFont(new Font("Serif", Font.BOLD, 25));
                button2.revalidate();
                button2.repaint();
	}
	if(e.getSource() == button3)
	{
	    if(getTurn() == 2)
	    {
		updateArray(3);
		tic.fillArray(passArray());
		button3.setText("O");
		tic.setHasMoved();
		button3.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(3);
		tic.fillArray(passArray());
		button3.setText("X");
		tic.setHasMoved();
		button3.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }

	    button3.setFont(new Font("Serif", Font.BOLD, 25));
	    button3.revalidate();
	    button3.repaint();
	}
	if(e.getSource() == button4)
	{
	    if(getTurn() == 2)
	    {
		updateArray(4);
		tic.fillArray(passArray());
		button4.setText("O");
		tic.setHasMoved();
		button4.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(4);
		tic.fillArray(passArray());
		button4.setText("X");
		tic.setHasMoved();
		button4.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }

	    button4.setFont(new Font("Serif", Font.BOLD, 25));
	    button4.revalidate();
	    button4.repaint();
	}
	if(e.getSource() == button5)
	{   
	    if(getTurn() == 2)
		{
			updateArray(5);
                        tic.fillArray(passArray());
                        button5.setText("O");
                        tic.setHasMoved();
			button5.setEnabled(false);
			movePanelUpdate("Player X, it's your turn!");
		}
		else if(getTurn() == 1)
                {
		    updateArray(5);
		    tic.fillArray(passArray());
		    button5.setText("X");
		    tic.setHasMoved();
		    button5.setEnabled(false);
		    movePanelUpdate("Player O, it's your turn!");
		}

	    button5.setFont(new Font("Serif", Font.BOLD, 25));
	    button5.revalidate();
	    button5.repaint();
	}
	if(e.getSource() == button6)
	{   
	    if(getTurn() == 2)
	    {
		updateArray(6);
		tic.fillArray(passArray());
		button6.setText("O");
		tic.setHasMoved();
		button6.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(6);
		tic.fillArray(passArray());
		button6.setText("X");
		tic.setHasMoved();
		button6.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }

	    button6.setFont(new Font("Serif", Font.BOLD, 25));
	    button6.revalidate();
	    button6.repaint();
	}
	if(e.getSource() == button7)
	{
	    if(getTurn() == 2)
	    {
		updateArray(7);
		tic.fillArray(passArray());
		button7.setText("O");
		tic.setHasMoved();
		button7.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(7);
		tic.fillArray(passArray());
		button7.setText("X");
		tic.setHasMoved();
		button7.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }

	    button7.setFont(new Font("Serif", Font.BOLD, 25));
	    button7.revalidate();
	    button7.repaint();
	}
	if(e.getSource() == button8)
	{   
	    if(getTurn() == 2)
	    {
		updateArray(8);
		tic.fillArray(passArray());
		button8.setText("O");
		tic.setHasMoved();
		button8.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(8);
		tic.fillArray(passArray());
		button8.setText("X");
		tic.setHasMoved();
		button8.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }

	    button8.setFont(new Font("Serif", Font.BOLD, 25));
	    button8.revalidate();
	    button8.repaint();
	}
	if(e.getSource() == button9)
	{
	    if(getTurn() == 2)
	    {
		updateArray(9);
		tic.fillArray(passArray());
		button9.setText("O");
		tic.setHasMoved();
		button9.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(9);
		tic.fillArray(passArray());
		button9.setText("X");
		tic.setHasMoved();
		button9.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }

	    button9.setFont(new Font("Serif", Font.BOLD, 25));
	    button9.revalidate();
	    button9.repaint();
	}
	if(e.getSource() == ticButton)
	{
	    cardLayout.show(master, selectPlayer);
	    master.revalidate();
	    master.repaint();
	}
	if(e.getSource() == humanButton)
	{
	    tic.playGame("human");
	    cardLayout.show(master, ticTacToe);
	    master.revalidate();
	    master.repaint();
	}
	if(e.getSource() == computerButton)
	{
	    tic.playGame("computer");
	    cardLayout.show(master, ticTacToe);
	    master.revalidate();
	    master.repaint();
	}
	if(e.getSource() == blackButton)
	{
	    cardLayout.show(master, numDecks);
	    master.revalidate();
	    master.repaint();
	}
	if(e.getSource() == okButton)
	{
	    cardLayout.show(master, blackJack);
	    master.revalidate();
	    master.repaint();
	}
    }
}