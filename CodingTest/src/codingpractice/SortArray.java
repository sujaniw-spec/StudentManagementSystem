package codingpractice;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int a[]= {1000,34,55,77,88, 23,11};
     
     int temp=0;
     
     for(int i=0; i<a.length; i++) {
    	 
    	 for(int j=i+1; j<a.length; j++) {
    		 if(a[i] < a[j]) {
    			 temp = a[i];
    			 a[i]= a[j];
    			 a[j] = temp;
    		 }
    	 }
    	 
     }
     
    
     for(int m: a) {
    	 System.out.print(m +" ");
     }
     
     for(int i=0; i<a.length; i++) {
    	 for(int j=i+1; j<a.length; j++) {
    		 if(a[i] > a[j]) {
    			 temp = a[i];
    			 a[i] = a[j];
    			 a[j] = temp;
    		 }
    	 }
    	 
     }
     
     for(int m: a) {
    	 System.out.print(m +" ");
     }
    
	}

}
