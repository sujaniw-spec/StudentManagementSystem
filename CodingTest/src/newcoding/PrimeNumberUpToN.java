package newcoding;

public class PrimeNumberUpToN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number =100;
		
		for(int i=2; i<=number; i++) {
			
			if(isPrime(i)) {
				System.out.println(i +" is a prime");
			}
		}
		
	}
	
	static boolean isPrime(int n) {
		
		if(n<=0) {
			return false;
		}
		if(n==2 ) return true;
		
		for(int i=2; i<=n/2; i++) {
			if(n % i == 0) {
				return false;
			}				
		}
		return true;
	}

}
