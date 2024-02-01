/*
Write a java code to print all the even values of the double
ended queue.
 */
package Data_Structure;

import java.util.Scanner;

class MyDeQue{
    int arr[];
    Scanner sc = new Scanner(System.in);
    int size,front,rear;

    MyDeQue(){
        System.out.println("Enter Size : ");
        size = sc.nextInt();
        arr = new int[size];
        front=rear=-1;
    }
    public void enqueue(){
        if(rear>=size-1){
            System.out.println("Queue is overflow");
        }
        else{
            if(front==-1){
                front=0;
            }
            rear++;
            System.out.println("Enter element : ");
            arr[rear] = sc.nextInt();
        }
    }
    public void dequeue(){
        if(front==-1){
            System.out.println("Queue is empty");
        }
        else {
            if(front==rear){
                front=rear=-1;
            }
            front++;
            System.out.println("\nDeleted Element : "+arr[front]);
        }
    }
    public int countElement(){
        int count = 0;
        if(front==-1){
            return count;
        }
        else{
            for(int i = front;i!=rear;i=(i+1)%size){
                count++;
            }
            return (count+1);
        }
    }
    public void display_even(){
        if(front==-1){
            System.out.println("Queue is empty");
        }
        else{
            for(int i = front;i<=rear;i++){
                if(i%2==0) {
                    System.out.println("Element arr["+i+"] = "+arr[i]);
                }
            }
        }
    }
}
public class DS_QB_77 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyDeQue mdq = new MyDeQue();
        for(int i = 0;i<mdq.size;i++){
            mdq.enqueue();
        }
        System.out.println("count : "+mdq.countElement());
        mdq.display_even();
    }
}
