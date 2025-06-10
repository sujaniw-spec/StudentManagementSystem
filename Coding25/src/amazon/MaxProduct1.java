package amazon;

import java.util.Arrays;

public class MaxProduct1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-10, -3, 5, 6, -20 };
		Arrays.sort(a);
		int n = a.length;
		
		if(n < 3) {			
			System.out.println(" No 3 numbers");			
		}
		
		int result1 = a[n -1] * a[n-2] * a[n-3];
		int result2 = a[0] * a[1]* a[n-1];
		
		System.out.println(Math.max(result1, result2));
		
	}

}
