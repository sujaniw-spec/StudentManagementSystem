package coding;

import java.util.Arrays;

public class OnlyLettersReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "1ab2";
		char [] charArray = str.toCharArray();
		int left =0;
		int right=str.length()-1;
		
		while(left < right) {
			if(!Character.isLetter(charArray[left])) {
				left++;
			}
			else if(!Character.isLetter(charArray[right])) {
				right--;
			}
			else {
				char temp;
				temp = charArray[left];
				charArray[left] = charArray[right];
				charArray[right] = temp;
				left++;
				right--;
			}
				
		}
		System.out.print(Arrays.toString(charArray));
	}

}
