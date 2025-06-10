package codingpracticenew;

public class CharCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "sujanii";
		char ch='i';
		int count =0;
		
		for(char c: str.toCharArray() ) {
			if(c == ch)
				count++;
		}
		str.chars().filter(c -> ch==c).count();
		System.out.println(count);
		long lCount =str.chars().filter(c ->c ==ch).count();
		System.out.println(lCount);
	}

}
