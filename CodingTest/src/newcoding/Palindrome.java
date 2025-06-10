package newcoding;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word = "madam";
		String reverse="";
		
		for(int i= word.length()-1; i>=0; i--) {
			reverse+=word.charAt(i);
		}
		
		System.out.println(reverse);
	}

}
