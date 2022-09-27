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
		int i = 1;
		while(i<=n){
		    int j = 1 ;
		    while(j<=n){
		        System.out.print(j);
		        j++;
		    }
		    i++;
		    System.out.println();
		}
		System.out.println();
		
		// FOR LOOP
		System.out.println("Using For Loop");
		
		for(int k=0;k<n;k++){
		    for(int j = 1;j<=n;j++){
		        System.out.print(j);
		    }
		    System.out.println();
		}
		
		
	}
}

// 1 2 3 4    1 2 3
// 1 2 3 4    1 2 3
// 1 2 3 4    1 2 3
// 1 2 3 4    

