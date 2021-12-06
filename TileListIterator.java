//////////////// P09 Tile Matching Game ///////////////////////////////////////
//
// Title: TileListIterator.java
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * This class represents the iterator for a list of tiles
 */
public class TileListIterator implements Iterator<Tile> {

  // data
  private Node current;

  // constructor
  /**
   * Creates a new TileListIterator with a current node
   * 
   * @param head is the Node to start the iterator at
   */
  public TileListIterator(Node head) {
    this.current = head;
  }

  /**
   * Checks if the iterator has a next element
   * 
   * @returns true if the next element is not null, false otherwise
   */
  @Override
  public boolean hasNext() {
    if (current == null)
      return false;
    return true;
  }

  /**
   * Returns the current Tile and moves the iterator to the next node
   * 
   * @returns the current Tile
   */
  @Override
  public Tile next() {
    if (hasNext()) {
      Tile returnedTile = current.getTile();
      current = current.getNext();
      return returnedTile;
    } else {
      throw new NoSuchElementException("No next tile");
    }
  }

}
