package Data_Structure;

import java.util.Scanner;

class Queue2{
    int arr[];
    int size,front,rear;
    Scanner sc = new Scanner(System.in);
    Queue2(int size){
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    public int enqueue(int data){
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
            arr[rear] = data;
        }
        return arr[rear];
    }
    public int dequeue(){
        int element = 0;
        if(front==-1){
            System.out.println("Queue is Under flow");
        }
        else{
            element = arr[front];
            if(front==rear){
                front = -1;
                rear = -1;
                return element;
            }
            else {
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
    /*int k;
    int arr2[];
    void reverseTheQueue(){
        System.out.println("Enter the size : ");
        int s = sc.nextInt();
        Queue2 q2 = new Queue2(s);
        for(int i = 0;i<q2.size;i++){
            System.out.println("Enter element : ");
            int element = sc.nextInt();
            q2.enqueue(element);
        }
        System.out.println("=============================");
        q2.display();
        System.out.println("=============================\n");
        System.out.println("Enter index that for reverse the element from front to that index : ");
        int k = sc.nextInt();
        arr2 = new int[k];
        for(int i = front;i<k;i++){
            arr2[i] = q2.dequeue();
        }
        /*System.out.print("(");
        for(int i = 0;i<k;i++){
            System.out.print(arr2[i]+",");
        }
        System.out.print(")\n");
        for(int i = front;i<arr2.length/2;i++){
            int temp = arr2[i];
            arr2[i] = arr2[arr2.length-i-1];
            arr2[arr2.length-i-1] = temp;
        }
        /*System.out.print("(");
        for(int i = 0;i<k;i++){
            System.out.print(arr2[i]+",");
        }
        System.out.print(")\n");
        for(int i = front;i<k;i++){
            q2.enqueue(arr2[i]);
        }
        System.out.println("=============================");
        q2.display();
        System.out.println("=============================\n");
    }*/
    public void kReverse(int k){
        if(k>0){
            int element = dequeue();
            System.out.println(element + " deleted successfully.");
            kReverse(k-1);
            enqueue(element);
        }
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
}
public class DS_QB_43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size for queue : ");
        int size = sc.nextInt();
        Queue2 q2 = new Queue2(size);
        for(int i = 0;i<size;i++){
            System.out.println("Enter element : ");
            int elememt = sc.nextInt();
            q2.enqueue(elememt);
        }
        System.out.println("\n-------------*=*=*=*=*=*=*=*=*--------------\n");
        q2.display();
        System.out.println("\n-------------*=*=*=*=*=*=*=*=*--------------\n");
        System.out.println("Enter k for reverse the element : ");
        int k = sc.nextInt();
        if(k<=size){
            q2.kReverse(k);
            for(int i = 0;i<size-k;i++){
                int element = q2.dequeue();
                q2.enqueue(element);
            }
            System.out.println("\n-------------*=*=*=*=*=*=*=*=*--------------\n");
            q2.display();
            System.out.println("\n-------------*=*=*=*=*=*=*=*=*--------------\n");

        }
        else{
            System.out.println("Invalid input.");
        }
    }
}
