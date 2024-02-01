package Data_Structure;
import java.util.Scanner;

class MergeQueue{
    int arr[];
    Scanner sc = new Scanner(System.in);
    int size,front,rear;

    MergeQueue(int size){
        this.size = size;
        arr = new int[size];
        front=rear=-1;
    }
    public void enqueue(int data){
        if(front==(rear+1)%size){
            System.out.println("Queue is Full");
        }
        else{
            if(front==-1){
                front=0;
            }
            if(rear>=size-1){
                rear = 0;
            }else {
                rear++;
            }
            arr[rear] = data;
        }
    }
    public int dequeue(){
        if(front==-1){
            System.out.println("Queue is empty");
        }
        else{
            int element = arr[front];
            if(front==rear){
                front=rear=-1;
                return element;
            }
            else{
                if(front==size-1){
                    front=0;
                }
                else {
                    front++;
                }
                return element;
            }
        }
        return 0;
    }
    public void display(){
        if(front==-1){
            System.out.println("Queue is empty");
        }
        else{
            if(front>rear) {
                System.out.print("\n{");
                for (int i = 0; i <= rear; i++) {
                    System.out.print(arr[i] + ",");
                }
                for (int i = front;i<=size-1;i++) {
                    System.out.print(arr[i] + ",");
                }
                System.out.print("}\n");
            }
            else{
                System.out.print("\n{");
                for(int i = front;i<=rear;i++){
                    System.out.print(arr[i] + ",");
                }
                System.out.println("}\n");
            }
        }
    }
    public MergeQueue merge(MergeQueue Q1,MergeQueue Q2){
        MergeQueue Q3 = new MergeQueue(Q1.size+ Q2.size);
        for(int i = Q1.front;i!=Q1.rear;i++){
            Q3.enqueue(Q1.dequeue());
        }
        Q3.enqueue(Q1.dequeue());
        for(int i = Q2.front;i!=Q2.rear;i++){
            Q3.enqueue(Q2.dequeue());
        }
        Q3.enqueue(Q2.dequeue());
        return Q3;
    }
}
public class MergeTwoQueues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size For Queue1 : ");
        int sizeQ1 = sc.nextInt();
        MergeQueue mq1 = new MergeQueue(sizeQ1);
        for(int i = 0;i<sizeQ1;i++){
            System.out.print("Enter element "+(i+1)+" : ");
            int x = sc.nextInt();
            mq1.enqueue(x);
        }
        System.out.println("==============================");
        mq1.display();
        System.out.println("==============================");

        System.out.println("Enter size For Queue2 : ");
        int sizeQ2 = sc.nextInt();
        MergeQueue mq2 = new MergeQueue(sizeQ2);
        for(int i = 0;i<sizeQ2;i++){
            System.out.print("Enter element "+(i+1)+" : ");
            int x = sc.nextInt();
            mq2.enqueue(x);
        }
        System.out.println("==============================");
        mq2.display();
        System.out.println("==============================");

        MergeQueue mq3 = new MergeQueue(sizeQ1+sizeQ2);
        mq3 = mq3.merge(mq1,mq2);
        System.out.println("Merged Queue\n==============================");
        mq3.display();
        System.out.println("==============================");
    }
}
