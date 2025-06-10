package newcoding;

import java.util.Scanner;

public class HackerRandForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        System.out.println("t"+t);
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            int total=a;
            for(int j=0; j<n; j++){
                
                total += b * Math.pow(2, j);
                System.out.print(total +" ");                
            }
            System.out.println();
            
        }
        in.close();
	}

}
