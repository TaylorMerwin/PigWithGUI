package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Die;

public class GameGUI {


  /** The toolkit used to obtain the screen dimensions. */
  private static final Toolkit KIT = Toolkit.getDefaultToolkit();

  /** The Dimension of the screen. */
  private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

  /** The width of the screen. */
  private static final int SCREEN_WIDTH = SCREEN_SIZE.width;

  /** The height of the screen. */
  private static final int SCREEN_HEIGHT = SCREEN_SIZE.height;

  /** The factor for scaling the size of the GUI relative to the current screen size. */
  private static final int SCALE = 3;

  private final ImageIcon[] diceSides = new ImageIcon[] {
      new ImageIcon("assets/Side1.png"),
      new ImageIcon("assets/Side2.png"),
      new ImageIcon("assets/Side3.png"),
      new ImageIcon("assets/Side4.png"),
      new ImageIcon("assets/Side5.png"),
      new ImageIcon("assets/Side6.png")
  };

  private JLabel myDiceLabel;


  /** Frame to contain game */
  private final JFrame myFrame;

  private final JPanel playerActionsPanel;

  private final JPanel playerScorePanel;

  private final JPanel dicePanel;

  private final Die gameDie;

  private JButton holdButton;

  private JButton rollButton;

  private JLabel p1ScoreLabel;

  private JLabel p2ScoreLabel;

  private JLabel gameTitleLabel;

  private JLabel currentScoreLabel;

  private int p1Score = 0;
  private int p2Score = 0;
  private int currentScore = 0;

  private boolean gameOver = false;

  private String playerName = StartScreen.p1Name;


  /* Constructor */
  public GameGUI() {

    myFrame = new JFrame("Pigs of War");

    gameDie = new Die(6);

    playerActionsPanel = new JPanel();
    playerScorePanel = new JPanel();
    dicePanel = new JPanel();

    setupPlayerScores();
    setupPlayerActions();
    setupGUI();
    setupDicePanel();


  }

 // public void nameInputDialog(){
  //  playerName = JOptionPane.showInputDialog("Enter Name");
  //}

  private void setupGUI() {
    myFrame.add(playerScorePanel, BorderLayout.NORTH);
    myFrame.add(playerActionsPanel, BorderLayout.SOUTH);
    myFrame.add(dicePanel, BorderLayout.CENTER);

    myFrame.setSize(SCREEN_WIDTH / SCALE, SCREEN_HEIGHT / SCALE);

    // sets the location of the GUI to middle of screen
    myFrame.setLocation((int) (KIT.getScreenSize().getWidth() / 2 - myFrame.getWidth() / 2)
        , (int) (KIT.getScreenSize().getHeight() / 2 - myFrame.getHeight() / 2));

    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the GUI visible
    myFrame.setVisible(true);
  }

  private void setupPlayerActions() {
    holdButton = new JButton("Hold");

    holdButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        holdDice();
      }
    });
    rollButton = new JButton("Roll");

    rollButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        rollDice();
      }
    });

    playerActionsPanel.setLayout(new GridLayout(1,2));
    playerActionsPanel.add(rollButton);
    playerActionsPanel.add(holdButton);

  }

  private void setupPlayerScores() {
    p1ScoreLabel = new JLabel( playerName + ": " + p1Score, JLabel.CENTER);
    p2ScoreLabel = new JLabel("Player 2: " + p2Score, JLabel.CENTER);
    gameTitleLabel = new JLabel("Pigs of War!", JLabel.CENTER);

    p1ScoreLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
    p2ScoreLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
    gameTitleLabel.setFont(new Font("Impact", Font.PLAIN, 26));

    playerScorePanel.setLayout(new GridLayout(1,3));
    playerScorePanel.add(p1ScoreLabel);
    playerScorePanel.add(gameTitleLabel);
    playerScorePanel.add(p2ScoreLabel);
  }

  private void setupDicePanel() {
    dicePanel.setLayout(new BorderLayout());

    myDiceLabel = new JLabel(diceSides[2]);
    currentScoreLabel = new JLabel("Current Score: " + currentScore);
    currentScoreLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));

    dicePanel.add(myDiceLabel, BorderLayout.CENTER);
    dicePanel.add(currentScoreLabel, BorderLayout.SOUTH);
  }

  private void rollDice() {

    int diceRollValue = gameDie.roll();

    myDiceLabel.setIcon(diceSides[diceRollValue - 1]);

    if (diceRollValue > 1) {
      currentScore = currentScore + diceRollValue;
      currentScoreLabel.setText("Current Score: " + currentScore);
    }
    else {
      currentScore = 0;
      currentScoreLabel.setText("Rolled a 1! No points this turn");
    }
  }

  private void holdDice() {
    p1Score = p1Score + currentScore;
    p1ScoreLabel.setText(playerName + ": " + p1Score);
    currentScore = 0;

  }



}
