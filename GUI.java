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
    private HumanPlayer hp;
    private HumanPlayer humanPlayer, humanPlayer2;
    private ComputerPlayer computerPlayer;
    public static String mainMenu = "Main Menu";
    public static String ticTacToe = "Tic Tac Toe";
    public static String numDecks = "Num Decks";
    public static String blackJack = "Black Jack";
    public static String selectPlayer = "Select Player";
    public static String leaderBoard = "Leaderboard";

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
	moveLabel = new JLabel("Test");
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
	moveLabel = update;
	movePanel.revalidate();
	movePanel.repaint();
    }

    public void actionPerformed(ActionEvent e)
    {
	if(e.getSource() == button1)
	    {
		//button1.setIcon(/*asdasd*/);
		if(humanPlayer != null)
                    {
                        humanPlayer.pickSpace(1, 1);
                    }
                if(humanPlayer2 != null)
                    {
                        humanPlayer2.pickSpace(1, 2);
                    }
                if(computerPlayer != null)
                    {
                        computerPlayer.pickSpace(1, 2);
                    }
		button1.revalidate();
		button1.repaint();
	    }
	if(e.getSource() == button2)
	    {
		//button2.setIcon(/*asdasd*/);
		if(humanPlayer != null)
                    {
                        humanPlayer.pickSpace(2, 1);
                    }
                if(humanPlayer2 != null)
                    {
                        humanPlayer2.pickSpace(2, 2);
                    }
                if(computerPlayer != null)
                    {
                        computerPlayer.pickSpace(2, 2);
                    }

		button2.revalidate();
		button2.repaint();
	    }
	if(e.getSource() == button3)
	    {
		//button3.setIcon(/*asdasd*/);
		if(humanPlayer != null)
                    {
                        humanPlayer.pickSpace(3, 1);
                    }
                if(humanPlayer2 != null)
                    {
                        humanPlayer2.pickSpace(3, 2);
                    }
                if(computerPlayer != null)
                    {
                        computerPlayer.pickSpace(3, 2);
                    }
		button3.revalidate();
		button3.repaint();
	    }
	if(e.getSource() == button4)
	    {
		//button4.setIcon(/*asdasd*/);
		if(humanPlayer != null)
                    {
                        humanPlayer.pickSpace(4, 1);
                    }
                if(humanPlayer2 != null)
                    {
                        humanPlayer2.pickSpace(4, 2);
                    }
                if(computerPlayer != null)
                    {
                        computerPlayer.pickSpace(4, 2);
                    }
		button4.revalidate();
		button4.repaint();
	    }
	if(e.getSource() == button5)
	    {
		//button5.setIcon(/*asdasd*/);
		if(humanPlayer != null)
                    {
                        humanPlayer.pickSpace(5, 1);
                    }
                if(humanPlayer2 != null)
                    {
                        humanPlayer2.pickSpace(5, 2);
                    }
                if(computerPlayer != null)
                    {
                        computerPlayer.pickSpace(5, 2);
                    }
		button5.revalidate();
		button5.repaint();
	    }
	if(e.getSource() == button6)
	    {
		//button6.setIcon(/*asdasd*/);
		if(humanPlayer != null)
                    {
                        humanPlayer.pickSpace(6, 1);
                    }
                if(humanPlayer2 != null)
                    {
                        humanPlayer2.pickSpace(6, 2);
                    }
                if(computerPlayer != null)
                    {
                        computerPlayer.pickSpace(6, 2);
                    }
		button6.revalidate();
		button6.repaint();
	    }
	if(e.getSource() == button7)
	    {
		//button7.setIcon(/*asdasd*/);
		if(humanPlayer != null)
                    {
                        humanPlayer.pickSpace(7, 1);
                    }
                if(humanPlayer2 != null)
                    {
                        humanPlayer2.pickSpace(7, 2);
                    }
                if(computerPlayer != null)
                    {
                        computerPlayer.pickSpace(7, 2);
                    }
		button7.revalidate();
		button7.repaint();
	    }
	if(e.getSource() == button8)
	    {
		//button8.setIcon(/*asdasd*/);
		if(humanPlayer != null)
                    {
                        humanPlayer.pickSpace(8, 1);
                    }
                if(humanPlayer2 != null)
                    {
                        humanPlayer2.pickSpace(8, 2);
                    }
                if(computerPlayer != null)
                    {
                        computerPlayer.pickSpace(8, 2);
                    }
		button8.revalidate();
		button8.repaint();
	    }
	if(e.getSource() == button9)
	    {
		//button9.setIcon(/*asdasd*/);
		if(humanPlayer != null)
                    {
                        humanPlayer.pickSpace(9, 1);
                    }
                if(humanPlayer2 != null)
                    {
                        humanPlayer2.pickSpace(9, 2);
                    }
                if(computerPlayer != null)
                    {
                        computerPlayer.pickSpace(9, 2);
                    }
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
		cardLayout.show(master, ticTacToe);
		humanPlayer = new HumanPlayer(1);
		humanPlayer2 = new HumanPlayer(2);
		master.revalidate();
		master.repaint();
	    }
	if(e.getSource() == computerButton)
	    {
		humanPlayer = new HumanPlayer(1);
		computerPlayer = new ComputerPlayer(2);
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