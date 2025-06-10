package coding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Joinexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String [] str = {"aa","bb","vvv"};
        String joinstring = String.join(",", str);
        System.out.println(joinstring);
        String.join("-", "java","is","cool");
        
       String str1 =  Arrays.stream(str).collect(Collectors.joining(" ,"));
       System.out.println(str1);
       
       List<String> list = Arrays.asList("QA", null, "Tester");
       
      String listString =  list.stream().map(s -> s==null? "null":s)
       .collect(Collectors.joining(","));
      System.out.println(listString);
      String strp = "  sss ccc   ".strip();
      System.out.println(strp);
      System.out.println(strp.contains("ss"));
      
      char [] chArr = strp.toCharArray();
    // String.join(" , ", Arrays.binarySearch(str, "vvv")) ;
      
      
      
      
    
      
	}

}
