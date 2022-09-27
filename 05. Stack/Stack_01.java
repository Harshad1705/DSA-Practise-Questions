

class Stack_01{

    // stack class
    class stack{
        int size ;
        int top ;
        int[] arr ;

        stack(int size){
            this.size = size;
            this.arr = new int[size];
            this.top = -1;
        }

        public void push(int data){
            if((size-top) > 1){
                top = top+1;
                arr[top] = data;
            }else{
                System.out.println("Stack Overflow");
            }
            
        }

        public void pop(){
            if(top>=0){
                top = top-1;
            }else{
                System.out.println("Stack Underflow");
            }
        }

        public int peek(){
            if(top >=0 && top < size)
                return arr[top];
            else{
                System.out.println("Stack is empty");
                return -1;
            }
        }

        public boolean isEmpty(){
            if(top == -1){
                return true;
            }else{
                return false;
            }
        }




    }
    

    public static void main(String[] args) {
        
        Stack_01 ss = new Stack_01();
        Stack_01.stack s = ss.new stack(5);

        s.push(25);
        s.push(5);
        s.push(15);
        s.push(45);
        s.push(5);
        s.push(5);

        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        
    

    }

}