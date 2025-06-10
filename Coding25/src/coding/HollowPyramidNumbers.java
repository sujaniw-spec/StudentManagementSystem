package coding;

public class HollowPyramidNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1; i<=10; i++) {
			for(int j=1; j<=i; j++) {
				if(j==1 || j==i || i==10)
				System.out.print(j);
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
