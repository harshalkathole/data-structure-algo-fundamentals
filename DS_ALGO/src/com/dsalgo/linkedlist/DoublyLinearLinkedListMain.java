package com.dsalgo.linkedlist;

class DoublyLinearLinkedList {
    class Node {
        private int data;
        private Node next;
        private Node previous;

        public Node() {
            data = 0;
            next = null;
            previous = null;
        }

        public Node(int data) {
            data = data;
            next = null;
            previous = null;
        }
    }

    private Node head;
    private int count;

    public DoublyLinearLinkedList() {
        head = null;
        count = 0;
    }

    //o(1)
    public void addFirst(int data) {
        Node firstNode = new Node(data);
        if (head == null) {
            head = firstNode;
        } else {
            firstNode.next = head;
            head.previous = firstNode;
            head = firstNode;
        }
        this.count++;
    }

    //o(n)
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
            lastNode.previous = traverseNode;
        }
        this.count++;
    }

    //o(n)
    public void addAtPosition(int data, int position) {
        if (position == count + 1)
            addLast(data);
        else if (position < 1 || position > count + 1)
            throw new RuntimeException("Invalid position: " + position);
        else if (head == null || position == 1) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            Node traverseNode = head;
            Node tempNode;
            for (int i = 1; i < position - 1; i++) {
                traverseNode = traverseNode.next;
            }
            tempNode = traverseNode.next;
            newNode.next = tempNode;
            newNode.previous = traverseNode;
            traverseNode.next = newNode;
            tempNode.previous = newNode;
            this.count++;
        }
    }

    // o(1)
    public void deleteFirst() {
        if (head == null)
            throw new RuntimeException("DoublyLinkedList is EMPTY");
        // If list have only one element
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        count--;
    }

    // o(n)
    public void deleteAtPosition(int position) {
        if (head == null || position == 1) {
            deleteFirst();
        } else {
            Node traverseNode = head;
            // Traversing till position as previous pointer is available
            for (int i = 1; i < position; i++) {
                traverseNode = traverseNode.next;
            }
            traverseNode.previous.next = traverseNode.next;
            if (traverseNode.next != null) {
                traverseNode.next.previous = traverseNode.previous;
            }
            count--;
        }
    }

    public void deleteLast() {
        //TODO
    }

    // o(n)
    public void display() {
        // Display inn Forward order
        Node temp = null;
        System.out.println("Forward List: ");
        if (head == null)
            throw new RuntimeException("List is EMPTY");
        Node traverseNode = head;
        while (traverseNode != null) {
            System.out.println(traverseNode.data + ", ");
            // Check the possibility of using previous pointer instead of temp
            temp = traverseNode;
            traverseNode = traverseNode.next;
        }

        System.out.println();
        // Display in Reverse order
        traverseNode = temp;
        while (traverseNode != null) {
            System.out.print(traverseNode.data + ", ");
            traverseNode = traverseNode.previous;
        }
        System.out.println("Reverse List: ");
    }
}

public class DoublyLinearLinkedListMain {
    public static void main(String[] args) {
        DoublyLinearLinkedList doublyLinearLinkedList = new DoublyLinearLinkedList();
        doublyLinearLinkedList.addFirst(20);
        doublyLinearLinkedList.addLast(10);
        doublyLinearLinkedList.addAtPosition(30, 2);
        doublyLinearLinkedList.display();
    }
}
