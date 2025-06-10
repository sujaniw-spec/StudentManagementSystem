package codingpracticenew;

public class RemoveConsecutiveDuplicates1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 boolean hasDuplicates = false;
	        StringBuilder result = new StringBuilder();
	        String s = "aabbbcabcbb";
	        int i = 0;
	        while (i < s.length()) {
	            int j;
	            // Use for loop instead of while
	            for (j = i; j + 1 < s.length(); ) {
	            	if( s.charAt(j) == s.charAt(j + 1)){
	            		//hasDuplicates=true;
	            		j++;
	            	}else {break;}
	            	
	            }

	            // If no duplicate sequence, add the character
	            if (i == j) {
	                result.append(s.charAt(i));
	            }

	            i = j + 1;
	        }
	        System.out.println(result.toString());
	}

}
