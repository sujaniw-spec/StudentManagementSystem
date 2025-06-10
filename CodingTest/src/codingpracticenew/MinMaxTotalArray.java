package codingpracticenew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MinMaxTotalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ArrayList <Integer> list = new ArrayList<>();
       //1,2,3,4,5
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);
       list.add(5);
       
       Collections.sort(list);
       
       long minTotal =0;
       long maxTotal = 0;
       
       for(int i=0; i<list.size() -1; i++) {
    	   minTotal+=list.get(i);
    	   maxTotal+=list.get(list.size()-1-i);
       }
    //   System.out.print(minTotal + " "+maxTotal);
       int[] a = {2,6,1,7,5};
       //1 2 5 6 7
      Arrays.sort(a);
      long minTotal1 =0;
      long maxTotal1 = 0;
    //  Arrays.co
      for(int i=0; i<a.length-1; i++) {
    	  minTotal1+=a[i];
      }
      
      for(int i=1; i<a.length; i++) {
    	  maxTotal1+=a[i];
      }
      System.out.print(minTotal1 + " "+maxTotal1);
      
	}

}
