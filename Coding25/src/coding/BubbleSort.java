package coding;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		 
		 for(int i =0; i< arr.length; i++) {
			 int temp =0;
			 for(int j= i+1; j<arr.length; j++) {
				 if(arr[i] > arr[j]) {
					 temp = arr[i];
					 arr[i] = arr[j];
					 arr[j] = temp;
				 }
			 }
		 }
		 
		 Arrays.stream(arr).forEach(n -> System.out.print(n +" "));
		 
		 int arr1[] = { 64, 34, 25, 12, 22, 11, 90 };
		 
		 int temp =0;
		 for(int i=0; i< arr1.length; i++) {
			 for(int j=i+1; j<arr1.length; j++) {
				 
				 if(arr1[i] < arr1[j]) {
					temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;					 
				 }
			 }
		 }
		 System.out.println();
		 Arrays.stream(arr1).forEach(n -> System.out.print(n +" "));
	}

}
