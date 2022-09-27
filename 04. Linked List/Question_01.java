// reverse node in k groups

import java.util.Scanner;


public class Question_01 {

    public static void print(Singly_Linked_List.Node head){
        Singly_Linked_List.Node curNode = head;

        while(curNode != null){
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
    
    public static Singly_Linked_List.Node reverse_node_K_group(Singly_Linked_List.Node head, int n){

        // Time complexity = O(n)
        // Space complexity = O(n)

        // base case
        if(head == null){
            return null;
        }

        // reverse first k nodes
        Singly_Linked_List.Node prev = null;
        Singly_Linked_List.Node curNode = head;
        Singly_Linked_List.Node nextNode = null;
        int count = 0;

        while(curNode != null && count<n){
            nextNode = curNode.next;
            curNode.next = prev ;
            prev = curNode;
            curNode = nextNode;
            count++;
        }

        // aage recursion dekh lega
        if(nextNode != null){
            head.next = reverse_node_K_group(nextNode, n);
        }

        // return answer 
        return prev;
    
    }

    public static Singly_Linked_List.Node reverse_K_Node_using_Array(Singly_Linked_List.Node head, int n , int[] arr){

        if(head == null ){
            return null;
        }
        if(n==0 && head != null){
            return head;
        }

        Singly_Linked_List.Node prev = null;
        Singly_Linked_List.Node curNOde = head;
        Singly_Linked_List.Node nextNode = null;

        int size = arr.length;
        int count = arr[size-n];
        
        while(curNOde != null && count>0){
            nextNode = curNOde.next;
            curNOde.next = prev;
            prev = curNOde;
            curNOde = nextNode;
            count--;
        }

        if(nextNode != null){
            head.next = reverse_K_Node_using_Array(nextNode, n-1, arr);
        }

        return prev;
    }


    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            Singly_Linked_List list = new Singly_Linked_List();

            list.addFirst(60);
            list.addFirst(50);
            list.addFirst(40);
            list.addFirst(30);
            list.addFirst(20);
            list.addFirst(10);

            list.print();

            Singly_Linked_List.Node head = list.head;

            Singly_Linked_List.Node start = reverse_node_K_group(head,n);

            print(start);



            Singly_Linked_List list2 = new Singly_Linked_List();
            int[] arr = {2,3};
            list2.addFirst(90);
            list2.addFirst(80);
            list2.addFirst(70);
            list2.addFirst(60);
            list2.addFirst(50);
            list2.addFirst(40);
            list2.addFirst(30);
            list2.addFirst(20);
            list2.addFirst(10);

            list2.print();

            Singly_Linked_List.Node head2 = list2.head;

            Singly_Linked_List.Node start2 = reverse_K_Node_using_Array(head2,2,arr);

            print(start2);
            
        }
        
    }
}
