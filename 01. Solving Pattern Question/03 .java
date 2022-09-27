import java.util.*;
public class Main
{
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		int n = scn.nextInt();
		
		System.out.println();
		
		for(int i=1 , j = n;i<=n;i++){
		    int k = j ;
		    while(k>0){
		        System.out.print(i);
		        k--;
		    }
		    j--;
		    System.out.println();
		}
		
	}
}

// 1 1 1 1    1 1 1
// 2 2 2      2 2
// 3 3        3 
// 4 