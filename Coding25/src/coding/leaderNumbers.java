package coding;

import java.util.ArrayList;

public class leaderNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {16,17,4,3,5,2};
		
		int rigthMax = a[a.length-1];
		System.out.println(rigthMax);
		
		for(int i = a.length-2; i>=0; i--) {
			
			if(a[i] > rigthMax) {
				rigthMax = a[i];
				System.out.println(rigthMax);
			}
		}
		
		
	}

}
