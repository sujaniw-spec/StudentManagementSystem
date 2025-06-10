package coding;

import java.util.Arrays;
import java.util.HashSet;

public class RepeatingNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {3,1,3,4,2};
		int repeat =0;
		for(int i=0; i<nums.length; i++) {
			int count =1;
			for(int j =i+1; j <nums.length; j++) {
				if(nums[i] == nums[j]) {
					count++;
				}
								
			}
			if(count > 1) {
				repeat =nums[i];
			}
			
		}
		System.out.println(repeat);
		
		HashSet <Integer> has = new HashSet<>();
		
		for(int num : nums) {
			if(has.contains(num)) {
				System.out.println(num);
				break;
			}
			has.add(num);
		}
		
		Arrays.sort(nums);
		
		for(int i=1; i<nums.length; i++) {
			
			if(nums[i] == nums[i - 1]) {
				System.out.println(nums[i]);
				break;
			}
			
		}
		
		
		
		
	}

}
