package coding;

public class NumberReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number =123;
		int reverseNumber=0;
		int lastDigit;
		
		while(number !=0) {
			lastDigit = number % 10;
			reverseNumber = (reverseNumber*10)+lastDigit;
			number = number/10;
		}
		
		System.out.println(reverseNumber);

	}

}
