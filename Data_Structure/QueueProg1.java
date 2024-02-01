/*
Simple Queue implementation
methods :- enqueue,dequeue,display.
 */
package Data_Structure;

import java.util.Scanner;

class Queue{
    int size;
    int arr[];
    int front,rear;
    Scanner sc = new Scanner(System.in);
    Queue(){
        System.out.println("Enter size : ");
        size = sc.nextInt();
        arr = new int[size];
        front = -1;
        rear = -1;
    }
    public void enqueue(){
        if(rear>=size-1){
            System.out.println("Queue OverFlow");
        }
        else{
            if(front==-1){
                front = 0;
            }
            rear++;
            System.out.println("Enter element : ");
            arr[rear] = sc.nextInt();
        }
    }
    public void dequeue(){
        if(front==-1){
            System.out.println("Queue Under-flow");
        }
        else{
            if(front==rear){
                front = -1;
                rear = -1;
            }
            front++;
            System.out.println("Deleted element : "+arr[front]);
        }
    }
    public void display(){
        for(int i = front;i<=rear;i++){
            System.out.println("Element "+(i+1)+" : "+arr[i]);
        }
    }
}
public class QueueProg1 {
    public static void main(String[] args) {
        Queue q = new Queue();
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while(b){
            System.out.println("Enter \n1 for insertion\n2 for deletion\n3 for display\n4 for exit from the program.");
            System.out.println("Enter choice : ");
            int choice = sc.nextInt();
            switch (choice){
                case 1 :
                    System.out.println();
                    for(int i = 0;i<q.size;i++){
                        q.enqueue();
                    }
                break;
                case 2 :
                    System.out.println("\n======================================");
                    System.out.println("Enter limit for delete the element :");
                    int limit = sc.nextInt();
                    System.out.println();
                    for(int i = 0;i<limit;i++){
                        q.dequeue();
                    }
                    System.out.println("======================================\n");
                    break;
                case 3 :
                    System.out.println("\n========================");
                    q.display();
                    System.out.println("\n========================");
                    break;
                case 4 :
                    b = false;
                break;
                default :
                    System.out.println("Enter valid choice !");
                break;
            }
        }
    }
}
