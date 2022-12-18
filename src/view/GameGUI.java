package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

  /** Frame to contain game */
  private final JFrame myFrame;

  private final JPanel playerActions;

  private final JPanel playerScores;

  private JButton holdButton;

  private JButton rollButton;

  private JLabel p1ScoreLabel;

  private JLabel p2ScoreLabel;

  private JLabel gameTitleLabel;

  private int p1Score = 0;
  private int p2Score = 0;


  /* Constructor */
  public GameGUI() {

    myFrame = new JFrame("Pigs of War");

    playerActions = new JPanel();
    playerScores = new JPanel();

    setupPlayerScores();
    setupPlayerActions();


    setupGUI();

  }

  private void setupGUI() {
    myFrame.add(playerScores, BorderLayout.NORTH);
    myFrame.add(playerActions, BorderLayout.SOUTH);

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

      }
    });
    rollButton = new JButton("Roll");

    rollButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        p1Score++;
        System.err.println(p1Score);
        p1ScoreLabel.setText("Player 1: " + p1Score);
      }
    });

    playerActions.setLayout(new GridLayout(1,2));
    playerActions.add(rollButton);
    playerActions.add(holdButton);

  }

  private void setupPlayerScores() {
    p1ScoreLabel = new JLabel("Player 1: " + p1Score, JLabel.CENTER);
    p2ScoreLabel = new JLabel("Player 2: " + p2Score, JLabel.CENTER);
    gameTitleLabel = new JLabel("Pigs of War!", JLabel.CENTER);

    p1ScoreLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
    p2ScoreLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
    gameTitleLabel.setFont(new Font("Impact", Font.PLAIN, 26));

    playerScores.setLayout(new GridLayout(1,3));
    playerScores.add(p1ScoreLabel);
    playerScores.add(gameTitleLabel);
    playerScores.add(p2ScoreLabel);
  }



}
