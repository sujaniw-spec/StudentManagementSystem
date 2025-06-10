package codingpracticenew;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CompareTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int [] arr2 = {7,5,3,11,8};
         int [] arr1 = {7,5,3,11,9,10,1};
         ArrayList <Integer> list = new ArrayList<>();
         
       /*  int minSize = Math.min(arr2.length, arr1.length);
         
         for(int i=0; i<minSize; i++) {
        	 if(arr1[i] == arr2[i]) {
        		 list.add(arr1[i]);
        	 }
         }
         
        Object [] obArray =  list.toArray();
        Arrays.stream(obArray).forEach(i -> System.out.println(i));
        
       // Arrays.stream(obArray).forEach(n -> System.out.println(n));
        for(Object o: obArray) {
      //  	System.out.print(o);
        }*/
         
        int minLength = Math.min(arr2.length, arr1.length);
        
        for(int i=0; i<minLength; i++) {
        	if(arr2[i] == arr1[i]) {
        		list.add(arr2[i]);
        	}
        }
        
       Object [] objArray= list.toArray();
       
       Arrays.stream(objArray).forEach(i -> System.out.print(i + " "));
	}

}
