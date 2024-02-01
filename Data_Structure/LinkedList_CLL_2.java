package Data_Structure;

import java.util.Scanner;

class CircularLinkedList{
    static int count;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
            count++;
        }
    }
    Node head = null;
    /*#1*/public void insertAtFirst(int data){
        Node p = new Node(data);
        if(head==null){
            head = p;
            p.next = head;
        }
        else{
            p.next = head;
            Node last = head;
            while(last.next!=head){
                last = last.next;
            }
            head = p;
            last.next = head;
        }
    }
    /*#2*/public void insertAtLast(int data){
        Node p = new Node(data);
        if(head == null){
            head = p;
            p.next = head;
        }
        else{
            Node last = head;
            while(last.next!=head){
                last = last.next;
            }
            last.next = p;
            p.next = head;
        }
    }
    /*#3*/public void deleteAtFirst(){
        if(head==null){
            System.out.println("Linked list is empty.");
        } else if (head.next==null) {
            System.out.println(head.data+" is deleted successfully.");
            head=null;
        }
        else{
            Node last = head;
            while(last.next!=head){
                last = last.next;
            }
            System.out.println(head.data + " is deleted successfully.");
            head = head.next;
            last.next = head;
        }
    }
    /*#4*/public int deleteAtLast(){
        if(head==null){
            System.out.println("Linked list is empty.");
        } else if (head.next == null) {
            System.out.println(head.data+" is deleted successfully.");
            head=null;
        }
        else{
            Node last = head;
            while(last.next.next!=head){
                last = last.next;
            }
            last.next = head;
            return last.next.data;
        }
        return 0;
    }
    /*#5*/public void insertBeforeValue(int value,int data){
        Node p = new Node(data);
        Node temp = head;
        if(head==null){
            System.out.println("Linked list is empty");
        } else if (head.data==value) {
            p.next = head;
            Node last = head;
            while (last.next!=head){
                last = last.next;
            }
            head = p;
            last.next = head;
        }
        else{
            int flag = 0;
            do{
                if(temp.data==value){
                    flag=1;
                    break;
                }
                temp = temp.next;
            }while (temp!=head);
            if(flag==0){
                System.out.println("Value doesn't exist!");
            }
            else{
                temp = head;
                while(temp.next.data!=value){
                    temp = temp.next;
                }
                p.next = temp.next;
                temp.next = p;
            }
        }
    }
    /*#6*/public void deletePerticularValue(int value){
        Node temp = head;
        if(head == null){
            System.out.println("Linked list is empty.");
        }
        else{
            int flag = 0;
            do{
                if(temp.data==value){
                    flag=1;
                    break;
                }
                temp = temp.next;
            }while (temp!=head);
            if(flag==0){
                System.out.println("Value not found.");
            }
            else{
                if (head.data == value) {
                    System.out.println(head.data+" is deleted successfully.");
                    Node last = head;
                    while(last.next!=head){
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                }
                else{
                    temp = head;
                    while(temp.next.data!=value){
                        temp = temp.next;
                    }
                    System.out.println(temp.next.data+" is deleted successfully");
                    temp.next = temp.next.next;
                }
            }
        }
    }
    Scanner sc = new Scanner(System.in);
    /*#7*/public void insertOrdered(int data){
        Node p = new Node(data);
        Node temp = head;
        if(head==null){
            head=p;
            p.next = head;
        } else if (head.data>p.data) {
            p.next = head;
            while(temp.next!=head){
                temp = temp.next;
            }
            head = p;
            temp.next = head;
        }
        else{
            temp = head;
            while(temp.next!=head && temp.next.data<=p.data){
                temp = temp.next;
            }
            p.next = temp.next;
            temp.next = p;
        }
    }
    /*#8*/public void K_Rotates(){
        System.out.println("Enter k for rotation : ");
        int k = sc.nextInt();
        for(int i = 0;i<k;i++){
            Node temp = head;
            while(temp.next!=head){
                temp = temp.next;
            }
            head = temp;
        }
    }
    /*#9*/public Node splitLinkedList(int value){
        if(head==null||head.next==head){
            System.out.println("Can't split the linked list.");
            return head;
        }
        else{
            Node temp = head;
            while(temp.data!=value && temp.next!=head){
                temp = temp.next;
            }
            Node temp1 = temp.next;
            temp.next = head;
            Node temp2 = temp1;
            while(temp1.next!=head){
                temp1 = temp1.next;
            }
            temp1.next = temp2;
            return temp2;
        }
    }
    /*#10*/public void deleteOddPosition(){
        Node temp1 = head;
        head = head.next;
        Node temp2 = head;
        if(head==null){
            System.out.println("Linked list is empty.");
            return;
        } else if (head.next==head) {
            head = null;
        }
        else{
            while(temp2.next!=temp1 && temp2.next.next!=temp1){
                temp2.next = temp2.next.next;
                temp2 = temp2.next;
            }
            temp2.next = head;
        }
    }
    /*#11*/public void insertAfterValue(int key,int data){
        Node p = new Node(data);
        if(head==null){
            System.out.println("Linked list is empty.");
        }
        else{
            Node temp = head;
            while(temp.data!=key && temp.next!=head){
                temp = temp.next;
            }
            if(temp.data==key){
                p.next = temp.next;
                temp.next = p;
            }
            else{
                System.out.println("Value not found!");
            }
        }
    }
    /*#12*/public void reverseCLLWithOutRecursion(){
        if(head==null || head.next==head){
            return;
        }
        else{
            Node prevNode = head;
            while(prevNode.next!=head){
                prevNode = prevNode.next;
            }
            Node current = head;
            Node nextNode = head.next;
            do{
                current.next = prevNode;
                prevNode = current;
                current = nextNode;
                nextNode = nextNode.next;
            }while(current!=head);
            head = prevNode;
        }
    }
    /*#13*/public void deleteEvenPosition(){
        if(head==null){
            System.out.println("Linked list is empty.");
            return;
        } else if (head.next==null) {
            head = null;
        }
        else{
            Node temp1 = head;
            while(temp1.next!=head && temp1.next.next!=head){
                temp1.next = temp1.next.next;
                temp1 = temp1.next;
            }
            temp1.next = head;
        }
    }
    int count ()
    {
        Node temp=head;
        int c=1;
        if ( head==null) {
            return 0;
        }
        while (temp.next != head)
        {
            c++;
            temp = temp.next;
        }
        return c;
    }
    /*#14*/public void display(){
        if(head == null){
            System.out.println("Linked list is empty.");
        }
        else{
            Node temp = head;
            System.out.println("-----------*=*=*=*=*=*=*=*=*=*=*--------------");
            do{
                System.out.print(temp.data+" --> ");
                if(temp.next==null){
                    break;
                }
                temp = temp.next;
            }while(temp!=head);
            System.out.println("\n-----------*=*=*=*=*=*=*=*=*=*=*--------------");
        }
    }
}
public class LinkedList_CLL_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList CLL = new CircularLinkedList();
        CLL.insertOrdered(1);
        CLL.insertOrdered(2);
        CLL.insertOrdered(3);
        CLL.insertOrdered(4);
        CLL.insertOrdered(5);
        CLL.insertOrdered(6);
        CLL.insertOrdered(8);

        CLL.insertBeforeValue(8,7);

        System.out.println("Count : "+CLL.count());

        CLL.display();

        System.out.println("Enter value : ");
        int key = sc.nextInt();
        CircularLinkedList Cll = new CircularLinkedList();
        Cll.head = CLL.splitLinkedList(key);

        CLL.display();
        Cll.display();
    }
}
