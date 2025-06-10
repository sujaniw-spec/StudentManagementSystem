package newcoding;

public class SwapwithoutUsingTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=4;
		int b=5;
		
		//basket A Apple
		//basket B orange
		//basket c orange
		
		int temp=0;
		temp = a;
		a = b;
		b = temp;
		
		a = a+b; //a=9
	    b= a - b; //b=4
	    a = a - b; //a=5
	}

}
