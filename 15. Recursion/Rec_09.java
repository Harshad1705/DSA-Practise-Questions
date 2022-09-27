
// check palindorme

public class Rec_09 {

    public static boolean palindorme(String s , int i){

        int j = s.length()-1-i;

        if(i>=j){
            return true;
        }

        if(s.charAt(i)==s.charAt(j)){
            i++;
            return palindorme(s, i);
        }else{
            return false;
        }


    }

    public static void main(String[] args) {
        
        String s = "abba";

        boolean ans = palindorme(s,0);

        System.out.println(ans);
    }
    
}
