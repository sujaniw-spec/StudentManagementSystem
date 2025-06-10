package codingpracticenew;

public class MinMaxMultiDiamention {
/* 2 4 5
 * 3 4 7
 * 1 2 9
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
     int abc[][] = {{2,4,5},{3,4,7},{1,2,9}};
     
     int min = abc[0][0];
     
     for(int i=0; i<abc.length; i++) {
    	 for(int j=0; j<abc.length; j++) {
    		 if(abc[i][j] < min) {
    			 min = abc[i][j] ;
    		 }
    		 
    	 }
     }
     System.out.println(min);
     
	}

}
