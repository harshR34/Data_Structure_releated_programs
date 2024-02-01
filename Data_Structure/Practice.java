package Data_Structure;

class queue{
    int a[];
    int size;
    int front,rear;
    queue(int size){
        this.size = size;
        a = new int[size];
        front = rear = -1;
    }
    public  void enqueue(int data){
        if(rear>=size - 1){
            System.out.println("queue overflow.");
        }
        else{
            if(front==-1){
                front = 0;
            }
            rear = rear+1;
            a[rear] = data;
        }
    }
    public int dequeue(){
        if(front==-1){
            System.out.println("Under flow.");
            return -1;
        }
        else{
            int temp = a[front];
            if(front==rear){
                front=rear=-1;
            }
            else{
                front = front+1;
            }
            return temp;
        }
    }
    public void display(){
        if(front==-1){
            System.out.println("Under flow");
        }
        else{
            System.out.print("\n[");
            for(int i = front;i<=rear;i++){
                System.out.print(a[i]+",");
            }
            System.out.print("\n]");
        }
    }
    public void insertATFront(int data){
        if(front==(rear+1)%size){
            System.out.println("Overflow");
        }
        else{
            if(front==-1){
                front=rear=0;
            }
            else{
                if(front==0){
                    front = size-1;
                }
                else{
                    front = front - 1;
                }
                a[front] = data;
            }
        }
    }
}
public class Practice {
    public static void main(String[] args) {

    }
}
