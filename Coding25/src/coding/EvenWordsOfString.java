package coding;

public class EvenWordsOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Sky is blue and vast";
		
		String [] strArray = input.split(" ");
		
		for(String str: strArray) {
			if(str.length() % 2 ==0) {
				System.out.println(str +" is even length");
			}
			else {
				System.out.println(str +" is odd length");
			}
		}
	}

}
