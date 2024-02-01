/*
Linked list programs
and
it's operations and methods.
 */
package Data_Structure;

import java.util.Scanner;

class SinglyLL{
    int count;
    Scanner sc= new Scanner(System.in);
    class Node{
        int data;
        Node next;

        Node(){
            System.out.print("Enter data "+(count+1)+" : ");
            data = sc.nextInt();
            next = null;
            count++;
        }
        Node(int data){
            this.data = data;
            next = null;
            count++;
        }
    }
    Node head = null;
    /*1*/ public void insertAtHead(){
        Node p = new Node();
        if(head==null){
            head = p;
        }
        else{
            p.next = head;
            head = p;
        }
        System.out.println("\n"+p.data+" is Inserted successfully\n");
    }
    /*2*/public void insertAtlast(){
        Node p = new Node();
        if(head==null){
            head=p;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next = p;
        }
        System.out.println("\n"+p.data+" Inserted Successfully.\n");
    }
    /*3*/public void insertAtTail(int data){
        Node p = new Node(data);
        if(head==null){
            head=p;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next = p;
        }
        System.out.println("\n"+p.data+" Inserted Successfully.\n");
    }
    /*4*/public void deleteAtHead(){
        if(head==null){
            System.out.println("Link_list is empty.");
        }
        else{
            if(head.next==null){
                System.out.println(head.data+" Deleted successfully");
                head = null;
            }
            else{
                System.out.println(head.data+" Deleted Successfully.");
                head = head.next;

            }
        }
    }
    /*5*/public void deleteAtLast(){
        if(head==null){
            System.out.println("Link list is empty.");
        }
        else{
            Node temp = head;
            if(head.next == null){
                System.out.println(temp.data+" Deleted successfully.");
                head = null;
            }
            else{
                while(temp.next.next!=null){
                    temp = temp.next;
                }
                System.out.println(temp.next.data+" Deleted successfully.");
                temp.next = null;
            }
        }
    }
    /*6*/public void deleteAtPerticular(int value){
        Node temp ;
        int flag = 0;
        if(head==null){
            System.out.println("Linked list is empty.");
        }
        temp = head;
        while(temp!=null){
            if(temp.data==value){
                flag = 1;
                break;
            }
            temp = temp.next;
        }
        if(flag==0){
            System.out.println("Value doesn't exist.");
        }
        else{
            if(head.data==value){
                if(head.next==null){
                    head=null;
                }
                else{
                    head = head.next;
                }
            }
            else {
                temp = head;
                while (temp.next.data!=value){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
        }
    }
    /*7*/public void displayOddPosition(){
        if(head==null){
            System.out.println("Linked list is empty.");
        }
        else {
            System.out.println("===============================");
            for(Node temp = head;temp!=null;temp=temp.next){
                if((temp.data)%2!=0) {
                    System.out.print(temp.data + " --> ");
                }
            }
            System.out.println("\n===============================\n");
        }
    }
    void deleteduplicatevalue()
    {
        if(head==null)
        {
            System.out.println("Empty");
        }
        else
        {
            Node temp=head;
            while(temp!=null)
            {
                Node temp1=temp;
                while(temp1.next!=null)
                {
                    if(temp1.next.data==temp.data)
                    {
                        temp1.next=temp1.next.next;
                    }
                    else
                    {
                        temp1=temp1.next;
                    }
                }
                temp=temp.next;
            }
        }
    }
    /*8*/public void insertbeforeValue(int value) {
        Node p = new Node();
        Node temp = head;
        int flag = 0;
        while (temp != null) {
            if (temp.data == value) {
                flag = 1;
            }
            temp = temp.next;
        }
        if (flag == 0) {
            System.out.println("Value doesn't exist!");
        } else {
            if (head.data == value) {
                p.next = head;
                head = p;
            } else {
                temp = head;
                while (temp.next.data != value) {
                    temp = temp.next;
                }
                p.next = temp.next;
                temp.next = p;
            }
        }
    }
    /*9*/public void insertAfterValue(int key){
        System.out.println("Enter new data : ");
        int element = sc.nextInt();
        Node p = new Node(element);
        if(head==null){
            System.out.println("Linked list is empty.");
        }
        else{
            Node temp = head;
            while(temp.data!=key && temp.next!=null){
                temp = temp.next;
            }
            if(temp.data==key){
                p.next = temp.next;
                temp.next = p;
            }
            else{
                System.out.println("Value not found!");
            }
        }
    }
    /*10*/public void insertInSortedOrder() {
        Node p = new Node();
        Node temp = head;
        if (head == null) {
            head = p;
        } else if (head.data > p.data) {
            p.next = head;
            head = p;
        } else {
            while (temp.next != null && temp.next.data <= p.data) {
                temp = temp.next;
            }
            p.next = temp.next;
            temp.next = p;
        }
    }
    /*11*/public void sort(){
        if(head==null){
            System.out.println("Link list is empty.");
        }
        else{
            for(Node temp = head;temp!=null;temp = temp.next){
                for(Node temp1 = temp.next;temp1!=null;temp1 = temp1.next) {
                    if(temp1.data<temp.data) {
                        int flag = temp.data;
                        temp.data = temp1.data;
                        temp1.data = flag;
                    }
                }
            }
        }
    }
    /*12*/public void checkUniqueness(){
        if(head==null){
            System.out.println("Link list is empty.");
        }
        else{
            boolean b = false;
            for(Node temp = head;temp!=null;temp = temp.next){
                for(Node temp1 = temp.next;temp1!=null;temp1 = temp1.next) {
                    if(temp1.data==temp.data) {
                        b = true;
                        System.out.println(temp.data+" is repeated.");
                    }
                }
            }
            if(b == false){
                System.out.println("All element are unique");
            }
            else {
                System.out.println("All elements are not unique");
            }
        }
    }
    /*13*/SinglyLL mergeTwoLinklist(SinglyLL linklist1,SinglyLL linklist2){
        Node temp = linklist1.head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = linklist2.head;
        return linklist1;
    }
    /*14*/public void displayLL(){
        if(head==null){
            System.out.println("Linked list is empty.");
        }
        else {
            System.out.println("===============================");
            for(Node temp = head;temp!=null;temp=temp.next){
                    System.out.print(temp.data + " --> ");
            }
            System.out.println("\n===============================\n");
        }
    }
    /*15*/public void displayUsingRecursion(Node first){
        if(head==null){
            System.out.println("linked list is empty");
        }
        System.out.println("\n--------------*=*=*=*=*=*=*----------------\n");
        if(first!=null) {
            System.out.print(first.data + " --> ");
            displayUsingRecursion(first.next);
        }
        System.out.println("\n--------------*=*=*=*=*=*=*----------------\n");
    }
    /*16*/public void Sum(Node root){
        int sum = 0;
        if(head==null){
            System.out.println("Link_list is empty.");
        }
        else {
            while (root != null) {
                sum = sum + root.data;
                root = root.next;
            }
            System.out.println("Sum of elements : "+sum);
        }
    }
    /*17*/public void searchElement(int data){
        if(head==null){
            System.out.println("Linked_list is empty");
        }
        else{
            if(head.next==null){
                if(head.data==data) {
                    System.out.println("Data is founded --> "+head.data);
                }
                else{
                    System.out.println("Not found");
                }
            }
            else{
                int count=0;
                for(Node temp = head;temp!=null;temp=temp.next){
                    if(temp.data==data){
                        System.out.println("Data is founded : "+temp.data);
                        temp = null;
                        count++;
                        break;
                    }
                }
                if(count==0){
                    System.out.println(data+" is not found in link_list");
                }
            }
        }
    }
    void deleteEvenValues()
    {
        if(head==null)
        {
            System.out.println("Empty");
        }
        else
        {
            while(head!=null && head.data%2==0)
            {
                head=head.next;
            }
            Node temp=head;
            while(temp!=null && temp.next!=null)
            {
                if(temp.next.data%2==0)
                {
                    temp.next=temp.next.next;
                }
                else
                {
                    temp=temp.next;
                }
                temp=temp.next;
            }
        }
    }
    void deleteODDValues()
    {
        if(head==null)
        {
            System.out.println("Empty");
        }
        else
        {
            while(head!=null && head.data%2!=0)
            {
                head=head.next;
            }
            Node temp=head;
            while(temp!=null && temp.next!=null)
            {
                if(temp.next.data%2!=0)
                {
                    temp.next=temp.next.next;
                }
                else
                {
                    temp=temp.next;
                }
                temp=temp.next;
            }
        }
    }

    /*18*/public void cloneOfLinkedList(SinglyLL original){
        Node current = original.head;
        while(current!=null){
            insertAtTail(current.data);
            current = current.next;
        }
    }
    void linklistReverse(Node head)
    {
        if(head==null) {
            return;
        }
        linklistReverse(head.next);
        System.out.print(head.data+" --> ");
    }
    public void callOperation(){
        SinglyLL linkList = new SinglyLL();
        int size=0,limit = 0;
        boolean b = true;
        while(b){
            System.out.println("\nEnter \n===========================" +
                    "\n1 for insert at head" +
                    "\n2 for insert at last" +
                    "\n3 for delete at head" +
                    "\n4 for delete at last" +
                    "\n5 for delete particular element" +
                    "\n6 for calculate sum of element" +
                    "\n7 for display length of link list" +
                    "\n8 for search the particular element" +
                    "\n9 for Insert in sorted order" +
                    "\n10 for insert any before value of link list." +
                    "\n11 for insert any after value of link list." +
                    "\n12 for sort the link list." +
                    "\n13 for check uniqueness of element." +
                    "\n14 for merge two link list " +
                    "\n15 for make clone of original linked list " +
                    "\n16 for display" +
                    "\n17 for display odd position "+
                    "\n18 for display using recursion "+
                    "\n19 for exit.\n============================");
            int choice = sc.nextInt();
            switch(choice){
                case 1 :
                    System.out.println("Enter size for insert element : ");
                    size = sc.nextInt();
                    linkList.count=0;
                    for(int i = 0;i<size;i++){
                        linkList.insertAtHead();
                    }
                    break;
                case 2 :
                    System.out.println("Enter size for insert element : ");
                    size = sc.nextInt();
                    linkList.count=0;
                    for(int i = 0;i<size;i++){
                        linkList.insertAtlast();
                    }
                    break;
                case 3 :
                    System.out.println("Enter limit for delete the element : ");
                    limit = sc.nextInt();
                    for(int i = 0;i<limit;i++){
                        linkList.deleteAtHead();
                        linkList.count--;
                    }
                    break;
                case 4 :
                    System.out.println("Enter limit for delete the element : ");
                    limit = sc.nextInt();
                    for(int i = 0;i<limit;i++){
                        linkList.deleteAtLast();
                        linkList.count--;
                    }
                    break;
                case 5 :
                    System.out.println("Enter that element you want to remove from the link list.");
                    int data = sc.nextInt();
                    linkList.deleteAtPerticular(data);
                    linkList.count--;
                    break;
                case 6 :
                    System.out.println("========================");
                    linkList.Sum(linkList.head);
                    System.out.println("========================");
                    break;
                case 7 :
                    System.out.println("========================================");
                    System.out.println("Length of link list : "+linkList.count);
                    System.out.println("========================================");
                    break;
                case 8 :
                    System.out.println("Enter element : ");
                    int element = sc.nextInt();
                    linkList.searchElement(element);
                    break;
                case 9:
                    System.out.println("Enter size for insert element : ");
                    size = sc.nextInt();
                    linkList.count=0;
                    for(int i = 0;i<size;i++){
                        linkList.insertInSortedOrder();
                    }
                    break;
                case 10:
                    System.out.println("Enter element : ");
                    int value = sc.nextInt();
                    linkList.insertbeforeValue(value);
                    break;
                case 11:
                    System.out.println("Enter element : ");
                    int value1 = sc.nextInt();
                    linkList.insertAfterValue(value1);
                    break;
                case 12:
                    linkList.sort();
                    break;
                case 13:
                    linkList.checkUniqueness();
                    break;
                case 14:
                    SinglyLL linklist2 = new SinglyLL();
                    System.out.println("Enter size second link list : ");
                    size = sc.nextInt();
                    linklist2.count=0;
                    for(int i = 0;i<size;i++){
                        linklist2.insertAtlast();
                    }
                    linkList.mergeTwoLinklist(linkList,linklist2);
                    break;
                case 15:
                    SinglyLL duplicate = new SinglyLL();
                    duplicate.cloneOfLinkedList(linkList);
                    System.out.println("Clone of original linked list");
                    duplicate.displayLL();
                    break;
                case 16 :
                    linkList.displayLL();
                    break;
                case 17 :
                    linkList.displayOddPosition();
                    break;
                case 18 :
                    linkList.displayUsingRecursion(linkList.head);
                    break;
                case 19 :
                    b = false;
                    break;
                default:
                    System.out.println("Enter valid choice.");
                    linkList.callOperation();
                    break;
            }
            linkList.deleteduplicatevalue();
            linkList.displayLL();
        }
    }
}
public class LinkedList_SLL_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLL linkList = new SinglyLL();
        linkList.callOperation();

    }
}
