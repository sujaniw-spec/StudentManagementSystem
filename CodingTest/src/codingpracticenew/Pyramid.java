package codingpracticenew;

public class Pyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1; i<=11; i++) {
			for(int j=i; j<=11; j++) {
				System.out.print(" ");
			}
			
			for(int k=1; k<=(2*i)-1; k++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		//System.out.println();
		for(int i=11; i>=1; i--) {
			for(int j=11; j >=1; j--) {
		//	for(int j=11; j >1; j--) {
				System.out.print(" ");
			}
			
			for(int k=1; k<=(2*i)-1; k++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}

}
