package codingpracticenew;

public class Fibanoscci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//0,1,1,2,3,5,8,13,21
		
		//0 1 1 2 3 5 8 13 21		
		
//		int a =0;
//		int b = 1;
//		int sum =0;
//		
//		for(int i=1; i<11; i++) {
//			sum = a+b;
//			System.out.println(sum);
//			a = b;
//			b = sum;			
//		}
		
		int a =0;
		int b=1;
		int sum=0;
		
		for(int i=1; i<11; i++) {
			sum = a+b;
			System.out.println(sum);
			a = b;
			b=sum;
		}
	}

}
