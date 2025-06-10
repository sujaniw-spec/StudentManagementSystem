package codingpracticenew;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		int arr [] = {20,1,3,8,4,10,9};
		int temp=0;
		int temp1=0;
		
		int arr1 [] = {20,1,3,8,4,10,9};
		
		for (int i = 0; i < arr1.length; i++) {
          for(int j=i+1; j<arr1.length; j++) {
        	  if(arr1[i] < arr1[j]) {
        		  temp1 = arr1[j];
        		  arr1[j] = arr1[i];
        		  arr1[i] = temp1;
        	  }
          }
        }
		
		for(int i: arr1) {
			System.out.println(i);
		}
		
	//	Arrays.stream(arr1).forEach(i -> System.out.print(i +" "));
		
		for(int i=0; i<arr.length; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
			
		}
		
//		Arrays.stream(arr).forEach(i -> System.out.print(i +" #"));
	    Arrays.sort(arr);
	    
	//	Arrays.stream(arr).forEach(a -> System.out.println(a));
	//	System.out.println(arr[arr.length-6]);
		 
		
		//20,10,9,8,4,3,1
		
		/*for(int i=0; i<arr.length; i++) {
			for(int j= i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[j];
					arr[j]= arr[i];
					arr[i]= temp;
					
				}
			}
		}
		
		Arrays.stream(arr).forEach(i -> System.out.print(i +" "));
		System.out.println(arr[arr.length-1]);*/
	}

}
