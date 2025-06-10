package coding;

public class PanagramOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str ="the quick brown fox jumps over the lazy dog".toLowerCase();
		
		System.out.println(checkPangram(str));
		
	}

	private static boolean checkPangram(String str) {
		// TODO Auto-generated method stub
		
		if(str.length() < 26) {
			return false;
		}
		
		for(char i='a'; i<='z'; i++) {
			if(str.indexOf(i) == -1) {
				return false;
			}
		}
		
		return true;
	}

}
