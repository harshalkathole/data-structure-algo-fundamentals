package com.dsalgo.linkedlist;

import java.util.Scanner;

class SinglyLinkedList {
    class Node {
        private int data;
        private Node next;

        public Node() {
            data = 0;
            next = null;
        }

        public Node(int value) {
            data = value;
            next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    // Time complexity will be o(1) as no matter how many nodes are there, it will take only one step to add new node.
    public void addFirst(int data) {
        Node firstNode = new Node(data);
        firstNode.next = head;
        head = firstNode;
    }

    // Time complexity will be o(n) as it will depend on number of node
    public void addLast(int data) {
        Node lastNode = new Node(data);
        if (head == null) {
            head = lastNode;
        } else {
            Node traverseNode = head;
            while (traverseNode.next != null) {
                traverseNode = traverseNode.next;
            }
            traverseNode.next = lastNode;
        }
    }

    // Time complexity will be o(n)
    public void addAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position < 1)
            throw new RuntimeException("Invalid position: " + position);
        if (head == null || position == 1) {
            addFirst(data);
        } else {
            Node traverseNode = head;
            for (int i = 1; i < position - 1; i++) {
                if (traverseNode.next == null) {
                    throw new RuntimeException("Invalid position " + position);
                }
                traverseNode = traverseNode.next;
            }
            newNode.next = traverseNode.next;
            traverseNode.next = newNode;
        }
    }

    // Time complexity will be o(1)
    public void deleteAtFirst() {
        if (head == null)
            throw new RuntimeException("SinglyLinkedList is EMPTY");
        head = head.next;
    }

    // Time complexity will be o(n) as it will be depending upon postion
    public void deleteAtPosition(int position) {
        if (position < 1)
            throw new RuntimeException("Invalid position: " + position);
        if (head == null || position == 1) {
            deleteAtFirst();
        } else {
            Node traverseNode = head;
            for (int i = 1; i < position - 1; i++) {
                if (traverseNode.next == null) {
                    throw new RuntimeException("Invalid position " + position);
                }
                traverseNode = traverseNode.next;
            }
            if (traverseNode.next == null)
                throw new RuntimeException("Invalid position " + position);
            traverseNode.next = traverseNode.next.next;
        }
    }

    // Time Complexity o(n)
    public void deleteAll() {
        while (head != null)
            deleteAtFirst();
        // head = null; -> This will also work but not effective considering garbage collection
    }

    // Time Complexity o(n)
    public void deleteLast() {
        if (head == null)
            throw new RuntimeException("Linked list is EMPTY");
        if (head.next == null) {
            deleteAtFirst();
        } else {
            Node traverseNode = head;
            while (traverseNode.next != null) {
                traverseNode = traverseNode.next;
                //TODO : Need to update this
                if (traverseNode.next.next == null) {
                    traverseNode.next = null;
                }
            }
        }
    }

    public void display() {
        Node traverseNode = head;
        while (traverseNode != null) {
            System.out.println("SinglyLinkedList: " + traverseNode.data + ",");
            traverseNode = traverseNode.next;
        }
    }
}

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addAtPosition(55, 2);
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addAtPosition(66, 4);
        list.display();
//        list.deleteAtFirst();
        System.out.println("-----");
        list.deleteLast();
//        list.deleteAll();
//        list.deleteAtPosition(6);
        list.display();
    }
}
