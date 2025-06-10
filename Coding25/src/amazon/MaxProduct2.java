package amazon;

import java.util.Arrays;

public class MaxProduct2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-10, -3, 5, 6, -20 };
		
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		for(int number : a) {
			
			if(number > max1) {
				max3 = max2;
				max2 = max1;
				max1 = number;
			}
			else if(number > max2) {
				max3 = max2;
				max2 = number;
			}
			else if(number > max3) {
				max3 = number;
			}
			if(number < min1) {
				min2 = min1;
				min1 = number;
				System.out.println("***");
			}
			else if(number < min2) {
				System.out.println("***");
				min2 = number;
			}
		}
		
		int result1 = max1 * max2 * max3;
		int result2 = min1 * min2 * max1;
		System.out.println(max1);
		System.out.println(max2);
		System.out.println(max3);
		System.out.println(min1);
		System.out.println(min2);
		System.out.println(Math.max(result1, result2));
		
	}

}
