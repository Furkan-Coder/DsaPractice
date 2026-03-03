package lnkedlist;

public class ReverseList {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static Node reverseList(Node head){
        Node prev=null;
        Node curr=head;
        while(curr != null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static  void  print(Node head){
        Node curr=head;
        while (curr != null){
            System.out.println(curr.val);
            curr=curr.next;
        }
    }

    public static void main(String[] args) {
        Node head=new Node(10);
        head.next=new Node(15);
        head.next.next=new Node(20);
        System.out.println("before reversing");
        print(head);
        System.out.println("After reversing");
        head=  reverseList(head);
        print(head);
    }
}
