package coding;

import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number =50;
		BigInteger result = BigInteger.ONE;
		
		for(int i=1; i<=number; i++) {
			result =result.multiply(BigInteger.valueOf(i));
		}
		
		System.out.println(result);
		
		int num =5;
		int fact=1;
		for(int i=1; i<=num; i++) {
			fact*=i;
		}

		System.out.println(fact);
		
		
	}

}
