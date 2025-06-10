package coding;

public class MoveZerosToLeft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr [] = {0,1,0,2,3,0,0,1,0};
       
       int putNoZeroValuesHere = 0;
       int temp;
       
       for(int current=0; current<arr.length-1; current++) {
    	   
    	   if(arr[current] != 0) {
    		   temp = arr[putNoZeroValuesHere];
    		   arr[putNoZeroValuesHere] = arr[current];
    		   arr[current] = temp;
    		   putNoZeroValuesHere++;
    	   }	  
       }
       for(int no: arr) {
		   System.out.print(no +" ");
	   }
	}

}
