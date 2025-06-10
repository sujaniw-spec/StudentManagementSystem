package coding;

public class MinNumOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 6, 1, 2, 3, 4};
		
		int min = arr[0];
		
//		for(int i=0; i<arr.length; i++) {
//			min = Math.min(min, arr[i]);
//		}
		
		for(int i: arr) {
			min = Math.min(min, i);
		}
		
		System.out.println(min);
		
		int min1 = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < min1) {
				min1 = arr[i];
			}
		}
		System.out.println(min1);

	}
	

}
