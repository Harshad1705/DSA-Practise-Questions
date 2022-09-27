
// say digit

public class Rec_04 {


    static String[] arr = {  "zero" , "one" , "two" ,"three" , "four" , "five" , "six" , "seven" , "eight" , "nine"  };


    public static void sayDigit(int n){

        if(n < 10 ){
            System.out.print(arr[n] + "  ");
            return;
        }

        int num = n % 10;

        n = n / 10;

        sayDigit(n);

        System.out.print(arr[num] + "  ");

    }


    public static void main(String[] args) {
        

        sayDigit(476);

    }
    
}
