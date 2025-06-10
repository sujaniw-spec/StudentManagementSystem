package codingpracticenew;

public class NumberToPrintChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "a7b8c9";
		
		for(int i=0; i<s.length()-1; i++) {
			int digit = 0;
			if(Character.isAlphabetic(s.charAt(i)) && Character.isDigit(s.charAt(i+1))) {				
				digit= Character.getNumericValue(s.charAt(i+1));
				for(int j=0; j<digit; j++) {
					System.out.print(s.charAt(i));
				}
				
				System.out.println();
			}
		}
	}

}
