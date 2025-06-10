package codingpracticenew;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Sujani";
		String reverse="";
		char arr[] = str.toCharArray();
		
		for(int i= arr.length-1; i>=0; i--) {
			
			reverse+=arr[i];
		}
		System.out.println(reverse);
	}

}
