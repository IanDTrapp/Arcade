import javax.swing.*;
import java.awt.*;
import java.awt.Component.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI implements ActionListener
{
    private JFrame frame;
    private JPanel master;
    private JPanel titlePanel, movePanel, playerXPanel, playerOPanel, boardPanel, ticPanel;
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JLabel ticLabel, moveLabel, playerXLabel, playerOLabel, playerXWinsLabel, playerOWinsLabel;
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
    private ComputerPlayer computerPlayer;
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
    int playerXWins = 0; 
    int playerOWins = 0;
    int playerVsCompWins = 0;
    int compWins = 0;
    private BlackJackGame blackJackOb = new BlackJackGame();
    private static int turn = 0;

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
	frame.setSize(size);
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
	playerXPanel = new JPanel(new BorderLayout());
	playerXLabel = new JLabel("Player X Wins:");
	playerXWinsLabel = new JLabel("      " + playerXWins);
	playerXWinsLabel.setFont(new Font("Serif", Font.BOLD, 25));
	playerXPanel.add(playerXLabel, BorderLayout.NORTH);
	playerXPanel.add(playerXWinsLabel, BorderLayout.CENTER);
	playerOPanel = new JPanel(new BorderLayout());
	playerOLabel = new JLabel("Player O Wins:");
	playerOWinsLabel = new JLabel("      " + playerOWins);
	playerOWinsLabel.setFont(new Font("Serif", Font.BOLD, 25));
	playerOPanel.add(playerOLabel, BorderLayout.NORTH);
	playerOPanel.add(playerOWinsLabel, BorderLayout.CENTER);
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

    public void computerPress(int num)
    {
	switch(num)
	{
	case 1: button1.doClick();
	case 2: button2.doClick();
	case 3: button3.doClick();
	case 4: button4.doClick();
	case 5: button5.doClick();
	case 6: button6.doClick();
	case 7: button7.doClick();
	case 8: button8.doClick();
	case 9: button9.doClick();
	}
    }

    public void movePanelUpdate(String update)
    {
	moveLabel.setText(update);
	moveLabel.revalidate();
	moveLabel.repaint();

	gameOver();
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
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, label17;
	JLabel label18, label19, label20, label21, label22;
	
	int size = cardImages.size();

	for(int i = 0; i < size; i++)
	{
	    int labelNumber = i+1;
	    BufferedImage buffImage = (BufferedImage)cardImages.get(i);
	    ImageIcon image = new ImageIcon(buffImage);
	
	    if(player.equalsIgnoreCase("player"))
	    {
		
		switch(labelNumber)
		{
		case 1: label1 = new JLabel(); 
		    label1.setIcon(image);
		    playerPanel.add(label1);
		    break;
		case 2: label2 = new JLabel();
		    label2.setIcon(image);
		    playerPanel.add(label2);
		    break;
		case 3: label3 = new JLabel();
		    label3.setIcon(image);
		    playerPanel.add(label3);
		    break;
		case 4: label4 = new JLabel();
		    label4.setIcon(image);
		    playerPanel.add(label4);
		    break;
		case 5: label5 = new JLabel();
		    label5.setIcon(image);
		    playerPanel.add(label5);
		    break;
		case 6: label6 = new JLabel();
		    label6.setIcon(image);
		    playerPanel.add(label6);
		    break;
		case 7: label7 = new JLabel();
		    label7.setIcon(image);
		    playerPanel.add(label7);
		    break;
		case 8: label8 = new JLabel();
		    label8.setIcon(image);
		    playerPanel.add(label8);
		    break;
		case 9: label9 = new JLabel();
		    label9.setIcon(image);
		    playerPanel.add(label9);
		    break;
		case 10: label10 = new JLabel();
		    label10.setIcon(image);
		    playerPanel.add(label10);
		    break;
		case 11: label11 = new JLabel();
		    label11.setIcon(image);
		    playerPanel.add(label11);
		    break;
		case 12: label12 = new JLabel();
		    label12.setIcon(image);
		    playerPanel.add(label12);
		    break;
		case 13: label13 = new JLabel();
		    label13.setIcon(image);
		    playerPanel.add(label13);
		    break;
		case 14: label14 = new JLabel();
		    label14.setIcon(image);
		    playerPanel.add(label14);
		    break;
		case 15: label15 = new JLabel();
		    label15.setIcon(image);
		    playerPanel.add(label15);
		    break;
		case 16: label16 = new JLabel();
		    label16.setIcon(image);
		    playerPanel.add(label16);
		    break;
		case 17: label17 = new JLabel();
		    label17.setIcon(image);
		    playerPanel.add(label17);
		    break;
		case 18: label18 = new JLabel();
		    label18.setIcon(image);
		    playerPanel.add(label18);
		    break;
		case 19: label19 = new JLabel();
		    label19.setIcon(image);
		    playerPanel.add(label19);
		    break;
		case 20: label20 = new JLabel();
		    label20.setIcon(image);
		    playerPanel.add(label20);
		    break;
		case 21: label21 = new JLabel();
		    label21.setIcon(image);
		    playerPanel.add(label21);
		    break;
		case 22: label22 = new JLabel();
		    label22.setIcon(image);
		    playerPanel.add(label22);
		    break;
		    
		}
	    }
	    
	    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22;

	    if(player.equalsIgnoreCase("dealer"))
	    {
		int labelNum = i+1;
		switch(labelNum)
		{
		case 1: l1 = new JLabel();
		    l1.setIcon(image);
		    dealerPanel.add(l1);
		    break;
		case 2: l2 = new JLabel();
		    l2.setIcon(image);
		    dealerPanel.add(l2);
		    break;
		case 3: l3 = new JLabel();
		    l3.setIcon(image);
		    dealerPanel.add(l3);
		    break;
		case 4: l4 = new JLabel();
		    l4.setIcon(image);
		    dealerPanel.add(l4);
		    break;
		case 5: l5 = new JLabel();
		    l5.setIcon(image);
		    dealerPanel.add(l5);
		    break;
		case 6: l6 = new JLabel();
		    l6.setIcon(image);
		    dealerPanel.add(l6);
		    break;
		case 7: l7 = new JLabel();
		    l7.setIcon(image);
		    dealerPanel.add(l7);
		    break;
		case 8: l8 = new JLabel();
		    l8.setIcon(image);
		    dealerPanel.add(l8);
		    break;
		case 9: l9 = new JLabel();
		    l9.setIcon(image);
		    dealerPanel.add(l9);
		    break;
		case 10: l10 = new JLabel();
		    l10.setIcon(image);
		    dealerPanel.add(l10);
		    break;
		case 11: l11 = new JLabel();
		    l11.setIcon(image);
		    dealerPanel.add(l11);
		    break;
		case 12: l12 = new JLabel();
		    l12.setIcon(image);
		    dealerPanel.add(l12);
		    break;
		case 13: l13 = new JLabel();
		    l13.setIcon(image);
		    dealerPanel.add(l13);
		    break;
		case 14: l14 = new JLabel();
		    l14.setIcon(image);
		    dealerPanel.add(l14);
		    break;
		case 15: l15 = new JLabel();
		    l15.setIcon(image);
		    dealerPanel.add(l15);
		    break;
		case 16: l16 = new JLabel();
		    l16.setIcon(image);
		    dealerPanel.add(l16);
		    break;
		case 17: l17 = new JLabel();
		    l17.setIcon(image);
		    dealerPanel.add(l17);
		    break;
		case 18: l18 = new JLabel();
		    l18.setIcon(image);
		    dealerPanel.add(l18);
		    break;
		case 19: l19 = new JLabel();
		    l19.setIcon(image);
		    dealerPanel.add(l19);
		    break;
		case 20: l20 = new JLabel();
		    l20.setIcon(image);
		    dealerPanel.add(l20);
		    break;
		case 21: l21 = new JLabel();
		    l21.setIcon(image);
		    dealerPanel.add(l21);
		    break;
		case 22: l22 = new JLabel();
		    l22.setIcon(image);
		    dealerPanel.add(l22);
		    break;
		}
	    }
	}
	frame.revalidate();
	frame.repaint();
    }

    /*public void hit(ArrayList passedList, String player)
    {
	Card hitCard = passedList.pop();
	
	BufferedImage img = passedList.get(
	
	if(player.equalsIgnoreCase("player")
	{
	    
	}
	}*/


    //Action listeners
    public void returnToMenu(KeyEvent e)
    {
	int key = e.getKeyCode();
	if (key == KeyEvent.VK_ESCAPE)
	{
	    ticRefresh();
	    cardLayout.show(master, mainMenu);
	}
    }

    public void gameOver()
    {
	if(tic.isWinner() == 1)
	{
	    int selected = gameOverPane.showConfirmDialog(null, "Player X has won! Play again?", "Game over!", JOptionPane.OK_OPTION);
	    if(selected == JOptionPane.YES_OPTION)
            {
		playerXWins++;
		ticRefresh();
		cardLayout.show(master, ticTacToe);
		playerXWinsLabel.setText("      " + playerXWins);
		playerXLabel.revalidate();
		playerXLabel.repaint();
	    }
	    if(selected == JOptionPane.NO_OPTION)
	    {
		playerXWins++;
		ticRefresh();
		cardLayout.show(master, mainMenu);
		playerXWinsLabel.setText("      " + playerXWins);
		playerXLabel.revalidate();
		playerXLabel.repaint();
	    }
	}
	else if(tic.isWinner() == 2)
	{
	    int selected = gameOverPane.showConfirmDialog(null, "Player O has won! Play again?", "Game over!", JOptionPane.OK_OPTION);
	    if(selected == JOptionPane.YES_OPTION)
	    {
		playerOWins++;
		ticRefresh();
		cardLayout.show(master, ticTacToe);
		playerOWinsLabel.setText("      " + playerOWins);
		playerOLabel.revalidate();
		playerOLabel.repaint();
	    }
	    if(selected == JOptionPane.NO_OPTION)
	    {
		playerOWins++;
		ticRefresh();
		cardLayout.show(master, mainMenu);
		playerOWinsLabel.setText("      " + playerOWins);
		playerOLabel.revalidate();
		playerOLabel.repaint();
	    }
	}
	else if(tic.isWinner() == 0 && turn == 9)
	{
	    int selected = gameOverPane.showConfirmDialog(null, "It's a tie! Play again?", "Game over!", JOptionPane.OK_OPTION);
	    if(selected == JOptionPane.OK_OPTION)
	    {
		ticRefresh();
		cardLayout.show(master, ticTacToe);
	    }
	    if(selected == JOptionPane.NO_OPTION)
	    {
		ticRefresh();
		cardLayout.show(master, mainMenu);

	    }
	}
	
	master.repaint();
	master.revalidate();
    }

    public void ticRefresh()
    {
	button1.setText("");
	button1.setEnabled(true);
	button2.setText("");
	button2.setEnabled(true);
	button3.setText("");
	button3.setEnabled(true);
	button4.setText("");
	button4.setEnabled(true);
	button5.setText("");
	button5.setEnabled(true);
	button6.setText("");
	button6.setEnabled(true);
	button7.setText("");
	button7.setEnabled(true);
	button8.setText("");
	button8.setEnabled(true);
	button9.setText("");
	button9.setEnabled(true);
	
	for(int i = 0; i < 9; i++)
	{
	    takenSpaces[i] = 0;
	}

	turn = 0;
	tic.resetArray();
    }

    public void actionPerformed(ActionEvent e)
    {
	if(e.getSource() == button1)
	{   
	    button1.setFont(new Font("Serif", Font.BOLD, 25));
	    
	    if(getTurn() == 2)
	    {
		updateArray(1);
		tic.fillArray(passArray());
		button1.setText("O");
		button1.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(1);
		tic.fillArray(passArray());
		button1.setText("X");
		button1.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }
	    if(getTurn() == 1 && (tic.getGameType()).equalsIgnoreCase("computer"))
	    {
		updateArray(1);
		tic.fillArray(passArray());
		button1.setText("X");
		button1.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		computerPlayer.pickSpace(takenSpaces, gui);
	    }
	    
	    turn++;
	    button1.revalidate();
	    button1.repaint();
	}
	if(e.getSource() == button2)
	{
	    button2.setFont(new Font("Serif", Font.BOLD, 25));

		if(getTurn() == 2)
                {
		    updateArray(2);
		    tic.fillArray(passArray());
		    button2.setText("O");
		    button2.setEnabled(false);
		    movePanelUpdate("Player X, it's your turn!");
		}
                else if(getTurn() == 1)
                {
		    updateArray(2);
		    tic.fillArray(passArray());
		    button2.setText("X");
		    button2.setEnabled(false);
		    movePanelUpdate("Player O, it's your turn!");
		}
		else if(getTurn() == 1 && tic.getGameType().equalsIgnoreCase("computer"))
		{
		    updateArray(2);
		    tic.fillArray(passArray());
		    button2.setText("X");
		    button2.setEnabled(false);
		    movePanelUpdate("Player O, it's your turn!");
		    computerPlayer.pickSpace(takenSpaces, gui);
		}
		
		turn++;
                button2.revalidate();
                button2.repaint();
	}
	if(e.getSource() == button3)
	{
	    button3.setFont(new Font("Serif", Font.BOLD, 25));

	    if(getTurn() == 2)
	    {
		updateArray(3);
		tic.fillArray(passArray());
		button3.setText("O");
		button3.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    } 
	    else if(getTurn() == 1)
	    {
		updateArray(3);
		tic.fillArray(passArray());
		button3.setText("X");
		button3.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");    
	    }
	    else if(getTurn() == 1 && tic.getGameType().equalsIgnoreCase("computer"))
	    {
		updateArray(3);
		tic.fillArray(passArray());
		button3.setText("X");
		button3.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		computerPlayer.pickSpace(takenSpaces, gui);
	    }

	    turn++;
	    button3.revalidate();
	    button3.repaint();
	}
	if(e.getSource() == button4)
	{
	    button4.setFont(new Font("Serif", Font.BOLD, 25));

	    if(getTurn() == 2)
	    {
		updateArray(4);
		tic.fillArray(passArray());
		button4.setText("O");
		button4.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(4);
		tic.fillArray(passArray());
		button4.setText("X");
		button4.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }
	    else if(getTurn() == 1 && tic.getGameType().equalsIgnoreCase("computer"))
	    {
		updateArray(4);
		tic.fillArray(passArray());
		button4.setText("X");
		button4.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		computerPlayer.pickSpace(takenSpaces, gui);
	    }

	    turn++;
	    button4.revalidate();
	    button4.repaint();
	}
	if(e.getSource() == button5)
	{
	    button5.setFont(new Font("Serif", Font.BOLD, 25));

	    if(getTurn() == 2)
	    {
		updateArray(5);
		tic.fillArray(passArray());
		button5.setText("O");
		button5.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");	
	    }
	    else if(getTurn() == 1)
            {
		updateArray(5);
		tic.fillArray(passArray());
		button5.setText("X");
		button5.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");	
	    }
	    else if(getTurn() == 1 && tic.getGameType().equalsIgnoreCase("computer"))
	    {
		updateArray(5);
		tic.fillArray(passArray());
		button5.setText("X");
		button5.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		computerPlayer.pickSpace(takenSpaces, gui);
	    }

	    turn++;
	    button5.setFont(new Font("Serif", Font.BOLD, 25));
	    button5.revalidate();
	    button5.repaint();
	}
	if(e.getSource() == button6)
	{   
	    button6.setFont(new Font("Serif", Font.BOLD, 25));

	    if(getTurn() == 2)
	    {
		updateArray(6);
		tic.fillArray(passArray());
		button6.setText("O");
		button6.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(6);
		tic.fillArray(passArray());
		button6.setText("X");
		button6.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }
	    else if(getTurn() == 1 && tic.getGameType().equalsIgnoreCase("computer"))
	    {
		updateArray(6);
		tic.fillArray(passArray());
		button6.setText("X");
		button6.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		computerPlayer.pickSpace(takenSpaces, gui);
	    }

	    turn++;
	    button6.revalidate();
	    button6.repaint();
	}
	if(e.getSource() == button7)
	{
	    button7.setFont(new Font("Serif", Font.BOLD, 25));

	    if(getTurn() == 2)
	    {
		updateArray(7);
		tic.fillArray(passArray());
		button7.setText("O");
		button7.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(7);
		tic.fillArray(passArray());
		button7.setText("X");
		button7.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }
	    else if(getTurn() == 1 && tic.getGameType().equalsIgnoreCase("computer"))
	    {
		updateArray(7);
		tic.fillArray(passArray());
		button7.setText("X");
		button7.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		computerPlayer.pickSpace(takenSpaces, gui);
	    }

	    turn++;
	    button7.revalidate();
	    button7.repaint();
	}
	if(e.getSource() == button8)
	{   
	    button8.setFont(new Font("Serif", Font.BOLD, 25));

	    if(getTurn() == 2)
	    {
		updateArray(8);
		tic.fillArray(passArray());
		button8.setText("O");
		button8.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(8);
		tic.fillArray(passArray());
		button8.setText("X");
		button8.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }
	    else if(getTurn() == 1 && tic.getGameType().equalsIgnoreCase("computer"))
	    {
		updateArray(8);
		tic.fillArray(passArray());
		button8.setText("X");
		button8.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		computerPlayer.pickSpace(takenSpaces, gui);
	    }

	    turn++;
	    button8.revalidate();
	    button8.repaint();
	}
	if(e.getSource() == button9)
	{
	    button9.setFont(new Font("Serif", Font.BOLD, 25));

	    if(getTurn() == 2)
	    {
		updateArray(9);
		tic.fillArray(passArray());
		button9.setText("O");
		button9.setEnabled(false);
		movePanelUpdate("Player X, it's your turn!");
	    }
	    else if(getTurn() == 1)
	    {
		updateArray(9);
		tic.fillArray(passArray());
		button9.setText("X");
		button9.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
	    }
	    else if(getTurn() == 1 && tic.getGameType().equalsIgnoreCase("computer"))
	    {
		updateArray(9);
		tic.fillArray(passArray());
		button9.setText("X");
		button9.setEnabled(false);
		movePanelUpdate("Player O, it's your turn!");
		computerPlayer.pickSpace(takenSpaces, gui);
	    }

	    turn++;
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
	    tic.setGameType("human");
	    cardLayout.show(master, ticTacToe);
	    master.revalidate();
	    master.repaint();
	}
	if(e.getSource() == computerButton)
	{
	    tic.setGameType("computer");
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
	    blackJackOb.fillImageArrays();
	    master.revalidate();
	    master.repaint();
	}
	if(e.getSource() == hit)
	{
	    blackJackOb.hit("player");
	}
    }
}