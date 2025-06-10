package codingpracticenew;

public class LongestCommonPrefix1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  String commonPrefix="";
	         
		 String[] strs = {"flower", "flow", "flight"};
		 
		 outer: 
		 for(int i=0; i<strs[0].length(); i++) {
			 char c = strs[0].charAt(i);
			 
			 for(int j=1; j<strs.length; j++) {
				 if(i >=strs[j].length() || c != strs[j].charAt(i) ) {
					 commonPrefix=  strs[0].substring(0,i);
					 break outer;
				 }
			 }
		 }
		 
		 if(commonPrefix == "") {
			 commonPrefix = strs[0];
		 }
		 System.out.println(commonPrefix);
	}

}
