package codingpracticenew;

import java.util.Arrays;

public class ReverseWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
      
      System.out.println("Original: ");
      Arrays.stream(days).forEach(day -> System.out.print(day + " "));
      
//      for(String day: days) {
//    	  System.out.print(day);
//      }
      
      System.out.println("\n\nReversed: ");
      for(int i=days.length-1; i>=0; i--) {
    	  System.out.print(days[i] +" ");
      }
	}

}
