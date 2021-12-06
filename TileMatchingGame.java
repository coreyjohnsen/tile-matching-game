//////////////// P09 Tile Matching Game ///////////////////////////////////////
//
// Title: TileMatchingGame.java
// Course: CS 300 Fall 2021
//
// Author: Corey Johnsen
// Email: cjjohnsen@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

/*
 * This class simulates a tile matching game
 */
public class TileMatchingGame {

  // data
  private TileStack[] columns;

  // constructor

  /**
   * Constructs a new TileMatchingGame with a certain number of columns
   * 
   * @param columnCount is the number of columns the game will have
   */
  public TileMatchingGame(int columnCount) {
    if (columnCount <= 0)
      throw new IllegalArgumentException("invalid number of columns");

    columns = new TileStack[columnCount];
    for (int i = 0; i < columns.length; i++)
      columns[i] = new TileStack();
  }

  // other methods

  /**
   * Clears the column at a given index
   * 
   * @param index is the index of the column to clear
   */
  public void clearColumn(int index) {
    if (index < 0 || index >= columns.length)
      throw new IndexOutOfBoundsException("invalid index");
    columns[index] = new TileStack();
  }

  /**
   * Returns a string representation of the elements in a column
   * 
   * @param index is the index of the column
   * @returns a string representing the tiles in the column
   */
  public String column(int index) {
    if (index < 0 || index >= columns.length)
      throw new IndexOutOfBoundsException("invalid index");
    String returnedString = "";
    for (Tile tile : columns[index]) {
      returnedString += tile + " ";
    }
    return returnedString.strip();
  }

  /**
   * Drops a tile in a column
   * 
   * @param tile  is the tile to drop
   * @param index is the index of the column to drop in
   */
  public void dropTile(Tile tile, int index) {
    if (index < 0 || index >= columns.length)
      throw new IndexOutOfBoundsException("invalid index");
    if (columns[index].size() != 0 && columns[index].peek().equals(tile))
      columns[index].pop();
    else
      columns[index].push(tile);
  }

  /**
   * Gets the number of columns in the game
   * 
   * @returns the number of columns
   */
  public int getColumnsNumber() {
    return columns.length;
  }

  /**
   * Clears all columns in the game
   */
  public void restartGame() {
    for (int i = 0; i < columns.length; i++)
      clearColumn(i);
  }

  /**
   * Gets the game displayed as a string
   * 
   * @returns the game as a string
   */
  public String toString() {
    String returnedString = "GAME COLUMNS:\n";
    for (int i = 0; i < getColumnsNumber(); i++) {
      returnedString += i + ": " + column(i) + "\n";
    }
    return returnedString.strip();
  }

}
