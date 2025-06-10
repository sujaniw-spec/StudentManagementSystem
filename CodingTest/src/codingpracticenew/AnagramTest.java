package codingpracticenew;

import java.util.Arrays;

public class AnagramTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       char []str1="tomato".toCharArray();
       char []str2="matoto".toCharArray();
       
       Arrays.sort(str1);
       Arrays.sort(str2);
       System.out.println(Arrays.equals(str1, str2));
       
       
	}

}
