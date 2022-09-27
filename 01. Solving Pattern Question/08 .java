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
        while(i<=n){
            int j = 1 ;
            while(j<=i){
                System.out.print(i);
                j++;
            }
            i++;
            System.out.println();
        }
		
		// FOR LOOP
		System.out.println("Using For Loop");
        for(int m =1;m<=n;m++){
            for(int q = 1 ;q<=m;q++){
                System.out.print(m);
            }
            System.out.println();
        }
		
		
	}
}

// 1
// 2 2
// 3 3 3
// 4 4 4 4

