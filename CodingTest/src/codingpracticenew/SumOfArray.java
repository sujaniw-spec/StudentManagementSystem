package codingpracticenew;

public class SumOfArray {

	public static void main (String args[]) {
	int [] arr = {5,3,8,10};
	
	int sum =0;
	
	for(int i: arr) {
		sum+=i;
	}
	
	System.out.println(sum);
	}
}
