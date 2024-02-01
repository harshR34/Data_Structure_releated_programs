package Data_Structure;

import java.util.Scanner;

class Queue3 {
    int arr[];
    int size, front, rear;
    Scanner sc = new Scanner(System.in);

    Queue3(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }
    int count ;
    public void enqueue(int data) {
        if (front==(rear+1)%size) {
            System.out.println("Queue is overFlow");
        } else {
            if (front == -1) {
                front = 0;
            }
            if (rear >= size - 1) {
                rear = 0;
            } else {
                rear++;
                count++;
            }
            arr[rear] = data;
        }
    }
    public boolean isEmpty(){
        return front==-1;
    }

    public int dequeue() {
        int element = 0;
        if (isEmpty()) {
            System.out.println("Queue is Under flow");
        } else {
            element = arr[front];
            if (front == rear) {
                front = -1;
                rear = -1;
                return element;
            } else {
                if (front == size - 1) {
                    front = 0;
                } else {
                    front++;
                }
                return element;
            }
        }
        return element;
    }
    public void display(){
        if(front==-1||rear==-1){
            System.out.println("Queue is Empty");
        }
        else {
            if (front>rear) {
                System.out.print("{");
                for (int i = 0; i <= rear; i++) {
                    System.out.print(arr[i]+",");
                }
                for (int i = front; i <= size - 1; i++) {
                    System.out.print(arr[i]+",");
                }
                System.out.print("}\n");
            } else {
                System.out.print("{");
                for (int i = front; i <= rear; i++) {
                    System.out.print(arr[i]+",");
                }
                System.out.print("}\n");
            }
        }
    }
    public void reverseTheQueue(Queue3 Q){
        if(!isEmpty()){
            int X = Q.dequeue();
            reverseTheQueue(Q);
            Q.enqueue(X);
        }
    }
    public void sort(){
        if(front==-1){
            System.out.println("Queue is empty.");
        }
        else{
            for(int i = front;i<=rear;i++){
                for(int j = i+1;j<=rear;j++){
                    if(arr[j]<arr[i]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}

public class QueueProg3 {
    public static void main(String[] args) {
        Queue3 Q = new Queue3(5);
        Q.enqueue(-9);
        Q.enqueue(-8999);
        Q.enqueue(85);
        Q.enqueue(-336326);
        Q.enqueue(15);

        System.out.println("Count :- "+Q.count+"\n");
        Q.display();
        Q.reverseTheQueue(Q);
        System.out.println("\nReverse : \n");
        Q.display();

        Q.sort();
        System.out.println();
        Q.display();

    }
}
