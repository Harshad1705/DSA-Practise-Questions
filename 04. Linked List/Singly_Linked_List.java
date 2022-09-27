
class Singly_Linked_List{

    int size = 0;

    // Node class
    class Node{
        
        int data;
        Node next;
    

        Node(int data){
            this.data = data ;
            this.next = null;
            size++;
        }
    }

    // Head pointer
    Node head = null;

    // print
    public void print(){

        if(head == null){
            System.out.println("No element present...");
            return;
        }

        Node curNode = head ;

        while(curNode != null){
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.print("Null");
        System.out.println();

    }

    // add - at first
    public void addFirst(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head ;
        head = newNode;

    }

    // add - at last
    public void addLast(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node curNode = head;

        while(curNode.next != null){
            curNode = curNode.next;
        }

        newNode.next = curNode.next;
        curNode.next = newNode;

    }

    // add - at any position
    public void insert(int data ,int pos){

        if(pos == 1){
            addFirst(data);
            return;
        }

        int count = 1 ;

        Node newNode = new Node(data);

        Node curNode = head;


        while(count<pos - 1 ){
            curNode = curNode.next;
            pos--;
        }
        
        newNode.next = curNode.next;
        curNode.next = newNode;

    }


    // remove - at First
    public void removeFirst(){
        size--;

        if(head == null){
            System.out.println("No element to remove ....");
            return;
        }
        head = head.next;
    }

    // remove - at last
    public void removeLast(){

        size--;

        Node curNode = head.next ;
        Node prevNode = head;

        while(curNode.next != null ){
            curNode = curNode.next;
            prevNode = prevNode.next;
        }

        prevNode.next = null;

    }

    // remove - by comparing data
    public void remove(int data ,String s){

        size--;

        if(s == "value"){
            if(head.data == data){
                head = head.next;
                return ;
            }
    
            Node curNode = head.next ;
            Node prevNode = head;
    
            while(curNode.next != null){
                if(curNode.data == data){
                    prevNode.next = curNode.next;
                    break;
                }
                curNode = curNode.next;
                prevNode = prevNode.next;
            }
        }else if(s == "index"){

            if(data == 1){
                head = head.next;
                return;
            }

            int count = 1; 
            Node curNode = head;

            while(count < data-1){
                curNode = curNode.next;
                count++;
            }

            curNode.next = curNode.next.next;

        }
    }

    // reverse a linked list
    public void reverse(){

        if(head == null || head.next == null){
            return;
        }

        Node prev = head ;
        Node curNode = head.next;

        while(curNode != null){
            Node next = curNode.next;

            curNode.next = prev;

            prev = curNode;
            curNode = next;
        }

        head.next = null;

        head = prev;

    }

    



    // find middle element
    public int middle(){

        if(head == null){
            System.out.println("No element present...");
            return 0;
        }
        if(head.next == null){
            return head.data;
        }

        Node turtle = head;
        Node rabbit = head;

        while(rabbit.next != null && rabbit.next.next != null){
            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }

        return turtle.data;

    }


    public static void main(String[] args) {
        
        Singly_Linked_List list = new Singly_Linked_List();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(10);
        list.addFirst(50);
        list.addFirst(70);
        list.addLast(80);           

        list.insert(100, 7);

        list.print();
        
        list.removeFirst();
        list.removeLast();
        list.print();

        list.remove(20,"value");
        list.remove(3,"index");
        list.print();

        System.out.println(list.size);



        list.reverse();
        list.print();

        System.out.println(list.middle());
    }

}

/*
void print();
void addFirst(int data);
void addLast(int data);
void insert(int data ,int pos);
void removeFirst();
void removeLast();
void remove(int data ,String s);
void reverse();
 */