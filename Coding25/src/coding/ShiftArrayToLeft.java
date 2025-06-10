package coding;

import java.util.Arrays;

public class ShiftArrayToLeft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr [] = {1,2,3,4,5,6}; //output 2,3,4,5,6,1
       
       int temp=arr[0];
       
       for(int i=0; i<arr.length-1; i++) {
    	  arr[i] = arr[i+1];
    	  
       }
       arr[arr.length -1] = temp;
       Arrays.stream(arr).forEach(n -> System.out.print(n +" , "));
	}

}
