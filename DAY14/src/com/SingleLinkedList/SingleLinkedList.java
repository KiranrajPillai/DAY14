package com.SingleLinkedList;

public class SingleLinkedList {
	public static class Node {
        private int data;
        private Node next;

        public Node(int x) {
            this.data = x;
            this.next = null;
        }
    }
    private Node head = null;
    private Node tail = null;
    public void addNode(int x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        tail = newNode;
    }
    public void displayList() {
        Node temp = head;
        if (head == null) {
            System.out.println("Singly Linked List is Empty");
        }
        System.out.println("Node's of Singly Linked List :");
        while (temp != null) {
            System.out.println(temp.data + "");
            temp = temp.next;
        }
        System.out.println();

    }
    public void addToBegin(int x) {
        Node node = new Node(x);
        if (head == null) {
            this.head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
    public void addToEnd(int x) {
        Node node = new Node(x);
        if (head == null) {
            this.head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public Node getHead(){
        return head;
    }

    public void addAtPos(int pos, int x, Node head) {
        Node temp = head;
        Node temp2 = new Node(x);
        temp2.next = null;
        pos--;
        while (pos != 1){
            temp = temp.next;
            pos--;
        }
        temp2.next = temp.next;
        temp.next = temp2;
    }
    public Node remNodeAtBegn(){
        if (head == null){
            return null;
        }else {
            head = head.next;
        }
        return head;
    }
    public void remNodeAtEnd(){
        if (head == null && head.next == null){
            return;
        }
        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }
    public void searchNode(int traget){
        int i=0;
        while (head != null){
            i++;
            if (head.data == traget){
                System.out.println(traget+" Value is at "+ i + " Node");
            }
            head = head.next;
        }
        System.out.println("Singly Linked List is Empty");
    }
    public void remNodeAtPos(int pos, int target, Node head){
        Node temp = head;
        Node prev = head;
        if (temp != null && temp.data == target){
            temp = temp.next;
            return;
        }
        while (temp != null && temp.data != target){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        if (temp == null)
            return;
    }

    public int size(){
        Node temp = head;
        int i = 0;
        while (temp != null){
            i++;
            temp = temp.next;
        }
        return i;
    }
    public void sort(){
        for (Node i = head; i.next != null; i = i.next){
            for (Node j = head; j.next != null; j = j.next){
                if (j.data > i.next.data){
                    int temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
            }
        }
    }



    public static void main(String[] args) {
        SingleLinkedList slList = new SingleLinkedList();
        slList.addToEnd(56);
        slList.addToEnd(30);
        slList.addToEnd(40);
        slList.addAtPos(4, 70, slList.head);

        slList.remNodeAtPos(3, 40, slList.head);

        slList.addToEnd(40);

        slList.sort();

        slList.displayList();

        System.out.println("Total Number of the Linked List is "+slList.size());

    }
}

