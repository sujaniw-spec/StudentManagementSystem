package codingpracticenew;

public class MultiplicationWithoutMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Multiplication(20,10));
	}
	
	static int Multiplication(int num, int multiply) {
		
		int i=1;
		int sum = 0;
		while(i<=multiply) {
			sum +=num;
		i++;}
		return sum;
	}

}
