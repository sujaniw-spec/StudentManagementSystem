package newcoding;

import java.util.ArrayList;

public class PrintUniqueNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int a[] = {4,5,5,5,4,6,6,9,4,9,10};
      
      int k=0;
      
      ArrayList <Integer>list = new ArrayList();
      
      for(int i=0; i<a.length; i++) {
    	  k=0;
    	  if(!list.contains(a[i])) {
    		  list.add(a[i]);
    		  k++;
    	  
    	  
	    	  for(int j=i+1; j< a.length; j++) {
	    		  if(a[j] == a[i]) {
	    			  k++;
	    		  }
	    	  }
	    	  
	    	  System.out.println(a[i]+ "->"+k);
	    	  if(k==1) {
	    		  System.out.println(a[i] +" is unique");
	    	  }
    	  }
    	  
    	 
      }
	}

}
