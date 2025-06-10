package codingpracticenew;

import java.util.ArrayList;

class UniqueNumInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int [] arr = {4,5,6,5,6,1,4,1,5,11};
		
		ArrayList <Integer>list = new ArrayList<>();
		int k=0;
		
		for(int i=0; i<arr.length; i++) {
			k=0;
			if(!list.contains(arr[i])) {
				list.add(arr[i]);
				k++;
				
				for(int j=i+1; j<arr.length; j++) {
					if(arr[i] == arr[j]) {
						k++;
					}
				}
				System.out.println(arr[i] + " -> "+k);
			}
			
		}
		
	}

}
