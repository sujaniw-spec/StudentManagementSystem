package codingpractice;

import java.util.ArrayList;

public class PrintUniqueNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {4,5,5,5,4,6,6,9,4};
		ArrayList <Integer> list = new ArrayList();
		int k=0;
		
		for(int i=0; i<a.length; i++) {
			k=0;
			if(!list.contains(a[i])) {
				list.add(a[i]);
				k++;
				for(int j=i+1; j<a.length; j++) {
					if(a[i] == a[j]) {
						k++;
					}
				}
				System.out.println(a[i] +"-> "+k);
			}
			
		}
	}

}
