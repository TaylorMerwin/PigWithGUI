package controller;

import java.awt.EventQueue;
import view.GameGUI;
import view.StartScreen;

public final class PigMain {

  private PigMain() {
    // do not instantiate objects of this class
    throw new IllegalStateException();
  }

  public static void main(String[] args) {

    //do i put the option pane outside runnable?

    final StartScreen start = new StartScreen();



    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {


        new StartScreen().nameInputDialog();
        new GameGUI();
      }
    });
  }

}
