package files;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int slow =0;
		  int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
	      int val = 2;
		
		for(int fast =0; fast<nums.length; fast++) {
			if(nums[fast] != val) {
				nums[slow] = nums[fast];
				slow++;
			}
		}
		System.out.println("number of elements "+slow);
		for(int i=0; i<slow; i++) {
			System.out.print(nums[i]+ " ");
		}
		
		for(int odd: nums) {
			
			if(odd %2 != 0) {
				System.out.println(odd);
			}
		}
		
		int temp=0;
		for(int i=0; i<nums.length-1; i++) {
			for(int j=1; j<nums.length-1; j++) {
				if(nums[j] >nums[j+1] ) {
					temp = nums[j] ;
					 nums[j] = nums[j+1];
					 nums[j+1] = temp;
				}
			}
			
		}
for(int odd: nums) {
			
			
				System.out.print("Aee"+odd);
			
		}
		
	}

}
