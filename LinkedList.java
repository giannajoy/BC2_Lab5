/*
 * GEE
 * This is free and unencumbered software released into the public domain.
 */
package gee_lab5;

/**
 * The LinkedList class represents a singly linked list of integers.
 * It supports insertion of elements in non-descending order and removal
 * of duplicate elements while maintaining the order.
 */

public class LinkedList {
    private Node head;

    /**
     * The inner Node class represents a node in the linked list.
     * Each node contains an integer data and a reference to the next node.
     */
    private class Node {
        int data;
        Node next;

        /**
         *  Constructs a new Node with the given data.
         *
         * @param data The integer data to be stored in the node.
         */
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Inserts the given data into the linked list in non-descending order.
     *
     * @param data The integer data to be inserted into the linked list.
     *
     */

    public void insertInOrder(int data) {
        Node newNode = new Node(data);

        if (head == null || data < head.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && data > current.next.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }


    /**
     * Removes duplicate elements from the linked list while maintaining order.
     * After this operation, the linked list contains no more than one copy
     * of any integer, and it remains in non-descending order.
     *
     */
    public void removeDuplicates(){
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                //when a duplicate is found, Remove the duplicate node
                current.next = current.next.next;
            }
            else {
                //Move to the next node
                current = current.next;
            }

        }
    }


    /**
     * Returns a string representation of the linked list.
     * The elements are displayed in a column format.
     *
     * @return A string representation of the linked list.
     *
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data).append("\n");
            current = current.next;
        }
        return result.toString();
    }
}

