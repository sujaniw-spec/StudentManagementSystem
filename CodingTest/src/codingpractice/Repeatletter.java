package codingpractice;

public class Repeatletter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PrintLetters("a7b8c9");
		PrintLetters1("a7b8c9");
	}
	
	static void PrintLetters(String str) {
		//a7b8c9
		
		int digit=0;
		for(int i=0; i<str.length(); i++) {
			char letter = str.charAt(i);
			if(Character.isAlphabetic(letter) && Character.isDigit(str.charAt(i +1))) {
				digit = Character.getNumericValue(str.charAt(i +1));
				
				for(int j=0; j< digit; j++) {
					System.out.print(letter);
				}
				System.out.println();
			}
		}
			
	}
	
	static void PrintLetters1(String str) {
		//a7b8c9
		int iRepeat = 0;
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(Character.isAlphabetic(str.charAt(i)) && Character.isDigit(str.charAt(i +1))) {
				iRepeat = Character.getNumericValue(str.charAt(i +1));
				
				while(count < iRepeat) {
					System.out.print(str.charAt(i));
					count++;
				}
				count=0;
				iRepeat=0;
				System.out.println();
			}
		}
	}

}


