package coding;

public class MissingNumberOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] array = {1,2,3,4,5,6,7};
		int sum=0;
//		for(int i=0; i<=array.length-1; i++) {
//			sum+=array[i];
//		}
		
		for(int i: array) {
			sum+=i;
		}
		System.out.println(sum);
		int sum1=0;
		int [] givenaArray = {1,2,3,5,6,7};
		
		for(int i:givenaArray ) {
			sum1+=i;
		}
		System.out.println("missing number "+(sum - sum1));
	}

}
