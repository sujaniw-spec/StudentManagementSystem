package coding;

public class ReverseOnlyVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello";
		String vowelString = "aeiouAEIOU";
		int left =0;
		int right= str.length()-1;
		char [] charArray = str.toCharArray();
		
		while(left<right) {
			
			if(vowelString.indexOf(charArray[left]) == -1) {
				left++;
			}
			else if(vowelString.indexOf(charArray[right]) == -1) {
				right++;
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
		
		System.out.println(new String(charArray));
		
	}

}
