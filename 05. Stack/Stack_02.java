// 2 stack in single array

public class Stack_02 {

    class TwoStack{
        int top1;
        int top2;
        int arr[];
        int size;

        TwoStack(int size){
            this.size = size;
            this.arr = new int[size];
            this.top1 = -1;
            this.top2 = size;
        }

        void push1(int data){
            if((top2 - top1 ) > 1){
                top1 = top1+1;
                arr[top1] = data;
            }else{
                System.out.println("Stack Overflow");
            }
        }

        void push2(int data){
            if((top2-top1) >1 ){
                top2 = top2 - 1;
                arr[top2] = data;
            }else{
                System.out.println("Stack Overflow");
            }
        }

        int pop1(){
            if(top1 == -1){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int top = arr[top1];
                top1 = top1 - 1;
                return top;
            }
        }

        int pop2(){
            if(top2 == size){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int top = arr[top2];
                top2 = top2 + 1;
                return top;
            }
        }
    }
    
}
