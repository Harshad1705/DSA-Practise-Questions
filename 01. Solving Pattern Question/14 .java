import java.util.*;
public class Main
{
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		int n = scn.nextInt();
		
		System.out.println();
		
		
		// WHILE LOOP 
		System.out.println("Using While Loop");
        int i = 1 ;
        char value = 65 ;
        while(i<=n){
            int j = 1 ;
            while(j<=n){
                System.out.print(value);
                j++;
                value++;
            }
            System.out.println();
            i++;
        }

		
		// FOR LOOP
		System.out.println("Using For Loop");
		value = 65;
        for(int row = 1;row<=n;row++){
            for(int col = 1 ;col<=n;col++,value++){
                System.out.print((char)(value));
            }
            System.out.println();
        }
        
		
		
	}
}

    
// A B C 
// D E F 
// G H I