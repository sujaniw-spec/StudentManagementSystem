package codingpractice;

public class PrintLetterNuOfTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//printPattern("a7b8c9");
		String word = "a7b8c9";
		
		for(int i=0; i<word.length(); i++) {
			char letteOrDigit = word.charAt(i);
			
			if(Character.isAlphabetic(letteOrDigit) && Character.isDigit(word.charAt(i+1))) {
				//int digit = word.charAt(i+1)  - '0';
				int digit = Character.getNumericValue( word.charAt(i+1));
				//System.out.print(digit);
				for(int j=0; j<digit; j++) {
					System.out.print(letteOrDigit);
				}
				System.out.println();
			}
		}
	}
	  public static void printPattern(String s) {
	        for (int i = 0; i < s.length(); i++) {
	            char ch = s.charAt(i);
	            if (Character.isLetter(ch) && i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
	                int count = s.charAt(i + 1) - '0'; // Convert char digit to int
	                for (int j = 0; j < count; j++) {
	                    System.out.print(ch);
	                }
	                System.out.println(); // Move to the next line
	            }
	        }
	    }
}
