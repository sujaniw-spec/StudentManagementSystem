package codingpracticenew;

public class LongestCommonPrefixVertical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          String commonPrefix="";
         
		String[] strs = {"flower", "flow", "flight"};
		if (strs == null || strs.length == 0)
			commonPrefix =  "";
		
		outer:
		for(int i=0; i<strs[0].length(); i++) {
			char currentChar = strs[0].charAt(i);
			
			for(int j=1; j<strs.length; j++) {
				if(i >=strs[j].length() || currentChar != strs[j].charAt(i)) {
					commonPrefix = strs[0].substring(0,i);
				    break outer;
				}
			}
		}
		
		if(commonPrefix.equals(""))
			commonPrefix= strs[0];
		
		System.out.println(commonPrefix);
		
	}
	
	

}
