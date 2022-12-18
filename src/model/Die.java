package model;

public class Die {

  /** The number of faces or sides the die has. */
  final private int sides;

  public Die(int sides) {
    this.sides = sides;
  }

  public int getSides() {
    return sides;
  }


  /**
   *  Used to determine value of a dice roll
   * @return face value of die
   */
  public int roll() {
    return 1 + (int) (Math.random() * sides);
  }

}
