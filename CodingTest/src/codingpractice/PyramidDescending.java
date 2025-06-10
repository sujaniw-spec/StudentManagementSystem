package codingpractice;

public class PyramidDescending {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=1;
        for(int i=1; i<=4; i++) {
        	
        	for(int j=1; j<=i; j++) {
        		System.out.print(k+" ");
        		k++;
        	}
        	System.out.println();
        }
        
for(int i=1; i<=4; i++) {
        	
        	for(int j=1; j<=i; j++) {
        		System.out.print(j+" ");
        		
        	}
        	System.out.println();
        }
	


int m=3;
	for(int i=1; i<=4; i++) {
    	
    	for(int j=1; j<=i; j++) {
    		System.out.print(m+" ");
    		m+=3;
    		
    	}
    	System.out.println();
    }
}	

}
