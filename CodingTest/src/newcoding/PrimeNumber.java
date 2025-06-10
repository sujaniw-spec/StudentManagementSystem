package newcoding;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number =56;
		boolean flag=false;
		for(int i=2; i<=Math.sqrt(number); i++) {
			if(number % i ==0) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			System.out.println("Is prime"+number);
		}
	}

}
