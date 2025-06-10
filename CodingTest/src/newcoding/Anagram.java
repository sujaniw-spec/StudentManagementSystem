package newcoding;


import java.util.Scanner;

public class Anagram {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        a = a.toLowerCase();
        b = b.toLowerCase();
        boolean isAnagram = false;
        if(a.length() != b.length()){
            return isAnagram;
        }
      //  char [] arrayA = a.toCharArray();
      //  char [] arrayB = b.toCharArray();
        
      //  Arrays.sort(arrayA);
     //   Arrays.sort(arrayB);
     
        int[] freqA = new int[26]; 
        int[] freqB = new int[26];
        
        
         for (int i = 0; i < a.length(); i++) {
            freqA[a.charAt(i) - 'a']++; 
            freqB[b.charAt(i) - 'a']++; 
        }

        // Compare the frequency arrays
        for (int i = 0; i < 26; i++) {
            if (freqA[i] != freqB[i]) {
                return false; // If any character frequency is different, return false
            }
        }

        return true;
       
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
