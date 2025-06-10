package codingpractice;

public class MissingNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] numbers = {1,2,3,4,6,7};
		int total = 7;
		int expectedSum = total * ((total +1)/2);
		int num_sum = 0;
		
		for(int i : numbers) {
			num_sum+=i;
		}
		System.out.println("Missing "+(expectedSum -num_sum) );		
	}

}
