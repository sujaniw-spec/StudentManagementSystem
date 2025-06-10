package newcoding;

import java.util.Scanner;

public class SubstringAndSorting {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
               
        //List<String> substrings = new ArrayList<>();
        smallest = s.substring(0,k);
        largest = s.substring(0,k);
        for(int i=0; i<=s.length()-k; i++){
            String sub = s.substring(i, i+k);
            
            if(sub.compareTo(smallest) < 0){
                smallest = sub;
            }
            if(sub.compareTo(largest) > 0){
                largest = sub;
            }
        }
       // collections.sort(substrings);
      //  smallest = substrings.get(0);
      //  largest = substrings.get(substrings.size() - 1);
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}