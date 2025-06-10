package coding;

public class IsWordLowerCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word ="Sujani";
		
		boolean b = word.chars().allMatch(c -> Character.isLowerCase(c));
		if(b)
			System.out.println(word +" is lowercase");
	}

}
