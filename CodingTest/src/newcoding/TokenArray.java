package newcoding;


import java.io.*;
import java.util.*;

public class TokenArray {

    public static void main(String[] args) {
    	 Scanner scan = new Scanner(System.in);
         String s = scan.nextLine().trim();
         // Write your code here.
         if (s.length() == 0){
             System.out.println(s.length());
         }
         else{
             String [] tokenArray = s.split("[^a-zA-Z]+");
             System.out.println(tokenArray.length);
             for(String word : tokenArray){        
                 System.out.println(word);
             }
         }
        scan.close();
    }
}


