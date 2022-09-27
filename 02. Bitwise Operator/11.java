import java.util.Scanner;

class LeetCode_Problem_01{
        static int subtractProductAndSum(int n) {
        
            int sum = 0;
            int product = 1 ;

            int div = 10 ;
            while(n>0){
                int j = n%div;
                sum = sum + j;
                product = product*j;
                n = n - j;
                div = div*10;
            }
        
        return product - sum ;
    }
    public static void main(String[] args) {
        Scanner scn  =  new  Scanner(System.in);
        System.out.println("Enter a number : ");
        int n =  scn.nextInt();
        int ans = subtractProductAndSum(n);
        System.out.println(ans);
    }
}