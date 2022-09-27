
// find power (optimized)

public class Rec_10 {

    public static int power(int a , int b){

        // base case
        if(b==0){
            return 1;
        }
        if(b==1){
            return a;
        }

        // recursive call
        int ans = power(a, b/2);

        if(b%2 == 0){
            return ans * ans;
        }else{
            return a * ans * ans;
        }

    }

    public static void main(String[] args) {
        
        int ans = power(2 , 10);

        System.out.println(ans);
    }
    
}
