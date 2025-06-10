package newcoding;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FinPrimeByBigInteger {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        BigInteger number = new BigInteger(n);
        if(number.isProbablePrime(1))
            System.out.println("prime");
        else    
            System.out.println("not prime");
        bufferedReader.close();
	}

}
