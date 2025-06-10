package codingpracticenew;

public class Pyramid2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1; i<=11; i++) {
			
			for(int j=i; j<=11; j++) {
				System.out.print(" ");
			}
			
			for(int k=1; k<=(i*2)-1; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
		
	}

}
