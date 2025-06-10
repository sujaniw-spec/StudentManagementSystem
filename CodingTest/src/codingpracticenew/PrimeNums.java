package codingpracticenew;

public class PrimeNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String prime="";
        for(int i=2; i<=20; i++) {
        	System.out.println("** i"+i);
            //	prime = (isPrime(i))? ""+i+" Prime Number":"";
            	//System.out.println(prime);
        	if(isPrime(i)) {
        		System.out.println(" Prime Number"+i);
        	}
        }           
		
	}
	
  static boolean isPrime(int num) {
	  if (num <= 1) return false;

	  for(int i=2; i<=num/2; i++) {
		  
		  if(num %i ==0) {			  
			  return false;
		  }
	  }
	  return true;
  }

}
