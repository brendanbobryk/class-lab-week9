package com.example;

// singly linked list class
public class SinglyLinkedList {

  LinkedListNode head;

  // constructor
  SinglyLinkedList() {
    this.head = null;
  }

  // insert a new node
  public void insert(Boolean turnRight, String street, Float distance) {
    // create a new node
    LinkedListNode newNode = new LinkedListNode(turnRight, street, distance);

    // if list is empty add the new node as the first node
    if (head == null) {
      head = newNode;
    } else {
      // go to end of list
      LinkedListNode last = head;
      while (last.next != null) {
        last = last.next;
      }
      // insert the new node at end of list
      last.next = newNode;
    }
  }

  public Boolean equals(SinglyLinkedList list2) {
    LinkedListNode currList1 = this.head;
    LinkedListNode currList2 = list2.head;

    // if any nodes do not match, return false
    while (currList1 != null && currList2 != null) {
      // compare the node data
      if (currList1.equals(currList2)) {
        currList1 = currList1.next;
        currList2 = currList2.next;
      } else {
        return false;
      }
    }

    // if we are at the end of both lists ( => they have the same length)
    if (currList1 == null && currList2 == null) {
      return true;
    }

    return false;
  }

  // print the list.
  public void print() {
    LinkedListNode currNode = this.head;

    // traverse through list
    while (currNode != null) {
      currNode.print();
      currNode = currNode.next;
    }
  }

  // clone a copy of this linked list
  public SinglyLinkedList deepClone() {
    SinglyLinkedList newList = new SinglyLinkedList();

    // if list is empty, return a empty list
    if (head == null) {
      return newList;
    }
    // go to end of list
    LinkedListNode curr = head;
    while (curr != null) {
      // insert a copy into new list
      newList.insert(curr.turnRight, curr.street, curr.distance);
      curr = curr.next;
    }

    return newList;
  }
}
