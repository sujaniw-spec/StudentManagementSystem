package coding;

import java.util.HashSet;

public class LongestlengthSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbcbbabbcbb";
		HashSet<Character> seen = new HashSet<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If char is repeated, remove from left side
            while (seen.contains(c)) {
                seen.remove(s.charAt(left));
                left++;
            }

            // Add the new character to the set
            seen.add(c);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
            
          
        }
        seen.forEach(s1 -> System.out.print(s1 + " "));
	}

}
