package codingpracticenew;

public class CapitalLowercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str ="Hello World";
			
			System.out.println(str.intern()); //- if the string in the literal pool return the string. if not added to the string pool.
			
			char[] charArray = str.toCharArray();
			StringBuilder sb = new StringBuilder();
			for(char c: charArray) {
				if(Character.isUpperCase(c)) {
					sb.append(Character.toLowerCase(c));
				}
				else if(Character.isLowerCase(c)) {
					sb.append(Character.toUpperCase(c));
				}
				else {
					sb.append(c);
				}			
			}
			
			System.out.println(sb.toString());
			
			
			
	}

}
