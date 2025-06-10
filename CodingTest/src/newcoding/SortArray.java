package newcoding;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ar[]= {2,6,1,4,9,3};
		
		int temp= 0;
		
		for(int i=0; i<ar.length; i++) {
			
			for(int j=i+1; j<ar.length; j++) {
				if(ar[i] > ar[j]) {
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}			
		}
		
		for(int i=0; i<ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
	}

}
