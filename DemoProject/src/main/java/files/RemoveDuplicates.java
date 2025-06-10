package files;

public class RemoveDuplicates {
	
	public static void main(String args[]) {
	 int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
	 int k = 1;

	 
	 for(int i=1; i<nums.length; i++) {
		 if(nums[i] != nums[i-1]) {
			 nums[k] = nums[i];
			 k++;
		 }
	 }
	 
	 for(int j=0; j<k; j++) {
		 System.out.print(nums[j]);
	 }
	}
}
