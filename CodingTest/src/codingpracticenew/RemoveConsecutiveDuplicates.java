package codingpracticenew;

public class RemoveConsecutiveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 //boolean hasDuplicates = false;
	       /* StringBuilder result = new StringBuilder();
	        String input = "aabbbcabcbb";
	        int i = 0;
	        while (i < input.length()) {
	            int j = i;
	            // Move j while the same character repeats
	            while (j + 1 < input.length() && input.charAt(j) == input.charAt(j + 1)) {
	                j++;
	               // hasDuplicates = true;
	            }
	            // If no duplicate sequence, add the character
	            if (i == j) {
	                result.append(input.charAt(i));
	            }
	            i = j + 1;
	        }
	        
	        System.out.println(result.toString());*/
		
		StringBuilder result = new StringBuilder();
		String input= "aabbbcabcbb";
		int i=0;
		
		while(i<input.length()) {
			int j= i;
			while(j+1<input.length() && input.charAt(j) == input.charAt(j+1)) {
				j++;
			}
			
			if(j == i)
				result.append(input.charAt(i));
			i = j+1;
			System.out.println("i "+i);
		}
		
		System.out.println(result.toString());
		
		
	}

}
