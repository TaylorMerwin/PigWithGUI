package controller;

import java.awt.EventQueue;
import view.GameGUI;

public final class PigMain {

  private PigMain() {
    // do not instantiate objects of this class
    throw new IllegalStateException();
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {

        new GameGUI();
      }
    });
  }

}
