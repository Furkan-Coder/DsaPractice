package lnkedlist;

public class MergeTwoSortedList {
    static class Node{
        Node next;
        int val;

        Node(int val){
            this.next=null;
            this.val=val;
        }
    }
    public  static Node mergeTwoSortedList(Node l1,Node l2){
        Node dummy=new Node(0);
        Node tail=dummy;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null){
            tail.next=l1;
        }
        if(l2 != null){
            tail.next=l2;
        }
        return dummy.next;
    }
    public  static void printList(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.println(curr.val);
            curr=curr.next;
        }
    }

    public static void main(String[] args) {
        Node l1=new Node(1);
        l1.next=new Node(3);
        l1.next.next=new Node(5);

        Node l2=new Node(6);
        l2.next=new Node(7);
        l2.next.next=new Node(8);

        Node merged=mergeTwoSortedList(l1,l2);
        printList(merged);

    }
}
