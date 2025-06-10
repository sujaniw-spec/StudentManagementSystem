package coding;

public class SecondLargetNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {3,4,8,1,10,5,80};
		
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MAX_VALUE;
		
		for(int num: arr) {
			
			if(num > largest) {
				secondLargest = largest;
				largest = num;
			}
			else if(num > secondLargest && num != largest) {
				secondLargest=num;
			}
		}
		System.out.println(secondLargest);
	}

}
