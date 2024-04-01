package com.example;

// singly linked list class
public class LinkedListNode {

  protected boolean turnRight;
  protected String street;
  protected float distance;
  LinkedListNode next;

  // constructor
  LinkedListNode(Boolean turnRight, String street, Float distance) {
    this.turnRight = turnRight;
    this.street = street;
    this.distance = distance;
    this.next = null;
  }

  // print the node
  public void print() {
    System.out.printf("%s\n", this.toString());
  }

  // to string
  public String toString() {
    String s;
    if (turnRight) {
      s = "turn right";
    } else {
      s = "turn left";
    }

    s += String.format(" on %s, %.2f miles", street, distance);
    return s;
  }

  // comparison
  public Boolean equals(LinkedListNode node) {
    Boolean result;

    result =
      (turnRight == node.turnRight) &&
      (street.compareTo(node.street) == 0) &&
      (distance == node.distance);

    return result;
  }
}
