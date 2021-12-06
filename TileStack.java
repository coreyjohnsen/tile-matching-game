//////////////// P09 Tile Matching Game ///////////////////////////////////////
//
// Title: TileStack.java
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
import java.util.Iterator;

/*
 * This class represents a stack of Tiles
 */
public class TileStack implements Iterable<Tile>, StackADT<Tile> {

  // data
  private Node top;
  private int size;

  // constructor

  /**
   * Creates a new TileStack
   */
  public TileStack() {
    size = 0;
    top = null;
  }

  // other methods

  /**
   * Adds an element to the top of the stack
   * 
   * @param element is the Tile to add
   */
  @Override
  public void push(Tile element) {
    Node newNode = new Node(element);
    newNode.setNext(this.top);
    this.top = newNode;
    size++;
  }

  /**
   * Gets the element on top of the stack and removes it
   * 
   * @returns the Tile on top of the stack
   */
  @Override
  public Tile pop() {
    if (!isEmpty()) {
      Node returned = this.top;
      this.top = this.top.getNext();
      size--;
      return returned.getTile();
    }
    throw new EmptyStackException();
  }

  /**
   * Gets the element on top of the stack
   * 
   * @returns the Tile on top of the stack
   */
  @Override
  public Tile peek() {
    if (top == null)
      throw new EmptyStackException();
    return this.top.getTile();
  }

  /**
   * Determines if the stack is currently empty
   * 
   * @returns true if the stack has no elements, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return size == 0 && top == null;
  }

  /**
   * Gets the size of the stack
   * 
   * @returns the number of elements in the stack
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Creates a new iterator for this stack
   * 
   * @returns a TileListIterator with the head set to the top element
   */
  @Override
  public Iterator<Tile> iterator() {
    return new TileListIterator(this.top);
  }

}
