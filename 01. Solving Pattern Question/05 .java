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
		    int j = n ;
		    while(j>0){
		        System.out.print(j);
		        j--;
		    }
		    i++;
		    System.out.println();
		}
		System.out.println();
		
		// FOR LOOP
		System.out.println("Using For Loop");
		
		for(int k=0;k<n;k++){
		    for(int j = n;j>0;j--){
		        System.out.print(j);
		    }
		    System.out.println();
		}
		
		
	}
}

// 4 3 2 1       3 2 1   
// 4 3 2 1       3 2 1   
// 4 3 2 1       3 2 1   
// 4 3 2 1        

