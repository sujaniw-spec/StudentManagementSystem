package coding;

public class MaximumProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int arr[] = { -2, 6, -3, -10, 0, 2 };
		  
		  int result = arr[0];
		  
		  for(int i=0; i<arr.length; i++) {
			  
			  int multiply = 1;
			  
			  for(int j =i; j<arr.length; j++) {
				  multiply*=arr[j];
				  
				  result = Math.max(result,  multiply);
			  }
		  }
		  System.out.println(result);
	}

}
