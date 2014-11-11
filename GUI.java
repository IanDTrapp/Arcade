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
    public String mainMenu = "Main Menu";
    public String ticTacToe = "Tic Tac Toe";
    public String numDecks = "Num Decks";
    public String blackJack = "Black Jack";
    public String selectPlayer = "Select Player";
    public String leaderBoard = "Leaderboard";
    private TicTacToeGame tic = new TicTacToeGame();
    private HumanPlayer humanPlayer = new HumanPlayer();
    private HumanPlayer humanPlayer2 = new HumanPlayer();
    private JOptionPane gameOverPane = new JOptionPane();
    private int[] takenSpaces = {0,0,0,0,0,0,0,0,0};
    private int numOfDecks;
    private static GUI gui;
    private BlackJackGame blackJackOb = new BlackJackGame();

    public static void main(String[] args)
    {
	gui = new GUI();
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
	slider = new JSlider(2,8,4);
	slider.setMajorTickSpacing(1);
	slider.setPaintTicks(true);
	slider.setSnapToTicks(true);
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

    public int getNumDecks()
    {
	return numOfDecks;
    }

    public void updateCards(ArrayList cardImages, String player)
    {
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18, label19, label20, label21, label22;
	
	int size = cardImages.getSize();

	for(int i = 0; i < size; i++)
	{
	    int labelNumber = i+1;
	    BufferedImage image = cardImages.get(i);
	    if(player.equalsIgnoreCase("human"))
	    {
		switch(labelNumber)
		{
		case 1: label1 = new JLabel(); 
		    label1.setIcon(image);
		    break;
		case 2: label2 = new JLabel();
		    label2.setIcon(image);
		    break;
		case 3: label3 = new JLabel();
		    label3.setIcon(image);
		    break;
		case 4: label4 = new JLabel();
		    label4.setIcon(image);
		    break;
		case 5: label5 = new JLabel();
		    label5.setIcon(image);
		    break;
		case 6: label6 = new JLabel();
		    label6.setIcon(image);
		    break;
		case 7: label7 = new JLabel();
		    label7.setIcon(image);
		    break;
		case 8: label8 = new JLabel();
		    label8.setIcon(image);
		    break;
		case 9: label9 = new JLabel();
		    label9.setIcon(image);
		    break;
		case 10: label10 = new JLabel();
		    label10.setIcon(image);
		    break;
		case 11: label11 = new JLabel();
		    label11.setIcon(image);
		    break;
		case 12: label12 = new JLabel();
		    label12.setIcon(image);
		    break;
		case 13: label13 = new JLabel();
		    label13.setIcon(image);
		    break;
		case 14: label14 = new JLabel();
		    label14.setIcon(image);
		    break;
		case 15: label15 = new JLabel();
		    label15.setIcon(image);
		    break;
		case 16: label16 = new JLabel();
		    label16.setIcon(image);
		    break:
		case 17: label17 = new JLabel();
		    label17.setIcon(image);
		    break;
		case 18: label18 = new JLabel();
		    label18.setIcon(image);
		    break;
		case 19: label19 = new JLabel();
		    label19.setIcon(image);
		    break;
		case 20: label20 = new JLabel();
		    label20.setIcon(image);
		    break;
		case 21: label21 = new JLabel();
		    label21.setIcon(image);
		    break;
		case 22: label22 = new JLabel();
		    label22.setIcon(image);
		    break;
		    
		}
	    }

	    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22;
	    if(player.equalsIgnoreCase("dealer"))
	    {
		int labelNum = i;
		switch(labelNum)
		{
		case 1: l1 = new JLabel();
		    l1.setIcon(image);
		    break;
		case 2: l2 = new JLabel();
		    l2.setIcon(image);
		    break;
		case 3: l3 = new JLabel();
		    l3.setIcon(image);
		    break;
		case 4: l4 = new JLabel();
		    l4.setIcon(image);
		    break;
		case 5: l5 = new JLabel();
		    l5.setIcon(image);
		    break;
		case 6: l6 = new JLabel();
		    l6.setIcon(image);
		    break;
		case 7: l7 = new JLabel();
		    l7.setIcon(image);
		    break;
		case 8: l8 = new JLabel();
		    l8.setIcon(image);
		    break;
		case 9: l9 = new JLabel();
		    l9.setIcon(image);
		    break;
		case 10: l10 = new JLabel();
		    l10.setIcon(image);
		    break;
		case 11: l11 = new JLabel();
		    l11.setIcon(image);
		    break;
		case 12: l12 = new JLabel();
		    l12.setIcon(image);
		    break;
		case 13: l13 = new JLabel();
		    l13.setIcon(image);
		    break;
		case 14: l14 = new JLabel();
		    l14.setIcon(image);
		    break;
		case 15: l15 = new JLabel();
		    l15.setIcon(image);
		    break;
		case 16: l16 = new JLabel():
		    l16.setIcon(image);
		    break;
		case 17: l17 = new JLabel();
		    l17.setIcon(image);
		    break;
		case 18: l18 = new JLabel();
		    l18.setIcon(image);
		    break;
		case 19: l19 = new JLabel();
		    l19.setIcon(image);
		    break;
		case 20: l20 = new JLabel();
		    l20.setIcon(image);
		    break;
		case 21: l21 = new JLabel();
		    l21.setIcon(image);
			   break;
		case 22: l22 = new JLabel();
		    l22.setIcon(image);
		    break;
		}
	    }
	    
	    dealerPanel.add(l1);
	    dealerPanel.add(l2);
	    dealerPanel.add(l3);
	    dealerPanel.add(l4);
	    dealerPanel.add(l5);
	    dealerPanel.add(l6);
	    dealerPanel.add(l7);
	    dealerPanel.add(l8);
	    dealerPanel.add(l9);
	    dealerPanel.add(l10);
	    dealerPanel.add(l11);
	    dealerPanel.add(l12);
	    dealerPanel.add(l13);
	    dealerPanel.add(l14);
	    dealerPanel.add(l15);
	    dealerPanel.add(l16);
	    dealerPanel.add(l17);
	    dealerPanel.add(l18);
	    dealerPanel.add(l19);
	    dealerPanel.add(l20);
	    dealerPanel.add(l21);
	    dealerPanel.add(l22);
	    
	    playerPanel.add(label1);
	    playerPanel.add(label2);
	    playerPanel.add(label3);
	    playerPanel.add(label4);
	    playerPanel.add(label5);
	    playerPanel.add(label6);
	    playerPanel.add(label7);
	    playerPanel.add(label8);
	    playerPanel.add(label9);
	    playerPanel.add(label10);
	    playerPanel.add(label11);
	    playerPanel.add(label12);
	    playerPanel.add(label13);
	    playerPanel.add(label14);
	    playerPanel.add(label15);
	    playerPanel.add(label16);
	    playerPanel.add(label17);
	    playerPanel.add(label18);
	    playerPanel.add(label19);
	    playerPanel.add(label20);
	    playerPanel.add(label21);
	    playerPanel.add(label22);
	}
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
		if(tic.isWinner() == 2)
		{
		    int selected = gameOverPane.showConfirmDialog(null, "Player X has won!", "Game over!", JOptionPane.OK_OPTION);
		    if(selected == JOptionPane.OK_OPTION)
		    {
			cardLayout.show(master, ticTacToe);
			tic.playGame(tic.getGameType(), gui);
		    }
		}
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(1);
		tic.fillArray(passArray());
		button1.setText("X");
		tic.setHasMoved();
		button1.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		if(tic.isWinner() == 1)
		{
		    int selected = gameOverPane.showConfirmDialog(null, "Player O has won!", "Game over!", JOptionPane.OK_OPTION);
		    if(selected == JOptionPane.OK_OPTION)
                    {
                        cardLayout.show(master, ticTacToe);
                        tic.playGame(tic.getGameType(), gui);
                    }
		}
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
		    if(tic.isWinner() == 2)
			{
			    int selected = gameOverPane.showConfirmDialog(null, "Player X has won!", "Game over!", JOptionPane.OK_OPTION);
			    if(selected == JOptionPane.OK_OPTION)
				{
				    cardLayout.show(master, ticTacToe);
				    tic.playGame(tic.getGameType(), gui);
				}
			}
		}
                else if(getTurn() == 1)
                {
		    updateArray(2);
		    tic.fillArray(passArray());
		    button2.setText("X");
		    tic.setHasMoved();
		    button2.setEnabled(false);
		    movePanelUpdate("Player O, it's your turn!");
		    if(tic.isWinner() == 1)
			{
			    int selected = gameOverPane.showConfirmDialog(null, "Player O has won!", "Game over!", JOptionPane.OK_OPTION);
			    if(selected == JOptionPane.OK_OPTION)
				{
				    cardLayout.show(master, ticTacToe);
				    tic.playGame(tic.getGameType(), gui);
				}
			}
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
		if(tic.isWinner() == 1)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player X has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(3);
		tic.fillArray(passArray());
		button3.setText("X");
		tic.setHasMoved();
		button3.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		if(tic.isWinner() == 2)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player O has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
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
		if(tic.isWinner() == 1)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player X has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(4);
		tic.fillArray(passArray());
		button4.setText("X");
		tic.setHasMoved();
		button4.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		if(tic.isWinner() == 2)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player O has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
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
			if(tic.isWinner() == 1)
			    {
				int selected = gameOverPane.showConfirmDialog(null, "Player X has won!", "Game over!", JOptionPane.OK_OPTION);
				if(selected == JOptionPane.OK_OPTION)
				    {
					cardLayout.show(master, ticTacToe);
					tic.playGame(tic.getGameType(), gui);
				    }
			    }
		}
		else if(getTurn() == 1)
                {
		    updateArray(5);
		    tic.fillArray(passArray());
		    button5.setText("X");
		    tic.setHasMoved();
		    button5.setEnabled(false);
		    movePanelUpdate("Player O, it's your turn!");
		    if(tic.isWinner() == 2)
			{
			    int selected = gameOverPane.showConfirmDialog(null, "Player O has won!", "Game over!", JOptionPane.OK_OPTION);
			    if(selected == JOptionPane.OK_OPTION)
				{
				    cardLayout.show(master, ticTacToe);
				    tic.playGame(tic.getGameType(), gui);
				}
			}
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
		if(tic.isWinner() == 1)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player X has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(6);
		tic.fillArray(passArray());
		button6.setText("X");
		tic.setHasMoved();
		button6.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		if(tic.isWinner() == 2)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player O has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
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
		if(tic.isWinner() == 1)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player X has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(7);
		tic.fillArray(passArray());
		button7.setText("X");
		tic.setHasMoved();
		button7.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		if(tic.isWinner() == 2)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player O has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
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
		if(tic.isWinner() == 1)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player X has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(8);
		tic.fillArray(passArray());
		button8.setText("X");
		tic.setHasMoved();
		button8.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		if(tic.isWinner() == 2)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player O has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
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
		if(tic.isWinner() == 1)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player X has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(9);
		tic.fillArray(passArray());
		button9.setText("X");
		tic.setHasMoved();
		button9.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		if(tic.isWinner() == 2)
		    {
			int selected = gameOverPane.showConfirmDialog(null, "Player O has won!", "Game over!", JOptionPane.OK_OPTION);
			if(selected == JOptionPane.OK_OPTION)
			    {
				cardLayout.show(master, ticTacToe);
				tic.playGame(tic.getGameType(), gui);
			    }
		    }
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
	    tic.playGame("human", gui);
	    cardLayout.show(master, ticTacToe);
	    master.revalidate();
	    master.repaint();
	}
	if(e.getSource() == computerButton)
	{
	    tic.playGame("computer", gui);
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
	    numOfDecks = slider.getValue();
	    blackJackOb.playBlackJack(gui);
	    blackJackOb.originalDeal();
	    blackJackOb.updateDisplayedCards();
	    master.revalidate();
	    master.repaint();
	}
    }
}