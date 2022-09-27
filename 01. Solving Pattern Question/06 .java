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
        int j = 1 ;
        int k = 1;
        while(k<=n){
            int m = 1 ;
            while(m<=n){
                System.out.print(j);
                j++;
                m++;
            }
            k++;
            System.out.println();
        }
		
		// FOR LOOP
		System.out.println("Using For Loop");
		
		int z = 1;
		for(int a = 1;a<=n;a++){
		    for(int b = 1;b<=n;b++,z++){
		        System.out.print(z);
		    }
		    System.out.println();
		}
		
		
	}
}

// 1 2 3 4        1 2 3
// 5 6 7 8        4 5 6
// 9 10 11 12     7 8 9
// 12 13 14 15    10 11 12

