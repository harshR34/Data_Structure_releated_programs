package Data_Structure;

import java.util.Scanner;

class CircularQueue{
    Scanner sc = new Scanner(System.in);
    int front,rear,size;
    char element[];
    String str;
    CircularQueue(){
        System.out.println("\nEnter String for find non duplicate character : ");
        str = sc.nextLine();
        size = str.length();
        element = new char[size];
        front = -1;
        rear = -1;
    }
    public void enqueue(){
        int i = -1;
        if(front==(rear+1)%size){
            System.out.println("Queue is full.");
        }
        else{
            if(front==-1){
                front = 0;
            }
            if(rear>=size-1){
                rear=0;
            }
            else {
                rear++;
            }
            i++;
            element[rear] = str.toLowerCase().charAt(i);
        }
    }
    public void display(){
        if(front==-1){
            System.out.println("Queue is empty.");
        }
        else{
            if(front>rear){
                System.out.print("\n{ ");
                for(int i = 0;i<=rear;i++){
                    System.out.print(element[i]+" ");
                }
                for(int i = front;i<=size-1;i++){
                    System.out.print(element[i]+" ");
                }
                System.out.println(" }\n");
            }
            else{
                System.out.print("\n{ ");
                for(int i = front;i<=rear;i++){
                    System.out.print(element[i]+" ");
                }
                System.out.println(" }\n");
            }
        }
    }
}
public class NonRepeatedCharacter {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        queue.display();
    }
}
/*
if(string.length()==0){
         System.out.println("EMPTY STRING");
       }

        for (char i : string.toCharArray()) {
            if (string.indexOf(i) == string.lastIndexOf(i)) {
                fnc = i;
                break;
            }
            else {
                index += 1;
            }
        }
        if (index == string.length()-1) {
            System.out.println("All characters are repeating");
        }
        else {
            System.out.println("First non-repeating character is " + fnc);
        }
 */