import java.util.*;
public class Main
{
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		int n = scn.nextInt();
		
		System.out.println();
		
		int i = 1 ;
		while(i<=n){
		    int j = 1;
		    while(j<=n){
		        System.out.print(i);
		        j++;
		    }
		    i++;
		    System.out.println();
		}
		
	}
}

// 1 1 1 1    1 1 1
// 2 2 2 2    2 2 2
// 3 3 3 3    3 3 3
// 4 4 4 4