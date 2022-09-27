class Circular_Linked_List {
    
    int size = 0 ;

    class Node {

        int data;
        Node next ;

        Node(int data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    Node head = null;

    // print
    public void print(){

        if(head == null){
            System.out.println("List is empty...");
            return;
        }

        Node curNode = head.next;
        
        do{
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }while(curNode != head);

        System.out.print("null");
        System.out.println();


    }

    
    // insert 
    public void insert(int data , int value){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            newNode.next = newNode ;
            return;
        }

        Node curNode = head.next;

        while(curNode.data != value ){
            curNode = curNode.next ;
        }

        newNode.next = curNode.next ;
        curNode.next =  newNode;
    }

    // delete
    public void delete(int value){

        if(head == null){
            System.out.println("List is empty...");
            return;
        }


        Node prev = head;
        Node curr = prev.next;


        if(prev == curr){    // only 1 element present
            head = null;
            return;
        }

        if(head == curr){
            head = prev;
            return;
        }

        while(curr.data != value){
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next ;
        curr.next = null ;
        
    }

    public static void main(String[] args) {
        
        Circular_Linked_List list = new Circular_Linked_List();

     
        list.insert(10, 5);
        list.insert(20, 10);
        list.insert(30, 20);
        list.insert(40, 30);    
        list.print();

        list.delete(30);
        list.print();
        


    }
}

/*
void print();
void insert(int data , int value);
void delete(int value);
 */