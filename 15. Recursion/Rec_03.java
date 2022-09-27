
// print number forward and backward

public class Rec_03 {


    public static void print_backward(int n){
        
        if(n==0){
            return;
        }
        System.out.print(n+ "  ");

        print_backward(n-1);
    }

    public static void print_forward(int n){

        if(n==0){
            return;
        }

        print_forward(n-1);

        System.out.print(n+ "  ");
    }

    public static void main(String[] args) {
        

        int n = 5;

        System.out.println("Printing Backward");
        print_backward(n);

        System.out.println();

        System.out.println("Printing Forward");
        print_forward(n);

    }
    
}
