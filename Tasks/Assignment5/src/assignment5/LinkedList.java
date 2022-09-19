package assignment5;

import java.util.*;

/**
 * A simple linked list.
 * 
 * @author Alexander
 */
public class LinkedList{
    private int size;
    private Node head; // Points to the top of the stack
    
    /**
     * Helper node class.
     */
    private class Node {
        private int value;
        private Node next;
        
        public Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }
        
        public int getValue() {
            return this.value;
        }
    }
    
    public LinkedList() {
        this.size = 0;
        this.head = null;
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        if(this.size == 0) return true;
        else return false;
    }
    
    public void push(int value) {
        Node newHead = new Node(value, this.head);
        this.head = newHead;
        size++;
    }
    
    public Node pop() {
        if(isEmpty()) {
            System.out.println("The list is empty!");
            return null;
        }
        Node popped = this.head;
        this.head = head.next;
        size--;
        return popped;
    }
    
    
    public void appendLast(LinkedList list) {
        Node current = this.head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = list.head;
    }
    
    public void appendFirst(LinkedList list) {
        Node current = list.head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = this.head;
        this.head = list.head;
    }
    
    public void print() {
        if(isEmpty()) System.out.println("The list is empty!");
        else {
            System.out.println(head.getValue() + " <- Top of the stack");
            Node current = head.next;
            while(current != null) {
                System.out.println(current.getValue());
                current = current.next;
            }
        }
    }
    
//    public long benchmark(int size, int iterations) {
//        long t_total = 0;
//        Random rand = new Random();
//        for (int i = 0; i < iterations; i++) {
//            LinkedList list = new LinkedList(); 
//            long t_start = System.nanoTime();
//            for (int j = 0; j < size; j++) {
//                list.push(rand.nextInt(size));
//            }
//            t_total += System.nanoTime() - t_start;
//        }
//        return t_total/iterations;
//    }
    
    public long benchmark(int size, int iterations) {
        long t_total = 0;
        Random rand = new Random();
        for (int i = 0; i < iterations; i++) {
            LinkedList list = new LinkedList();
            for (int j = 0; j < size; j++) {
                long t_start = System.nanoTime();
                list.push(rand.nextInt(size));
                t_total += System.nanoTime() - t_start;
            }
        }
        return (t_total/size)/iterations;
    }
    
    /**
     * Main method with unit testing for the class.
     * 
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList listAppend = new LinkedList();
        
        list.print();
        System.out.println();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.print();
        System.out.println();
        list.pop();
        
        list.print();
        System.out.println();
        list.pop();
        list.pop();
        list.pop();
        list.pop();
        System.out.println();
        list.pop();
        System.out.println();
        list.print();
        
        System.out.println();
        list.push(1);
        list.push(2);
        list.push(3);
        listAppend.push(4);
        listAppend.push(5);
        listAppend.push(6);
        list.appendFirst(listAppend);
        //list.appendLast(listAppend);
        list.print();
        System.out.println();
    }
}
