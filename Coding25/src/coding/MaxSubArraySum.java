package coding;

public class MaxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {2, 3, -8, 7, -1, 2, 3};
		 
		 int maxSum = arr[0];
		 
		 for(int i=0; i< arr.length; i++) {
			 
			 int sum = 0;
			 
			 for(int j=i; j<arr.length; j++) {
				 sum+=arr[j];
				 maxSum = Math.max(maxSum, sum);
			 }	 			 		 
		 }
		 System.out.println(maxSum);
	}

}
