package coding;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String s ="Hello Hi World      ";
     
     String [] strArray = s.split(" ");
     
     System.out.println(strArray[strArray.length-1].length());
     
     String str = "Hello Hi World      ";//.trim();
     
     char[] charArray = str.toCharArray();
     int count=0;
     
     for(int i=charArray.length-1; i>0; i--) {
    	 if(charArray[i] !=' ') {
    		 count++;
    	 }
    	 else {
    		 if(count > 0) {
    		 break;
    		 }
    	 }    	 
     }
     System.out.println(count);
     
	}

}
