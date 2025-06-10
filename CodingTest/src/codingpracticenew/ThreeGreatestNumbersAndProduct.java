package codingpracticenew;

import java.util.Arrays;

public class ThreeGreatestNumbersAndProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int [] iArray = {3,1,5,8,2,10,20};		
		//1,2,3,5,8,10,20
		Arrays.sort(iArray);
		//Arrays.stream(iArray).forEach(a -> System.out.print(a));
		int product=1;
		for(int i=iArray.length-1; i>=iArray.length-3; i--) {
			System.out.println(i + " "+ iArray[i]);
			product*=iArray[i];
		}
		System.out.println(product);*/
		
		int [] iArray = {3,1,5,8,2,10,20};	
		Arrays.sort(iArray);
		
		long maxProduct=1;
//		for(int i=iArray.length-1; i>=iArray.length-3; i--) {
//			maxProduct*=iArray[i];
//		}
		
		for (int i = iArray.length - 3; i < iArray.length; i++) {
		    maxProduct *= iArray[i];
		}
		System.out.println(maxProduct);
		
		long minProduct=1;
		for(int i=0; i<3; i++) {
			minProduct*=iArray[i];
		}
		System.out.println(minProduct);
		
	}
	
	

}
