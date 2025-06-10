package newcoding;

public class NumberofOccurenceOfChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countOccurence("ddffeee bbsss", 's');
		
	}
	
	static void countOccurence(String sentence, char value) {
		
		//asserf s
		int count=0;
		for(int i=0; i<sentence.length(); i++) {
			if(sentence.charAt(i) == value) {
				count++;
			}
		}
		System.out.println(value +" "+count);
	}

}
