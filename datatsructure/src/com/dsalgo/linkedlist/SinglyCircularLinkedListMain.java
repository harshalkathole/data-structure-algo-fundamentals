package com.dsalgo.linkedlist;

class SinglyCircularLinkedList {
    class Node {
        private int data;
        private Node next;

        public Node() {
            this.data = 0;
            next = null;
        }

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;

    public SinglyCircularLinkedList() {
        head = null;
    }

    public void addAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position < 1)
            throw new RuntimeException("Invalid position: " + position);
        if (head == null || position == 1) {
            addFirst(data);
        } else {
            Node traverseNode = head;
            for (int i = 1; i < position - 1; i++) {
                traverseNode = traverseNode.next;
                if (traverseNode == head) {
                    throw new RuntimeException("Invalid position " + position);
                }
            }
            newNode.next = traverseNode.next;
            traverseNode.next = newNode;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node traverseNode = head;
            while (traverseNode.next != head) {
                traverseNode = traverseNode.next;
            }
            newNode.next = head;
            traverseNode.next = newNode;
        }
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node traverseNode = head;
            while (traverseNode.next != head) {
                traverseNode = traverseNode.next;
            }
            newNode.next = head;
            traverseNode.next = newNode;
        }
    }

    public void deleteFirst() {
        if (head == null)
            throw new RuntimeException("List is EMPTY");
        if (head == head.next) {
            head = null;
        } else {
            Node traverseNode = head;
            while (traverseNode.next != head) {
                traverseNode = traverseNode.next;
            }
            head = head.next;
            traverseNode.next = head;
        }
    }

    public void deleteAll() {
        if (head == null || head.next == head)
            head = null;
        // Convert cirular to linear
        Node temp = head;
    }

    //TODO
    public void deleteAtPosition() {}


    public void display() {
        System.out.println("List: ");
        if (head != null) {
            Node traverseNode = head;
            do {
                System.out.println(traverseNode.data + ",");
                traverseNode = traverseNode.next;
            } while (traverseNode != head);
        }
    }
}

public class SinglyCircularLinkedListMain {
    public static void main(String[] args) {
        SinglyCircularLinkedList circularLinkedList = new SinglyCircularLinkedList();
        circularLinkedList.addLast(10);
        circularLinkedList.addLast(30);
        circularLinkedList.addLast(20);
//        circularLinkedList.addFirst(50);
        circularLinkedList.display();
//        circularLinkedList.addAtPosition(60, 8);
        circularLinkedList.deleteFirst();
        circularLinkedList.display();
    }
}
