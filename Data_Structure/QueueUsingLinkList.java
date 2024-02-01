package Data_Structure;

import java.util.Scanner;

class QueueUsingLL{
    int count;
    Scanner sc = new Scanner(System.in);
    class Node{
        int data;
        Node next;
        Node(){
            System.out.println("Enter Data "+(count+1)+" : ");
            data = sc.nextInt();
            next = null;
            count++;
        }
    }
    Node front = null;
    Node rear = null;
    public void enqueue(){
        Node p = new Node();
        if(front==null){
            front = p;
            rear = p;
        }
        else{
            rear.next = p;
            rear = p;
        }
        System.out.println(p.data+" is Inserted successfully.");
    }
    public void dequeue(){
        if(front==null){
            System.out.println("Queue is empty");
        }
        else{
            if(front==rear){
                front=rear=null;
            }
            else{
                System.out.println(front.data+" is deleted successfully");
                front = front.next;
            }
        }
    }
    public void displayLL(){
        if(front==null){
            System.out.println("Linked list is empty.");
        }
        else {
            System.out.println("===============================");
            System.out.print("{");
            for(Node temp = front; temp!=null; temp=temp.next){
                System.out.print(temp.data+",");
            }
            System.out.print("}");
            System.out.println("\n===============================\n");
        }
    }
    public void callOperation(){
        QueueUsingLL quell = new QueueUsingLL();
        int size=0,limit = 0;
        boolean b = true;
        while(b){
            System.out.println("\nEnter \n===========================" +
                    "\n1 for insert element" +
                    "\n2 for delete element" +
                    "\n3 for display" +
                    "\n4 for exit.\n============================");
            int choice = sc.nextInt();
            switch(choice){
                case 1 :
                    System.out.println("Enter size for insert element : ");
                    size = sc.nextInt();
                    quell.count=0;
                    for(int i = 0;i<size;i++){
                        quell.enqueue();
                    }
                    break;
                case 2 :
                    System.out.println("Enter limit for delete the element : ");
                    limit = sc.nextInt();
                    for(int i = 0;i<limit;i++){
                        quell.dequeue();
                        quell.count--;
                    }
                    break;
                case 3 :
                    quell.displayLL();
                    break;
                case 4 :
                    b = false;
                    break;
                default:
                    System.out.println("Enter valid choice.");
                    break;
            }
        }
    }
}
public class QueueUsingLinkList {
    public static void main(String[] args) {
        QueueUsingLL quell = new QueueUsingLL();
        quell.callOperation();
    }
}
