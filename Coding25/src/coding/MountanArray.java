package coding;

public class MountanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {1,3,5,10,4,2,0}; //mountain array
		
		System.out.println(mountainArrayCheck(a));
	}

	private static boolean mountainArrayCheck(int[] a) {
		// TODO Auto-generated method stub
		//1. Length of the array must be greater than 2
		
		if(a.length < 3) {
			return false;
		}
				
		//2. Elements must be increasing order
		
		int i=0;
		
		while(i< a.length-1 && a[i] < a[i+1]) {
			i++;
		}
		
		//3. Elements must be decreasing order
		
		while(i< a.length-1 && a[i] > a[i+1]) {
			i++;
		}
		
		return i == a.length-1;
	
	}

}
