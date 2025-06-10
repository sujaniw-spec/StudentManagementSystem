package coding;

public class LengthOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String input = "java";
      
      char [] charArray = input.toCharArray();
      int count=0;
      for(char c: charArray) {
    	  count++;
      }
      System.out.println(count);
	}

}
