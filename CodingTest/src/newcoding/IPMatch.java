package newcoding;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class IPMatch {

	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }

}

class MyRegex{
    
    // Regex pattern for a valid IP address
   String pattern = 
       "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" + // Match first three segments (0-255)
       "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";            // Match last segment (0-255)
}
