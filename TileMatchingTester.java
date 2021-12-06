//////////////// P09 Tile Matching Game ///////////////////////////////////////
//
// Title: TileMatchingTester.java
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

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/*
 * This class tests methods and classes used in the tile matching game
 */
public class TileMatchingTester {

  /*
   * Called when the program runs
   */
  public static void main(String[] args) {

    System.out.println(tileEqualsTester() && tileListIteratorTester() && tileStackTester()
        && tileMatchingGameTester());

  }

  /**
   * Checks if the Tile equals method works as expected
   * 
   * @returns true if the tile equals method works, false otherwise
   */
  public static boolean tileEqualsTester() {
    // test two equal tiles
    Tile tile1 = new Tile(Color.BLACK);
    Tile tile2 = new Tile(Color.BLACK);

    if (!tile1.equals(tile2))
      return false;

    // test two unequal tiles
    tile2 = new Tile(Color.BLUE);

    if (tile1.equals(tile2))
      return false;

    // test a tile and a string
    String tile3 = "Hello";

    try {
      if (tile1.equals(tile3))
        return false;
    } catch (Exception e) {
      // invalid exception
      return false;
    }



    // test null
    Tile tile4 = null;

    try {
      if (tile1.equals(tile4))
        return false;
    } catch (Exception e) {
      // invalid exception
      return false;
    }

    return true;
  }

  /**
   * Checks if the TileListIterator class works as expected
   * 
   * @returns true if the class works, false otherwise
   */
  public static boolean tileListIteratorTester() {

    Tile tile1 = new Tile(Color.ORANGE);
    Tile tile2 = new Tile(Color.BLACK);
    Tile tile3 = new Tile(Color.ORANGE);

    Node node3 = new Node(tile3);
    Node node2 = new Node(tile2, node3);
    Node node1 = new Node(tile1, node2);

    TileListIterator iter = new TileListIterator(node1);

    try {
      // check iterator at index 0
      if (!iter.hasNext())
        return false;

      // check iterator at index 1
      if (!iter.next().equals(tile1))
        return false;
      if (!iter.hasNext())
        return false;

      // check iterator at index 2
      if (!iter.next().equals(tile2))
        return false;
      if (!iter.hasNext())
        return false;

      // check hasNext
      if (!iter.next().equals(tile1))
        return false;
      if (iter.hasNext())
        return false;

    } catch (Exception e) {
      // incorrect exception
      return false;
    }

    try {
      iter.next();
      // no exception thrown
      return false;
    } catch (NoSuchElementException e) {
      // do nothing
    } catch (Exception e) {
      // incorrect exception
      return false;
    }

    return true;
  }

  /**
   * Checks if the TileStack class works as expected
   * 
   * @returns true if the stack works, false otherwise
   */
  public static boolean tileStackTester() {

    return testStackIterator() && testStackSimples() && testStackComplex();

  }

  /**
   * Helper method that checks the pop method of TileStack
   * 
   * @returns true if the method works, false otherwise
   */
  private static boolean testStackComplex() {

    Tile tile1 = new Tile(Color.ORANGE);
    Tile tile2 = new Tile(Color.BLACK);
    Tile tile3 = new Tile(Color.ORANGE);

    TileStack stack = new TileStack();

    stack.push(tile1);
    stack.push(tile2);
    stack.push(tile3);

    // check pop
    if (!stack.pop().equals(tile3) || !stack.peek().equals(tile2))
      return false;
    if (!stack.pop().equals(tile2) || !stack.peek().equals(tile1))
      return false;
    if (!stack.pop().equals(tile1))
      return false;

    // check pop on empty
    try {
      stack.pop();
      // no exception thrown
      return false;
    } catch (EmptyStackException e) {
      // do nothing
    } catch (Exception e) {
      // incorrect exception
      return false;
    }

    return true;
  }

  /**
   * Helper method that checks the isEmpty, size, push, and peek methods of TileStack
   * 
   * @returns true if the methods work, false otherwise
   */
  private static boolean testStackSimples() {

    Tile tile1 = new Tile(Color.ORANGE);
    Tile tile2 = new Tile(Color.BLACK);
    Tile tile3 = new Tile(Color.ORANGE);

    TileStack stack = new TileStack();

    // check isEmpty and size on empty stack
    if (!stack.isEmpty() || stack.size() != 0)
      return false;

    stack.push(tile1);

    // check push
    if (stack.size() != 1 || !stack.peek().equals(tile1))
      return false;

    stack.push(tile2);

    // check push
    if (stack.size() != 2 || !stack.peek().equals(tile2))
      return false;

    stack.push(tile3);

    // check isEmpty, peek, and size on non-empty stack
    if (stack.isEmpty() || stack.size() != 3 || !stack.peek().equals(tile3))
      return false;

    // check peek on empty
    try {
      stack = new TileStack();
      stack.peek();
      // no exception thrown
      return false;
    } catch (EmptyStackException e) {
      // do nothing
    } catch (Exception e) {
      // incorrect exception
      return false;
    }

    return true;
  }

  /**
   * Helper method that checks that the iterator of TileStack works
   * 
   * @returns true if the iterator works, false otherwise
   */
  private static boolean testStackIterator() {

    Tile tile1 = new Tile(Color.ORANGE);
    Tile tile2 = new Tile(Color.BLACK);
    Tile tile3 = new Tile(Color.ORANGE);

    TileStack stack = new TileStack();

    stack.push(tile1);
    stack.push(tile2);
    stack.push(tile3);

    // check if iterator is a tile list iterator and works
    if (!(stack.iterator() instanceof TileListIterator))
      return false;
    if (!stack.iterator().next().equals(tile3))
      return false;

    return true;
  }

  /**
   * Checks if the TileMatchingGame class works as expected
   * 
   * @returns true if the class works, false otherwise
   */
  public static boolean tileMatchingGameTester() {
    return testGameConstructor() && testGame();
  }

  /**
   * Helper method that checks all methods of TileMatchingGame except the constructor
   * 
   * @returns true if the methods work, false otherwise
   */
  private static boolean testGame() {
    // test dropTile
    TileMatchingGame game = new TileMatchingGame(1);
    Tile testTile1 = new Tile(Color.BLUE);
    Tile testTile2 = new Tile(Color.ORANGE);
    Tile testTile3 = new Tile(Color.ORANGE);
    // drop first tile
    game.dropTile(testTile1, 0);
    if (!game.column(0).equals("BLUE"))
      return false;
    // drop second tile
    game.dropTile(testTile3, 0);
    if (!game.column(0).equals("ORANGE BLUE"))
      return false;
    // drop third tile
    game.dropTile(testTile2, 0);
    if (!game.column(0).equals("BLUE"))
      return false;
    // test invalid index
    try {
      game.dropTile(testTile3, -1);
      // no exception thrown
      return false;
    } catch (IndexOutOfBoundsException e) {
      // do nothing
    } catch (Exception e) {
      // invalid exception
      return false;
    }

    // test clearColumn
    game.clearColumn(0);
    if (!game.column(0).equals(""))
      return false;
    // test invalid index
    try {
      game.clearColumn(-1);
      // no exception thrown
      return false;
    } catch (IndexOutOfBoundsException e) {
      // do nothing
    } catch (Exception e) {
      // invalid exception
      return false;
    }

    // test restartGame
    game = new TileMatchingGame(2);
    game.dropTile(testTile1, 1);
    game.dropTile(testTile3, 0);
    game.restartGame();
    if (!game.toString().equals("GAME COLUMNS:\n0: \n1:"))
      return false;

    // test getColumnsNumber
    if (game.getColumnsNumber() != 2)
      return false;


    return true;
  }

  /**
   * Helper method that checks the constructor of TileMatchingGame
   * 
   * @returns true if the constructor works, false otherwise
   */
  private static boolean testGameConstructor() {
    // test valid constructors
    TileMatchingGame game = new TileMatchingGame(3);
    if (game.getColumnsNumber() != 3 && game.toString().equals("GAME COLUMNS:\n0: \n1: \n2:"))
      return false;

    game = new TileMatchingGame(1);
    if (game.getColumnsNumber() != 1 && game.toString().equals("GAME COLUMNS:\n0:"))
      return false;

    // test invalid constructors
    try {
      game = new TileMatchingGame(0);
      // no exception thrown
      return false;
    } catch (IllegalArgumentException e) {
      // do nothing
    } catch (Exception e) {
      // invalid exception
      return false;
    }

    try {
      game = new TileMatchingGame(-7);
      // no exception thrown
      return false;
    } catch (IllegalArgumentException e) {
      // do nothing
    } catch (Exception e) {
      // invalid exception
      return false;
    }

    return true;
  }
}
