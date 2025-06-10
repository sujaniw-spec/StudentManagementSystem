package newcoding;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class biGIntegerMultiAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        String strNum = in.nextLine();
        String operator = in.nextLine();
        BigInteger num = new BigInteger(strNum);
        BigInteger multi = new BigInteger(operator);
        
        BigInteger add = num.add(multi);
        BigInteger product = num.multiply(multi);
        System.out.println(add);
        System.out.println(product);
        in.close();
	}

}
