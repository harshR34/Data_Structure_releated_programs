package Data_Structure;

import java.util.Scanner;

class DoublyLinkedList{
    class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    Node head = null;
    /*#1*/public void insertAtFirst(int data){
        Node p = new Node(data);
        if(head==null){
            head = p;
        }
        else{
            p.next = head;
            head.prev = p;
            head = p;
        }
    }

    /*#2*/public void insertAtLast(int data){
        Node p = new Node(data);
        if(head == null){
            head = p;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = p;
            p.prev = temp ;
        }
    }
    /*#3*/public void deleteAtFirst(){
        if(head == null){
            System.out.println("Linked list is empty.");
        } else if (head.next == null) {
            System.out.println(head.data+" is deleted successfully.");
            head = null;
        }
        else{
            System.out.println(head.data+" is deleted successfully.");
            head = head.next;
            head.next.prev = null;
            head.prev= null;
        }
    }
    /*#4*/public void deleteAtLast(){
        if(head==null){
            System.out.println("Linked list is empty.");
        } else if (head.next == null) {
            System.out.println(head.data+" is deleted Successfully.");
            head = null;
        }
        else{
            Node temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            System.out.println(temp.data+" is deleted successfully.");
            temp.prev.next = null;
            temp.prev= null;
        }
    }
    /*#5*/public void deleteParticularValue(int value){
        Node temp ;
        int flag = 0;
        if(head==null){
            System.out.println("Linked list is empty.");
        }
        temp = head;
        while(temp!=null){
            if(temp.data==value){
                flag = 1;
                break;
            }
            temp = temp.next;
        }
        if(flag==0){
            System.out.println("Value doesn't exist.");
        }
        else{
            if(head.data==value){
                if(head.next==null){
                    head=null;
                }
                else{
                    head = head.next;
                    head.prev.next = null;
                    head.prev = null;
                }
            }
            else {
                temp = head;
                while (temp.next.data!=value){
                    temp = temp.next;
                }
                temp.next.prev = temp;
                temp.next = temp.next.next;
            }
        }
    }
    /*#6*/public void insertOerderd(int key){
        Node p =  new Node(key);
        Node temp = head;
        if(head==null){
            head = p;
        }
        else if(head.data>p.data){
            p.next = head;
            head.prev = p;
            head = p;
        }
        else{
            temp = head;
            while(temp.next!=null && temp.next.data<=p.data){
                temp = temp.next;
            }
            p.next = temp.next;
            temp.next.prev = p;
            temp.next = p;
        }
    }
    /*#7*/public void insertBeforeValue(int value,int data){
        Node p = new Node(data);
        Node temp = head;
        if(head == null){
            head = p;
        }
        else if(head.data==value){
            p.next = head;
            head.prev = p;
            head = p;
        }
        else{
            int flag = 0;
            while(temp!=null){
                if(temp.data==value){
                    flag = 1;
                    break;
                }
                temp = temp.next;
            }
            if(flag==0){
                System.out.println("Value doesn't exist!");
            }
            else{
                temp = head;
                while(temp.next.data!=value){
                    temp = temp.next;
                }
                p.next = temp.next;
                temp.next.prev = p;
                temp.next = p;
//                p.prev = temp;
//                p.prev.next = p;
            }
        }
    }
    /*#8*/public void deleteOddPosition(){
        head = head.next;
        head.prev = head;
        if(head==null){
            System.out.println("Linked list is empty.");
            return;
        }
        else if(head.next==null){
            head = null;
        }
        else {
            Node temp = head;
            do{
                temp.next = temp.next.next;
                temp = temp.next;
            }while (temp!=null&&temp.next!=null);
        }
    }
    /*#9*/public void deleteEvenPosition(){
        head.prev = head;
        if(head==null){
            System.out.println("Linked list is empty.");
            return;
        }
        else if(head.next==null){
            head = null;
        }
        else {
            Node temp = head;
            do{
                temp.next = temp.next.next;
                temp = temp.next;
            }while (temp!=null&&temp.next!=null);
        }
    }
    /*#10*/public Node reverseDLLWithOutRecursion(Node prevNode,Node current,Node nextNode){
        if(current!=null || current.next!=null){
            return current;
        }
        while (current!=null){
            current.next = prevNode;
            current.prev = nextNode;
            prevNode = current;
            current = nextNode;
            if(nextNode!=null){
                nextNode = nextNode.next;
            }
        }
        current = prevNode;
        return  current;
    }
    /*#11*/public void insertAfterValue(int key,int data){
        Node p = new Node(data);
        if(head==null){
            System.out.println("Linked list is empty.");
        }
        else{
            Node temp = head;
            while(temp.data!=key && temp.next!=null){
                temp = temp.next;
            }
            if(temp.data==key){
                p.next = temp.next;
                temp.next.prev = p;
                temp.next = p;
            }
            else{
                System.out.println("Value not found!");
            }
        }
    }
    /*#12*/public void display(){
        if(head==null){
            System.out.println("Linked list is empty.");
        }
        else{
            for(Node temp = head;temp!=null;temp=temp.next){
                System.out.print(temp.data+" --> ");
            }
        }
    }
    int count (Node head)
    {
        Node temp=head;
        int c=1;
        if ( temp==null) {
            return 0;
        }
        while (temp.next != null)
        {
            c++;
            temp = temp.next;
        }
        return c;
    }

    /*#13*/public void revDisplay(){
        if(head==null){
            System.out.println("Linked list is empty.");
        }
        else{
            Node last = head;
            while(last.next!=null){
                last = last.next;
            }
            while (last!=null){
                System.out.print(last.data+" --> ");
                last = last.prev;
            }
        }
    }
}
public class LinkedList_DLL_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList DLL = new DoublyLinkedList();
        DLL.insertAtLast(10);
        DLL.insertAtLast(20);
        DLL.insertAtLast(30);
        DLL.insertAtLast(40);
        DLL.insertAtLast(50);
        DLL.insertOerderd(10);
        DLL.insertOerderd(1);
        DLL.insertOerderd(-99);
        DLL.insertOerderd(-999);
        DLL.insertOerderd(5);
        DLL.insertOerderd(2);
        DLL.insertOerderd(-1000);
        //DLL.deleteAtFirst();
//
//
//        DLL.insertOerderd(-60);
//        DLL.insertBeforeValue(-999,-2000);
//
//        DLL.insertAfterValue(5,4);
//        System.out.println();
//        DLL.display();
//        System.out.println();
//        DLL.deleteParticularValue(-2000);
//        System.out.println();
//        DLL.display();
//        System.out.println();
//        System.out.println("\ncount : "+DLL.count(DLL.head));
//
//        //DLL.display();
////        DLL.head = DLL.reverseDLLWithOutRecursion(null, DLL.head, DLL.head.next);
        DLL.deleteParticularValue(-99);

        DLL.deleteOddPosition();
        DLL.display();
        System.out.println();
        DLL.revDisplay();
////        System.out.println();
////        DLL.revDisplay();
    }
}
