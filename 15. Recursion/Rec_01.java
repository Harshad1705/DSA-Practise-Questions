public class Rec_01{

    static int power_2(int n){

        if(n==1){
            return 2;
        }

        int smaller_problem =  power_2(n-1);
        int bigger_problem =  2 * smaller_problem;

        return bigger_problem;
    }


    public static void main(String[] args) {
        
        // value of 2 power n

        System.out.println(power_2(3));

    }
}