/*
Queue program using circular queue.
methods :- enqueue,dequeue,display.
 */
package Data_Structure;

import java.util.Scanner;

class Queue1{
    int queue[];
    int size,front,rear;
    Scanner sc = new Scanner(System.in);
    Queue1(){
        System.out.println("Enter size : ");
        size = sc.nextInt();
        queue = new int[size];
        front = -1;
        rear = -1;
    }
    public void enqueue(){
        //if((rear>=size-1&&front==0)||(front==rear+1)){
        if(front==(rear+1)%size){
            System.out.println("Queue is overFlow");
        }
        else{
            if(front==-1){
                front = 0;
            }
            if(rear>=size-1){
                rear=0;
            }
            else{
                rear++;
            }
            System.out.println("Enter element : ");
            queue[rear] = sc.nextInt();
        }
    }
    public void dequeue(){
        if(front==-1){
            System.out.println("Queue is Under flow");
        }
        else{
            int element = queue[front];
            if(front==rear){
                front = -1;
                rear = -1;
                System.out.println("Deleted Element : " + element);
            }
            else {
                if (front == size - 1) {
                    front = 0;
                } else {
                    front++;
                }
                System.out.println("Deleted Element : " + element);
            }
        }
    }
    public void display(){
        if(front==-1){
            System.out.println("Queue is Empty");
        }
        else {
            if (front > rear) {
                for (int i = 0; i <= rear; i++) {
                    System.out.println("Element " + i + " : " + queue[i]);
                }
                for (int i = front; i <= size - 1; i++) {
                    System.out.println("Element " + i + " : " + queue[i]);
                }
            } else {
                for (int i = front; i <= rear; i++) {
                    System.out.println("Element " + (i + 1) + " : " + queue[i]);
                }
            }
        }
    }
}
public class QueueProg2 {
    public static void main(String[] args) {
        Queue1 q = new Queue1();
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        int limit = 0;
        int flag = 0;
        while(b){
            System.out.println("Enter \n1 for insertion\n2 for deletion\n3 for display\n4 for exit from the program.");
            System.out.println("Enter choice : ");
            int choice = sc.nextInt();
            switch (choice){
                case 1 :
                    System.out.println();
                    if(flag==0) {
                        for (int i = 0; i < q.size; i++) {
                            q.enqueue();
                        }
                    }
                    flag++;
                    if(flag>1){
                        System.out.println("Enter limit for insert the element : ");
                        limit = sc.nextInt();
                        for(int i = 0;i<limit;i++){
                            q.enqueue();
                        }
                    }
                    break;
                case 2 :
                    System.out.println("\n======================================");
                    System.out.println("Enter limit for delete the element :");
                    limit = sc.nextInt();
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
