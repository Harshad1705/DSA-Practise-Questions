class Doubly_Linked_List {
    
    int size = 0;

    class Node {

        int data;
        Node prev;
        Node next;

        Node (int data){
            this.data = data ;
            this.next = null;
            this.prev = null;
            size++;
        }
    }

    Node head = null;

    // print
    public void print(){

        Node curNode = head ;

        while(curNode != null){
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.print("null");
        System.out.println();

    }

    // add - at first
    public void addFirst(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }

    // add - at Last
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
        newNode.prev = curNode;
        curNode.next = newNode;

    }

    // add - at any position
    public void insert(int data ,int pos){

        Node newNode = new Node(data);

        if(pos == 1){
            addFirst(data);
            return;
        }

        if(pos >= size){

            addLast(data);
            return;

        }
        int count = 1;

        Node curNode  = head ;

        while(count < pos - 1){
            curNode = curNode.next;
            count++;
        }

        newNode.next = curNode.next;
        newNode.prev = curNode.next.prev;
        curNode.next = newNode;

    }

    // remove - at first
    public void removeFirst(){

        if(head == null){
            System.out.println("NO element to remove...");
            return;
        }

        Node curNode = head.next;

        curNode.prev = head.prev;
        head = curNode;

    }

    // remove - at last
    public void removeLast(){

        if(head == null){
            System.out.println("NO element to remove....");
            return;
        }

        Node curNode = head;

        while(curNode.next != null){
            curNode = curNode.next;
        }

        curNode.prev.next = null;

        curNode.next = null;
        curNode.prev = null;

    }

    // remove 
    public void remove(int data){

        if(head.data == data){
            removeFirst();
            return;
        }

        Node curNode = head;

        while(curNode.data != data){
            curNode = curNode.next;
        }

        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;

        // curNode.prev = null;
        // curNode.next = null;

    }
    public static void main(String[] args) {

        Doubly_Linked_List list = new Doubly_Linked_List();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);

        list.print();

        list.addLast(5);
        list.print();

        list.insert(60, 1);
        // list.insert(35, 4);
        list.insert(3,7);
        list.print();

        System.out.println(list.size);

        list.removeFirst();
        list.print();

        list.removeLast();;
        list.print();

        list.remove(30);
        list.print();
    }
}

/*
void print();
void addFirst(int data);
void addLast(int data);
void insert(int data ,int pos);
void removeFirst();
void removeLast();
 */