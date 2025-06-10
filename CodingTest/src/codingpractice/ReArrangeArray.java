package codingpractice;

import java.util.Arrays;

public class ReArrangeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2, 0, 4, 0, 3, 0, 5, 0};
		
		int [] result = new int[nums.length];
		        int zeroIndex =0;
				int evenIndex =0;
				int oddIndex =nums.length;
				
				//first pass - zeros at the begining
				for(int num : nums) {
					if(num ==0) {
						result[zeroIndex++] =0;						
					}
				}
				
				//second pass: Place even and odd numbers
				evenIndex = zeroIndex;
				for(int num : nums) {
					if(num != 0) {
						if(num % 2 == 0) {
							result[evenIndex++] =num;						
						}
						else {
							result[--oddIndex] =num;	
						}
					}
				}
				System.out.println(Arrays.toString(result));
		
	}

}
