package codingpractice;

import java.util.Arrays;

public class HighToLowZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int[] arr = {10, 1, 5, 3, 8, 2};
		 Arrays.sort(arr);
		 
		 int start =0;
		 int end = arr.length -1;
		 
		 while(start <=end) {
			 
			 if(start != end) {			
				 System.out.print(arr[end--] +" , "+arr[start++]+" , ");			
			 }
			 else {
				 System.out.print(arr[start++]);
			 }
		 }
		 
		 int[] arr1 = {10, 1, 5, 3, 8, 2};
		 
		 //bubble sort
		 int n = arr1.length;
		 boolean swapped;
		 
		 for(int i=0; i<n-1; i++) {
			 swapped=false;
			 
			 for(int j=0; j<n-1; j++) {
				 if(arr1[j] < arr1[j+1]) {
					 int temp = arr1[j];
					 arr1[j] = arr1[j+1];
					 arr1[j+1] = temp;
					 swapped=true;
				 }
			 }
			 if(!swapped) break;
		 }
		 for(int num: arr1) {
			 System.out.print(num +" ");
		 }
	}

}
