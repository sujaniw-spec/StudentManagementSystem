package codingpractice;

public class Fibanosnki {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=10;
		int a=0;
		int b=1;
		
		for(int i=0; i<n; i++) {
			
			System.out.print(a +" ");
			int next = a+b;
			a = b;
			b = next;
		}
	}

}
