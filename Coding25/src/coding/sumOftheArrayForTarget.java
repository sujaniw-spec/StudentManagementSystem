package coding;

import java.util.Arrays;
import java.util.HashMap;

public class sumOftheArrayForTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums [] = {2,11,5,4,6};
		int target = 9;
		int [] arr = {};
		HashMap <Integer, Integer> map= new HashMap<>();
		
		for(int i=0; i<nums.length; i++ ) {
			int extra = target - nums[i];
			
			if(map.containsKey(extra)) {
				arr =  new int [] {map.get(extra), i};
			}
			
			map.put(nums[i], i);
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
