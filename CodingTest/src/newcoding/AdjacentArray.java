package newcoding;

public class AdjacentArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Max difference between any adjacent index in array
		
		int[] a = {1,4,8,35,17};
		int max=0;
		
		for(int i=0; i<a.length-1; i++) {
			if((a[i+1] - a[i]) > max)
					max = a[i+1] - a[i];
		}
		
		System.out.println(max);
		

	}

}
