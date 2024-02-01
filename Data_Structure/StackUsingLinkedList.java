package Data_Structure;

import java.util.Scanner;

class Stack {
    int count;
    Scanner sc = new Scanner(System.in);

    class Node {
        int data;
        Node next;

        Node() {
            next = null;
            count++;
        }
    }

    Node top = null;

    public void push(int data) {
        Node p = new Node();
        if (p == null) {
            System.out.println("\nStack is overflow.");
        } else {
            p.data = data;
            System.out.println(p.data + " Inserted successfully.");
            p.next = top;
            top = p;
        }
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(top.data + " is deleted successfully.");
            top = top.next;
        }
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            for (Node temp = top; temp != null; temp = temp.next) {
                System.out.print(temp.data + " --> ");
            }
        }
    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER SIZE : ");
        int size = sc.nextInt();
        System.out.println("\n------------*=*=*=*=*=*--------------\n");
        for(int i = 0;i<size;i++){
            System.out.println("Enter element "+(i+1)+" : ");
            int element = sc.nextInt();
            stack.push(element);
        }
        System.out.println("\n------------*=*=*=*=*=*--------------\n");
        stack.display();
        System.out.println("\n------------*=*=*=*=*=*--------------\n");
        System.out.println("Enter limit for delete element : ");
        int limit  = sc.nextInt();
        for(int i = 0;i<limit;i++){
            stack.pop();
        }
        System.out.println("\n------------*=*=*=*=*=*--------------\n");
        stack.display();
        System.out.println("\n------------*=*=*=*=*=*--------------\n");

    }
}
