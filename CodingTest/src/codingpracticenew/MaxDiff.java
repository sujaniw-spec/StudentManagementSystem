package codingpracticenew;

public class MaxDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr [] = {5,11,20,50,1,5,100,10,200,1};
        int min= Integer.MAX_VALUE;
       for(int i=0; i<arr.length-1; i++) {
    	   int diff = Math.abs(arr[i+1] - arr[i]);
    	   if(diff < min) {
    		   min = diff;
    	   }
       }
        System.out.println(min);
		
        
     //   int[] arr = {5, 11, 20, 50, 1, 5, 100, 10, 200, 1};

        int minDiff = Integer.MAX_VALUE;
        int num1 = 0, num2 = 0;
        int index1 = 0, index2 = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff < minDiff) {
                    minDiff = diff;
                    num1 = arr[i];
                    num2 = arr[j];
                    index1 = i;
                    index2 = j;
                }
            }
        }

        System.out.println("Minimum difference: " + minDiff);
        System.out.println("Between elements: " + num1 + " (index " + index1 + ") and " + num2 + " (index " + index2 + ")");
        
        int maxDiff = Integer.MIN_VALUE;
        int num3 = 0, num4 = 0;
        int index4 = -1, index5 = -1;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                    num3 = arr[i];
                    num4 = arr[j];
                    index4 = i;
                    index5 = j;
                }
            }
        }

        System.out.println("Maximum difference: " + maxDiff);
        System.out.println("Between elements: " + num3 + " (index " + index4 + ") and " + num4 + " (index " + index5 + ")");
    }
	

}
