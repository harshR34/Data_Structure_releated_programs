package Data_Structure;

class SinglyLinkList{
    class Node{
        char data;
        Node next;
        Node(char data){
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    public void insertAtLast(char data){
        Node p = new Node(data);
        if(head==null){
            head = p;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = p;
        }
        System.out.println(p.data+" Inserted successfully.");
    }
    public void deleteAtFront(){
        if(head==null){
            System.out.println("Linked list is empty.");
        }
        else{
            Node temp = head;
            if(head.next == null){
                System.out.println(head.data+" is deleted successfully.");
                head = null;
            }
            else {
                while(temp.next.next!=null){
                    temp = temp.next;
                }
                System.out.println(temp.next.data+" deleted successfully.");
                temp.next = null;
            }
        }
    }
    public void display(){
        if(head==null){
            System.out.println("linked list is empty.");
        }
        else{
            System.out.println("--------------------------------------------\n\n");
            for(Node temp = head;temp!=null;temp = temp.next){
                System.out.print(temp.data+" --> ");
            }
            System.out.println("\n\n--------------------------------------------");
        }
    }
    public void checkNonDuplicateCharacter(String str){
        for(int i = 0;i<str.length();i++){
            insertAtLast(str.toLowerCase().charAt(i));
        }
        display();
        boolean marks = false;
        /*for(Node temp = head;temp!=null;temp=temp.next){
            for(Node temp1 = temp.next;temp1!=null;temp1=temp1.next){
                if(temp.data==temp1.data){
                    marks = true;
                    System.out.println(temp.data+" is repeated");
                }
            }
            if(!marks){
                System.out.println("Non repeated Character is :- "+temp.data);
            }
        }*/
        char ch = ' ';
        int index = -1;
        for(char i : str.toCharArray()){
            if(str.indexOf(i)==str.lastIndexOf(i)){
                index+=1;
            }
            else {
                ch = i;
                break;
            }
        }
        if(index==str.length()-1){
            System.out.println("All characters are repeated !");
        }
        else{
            System.out.println("First non repeated Character : "+ch);
        }
    }
}
public class ReturnNonDuplicateChar {
    public static void main(String[] args) {
        SinglyLinkList ll = new SinglyLinkList();
        ll.checkNonDuplicateCharacter("Harsh");
    }
}
