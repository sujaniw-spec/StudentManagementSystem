package codingpractice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MinMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		
	
		
		int sum1=0;
		int sum2=0;
		int sum3=0;
		int sum4=0;
		int sum5=0;
		List<Integer> sumArray = new ArrayList<Integer>();
		/*
	    for(int i=1; i<arr.size(); i++){
	        sum1+=arr.get(i);        
	    }
	    for(int i=0; i<arr.size(); i++){
	    	if(i!=1)
	         sum2+=arr.get(i);        
	    }
	    for(int i=0; i<arr.size(); i++){
	    	if(i!=2)
	         sum3+=arr.get(i);        
	    }
	    for(int i=0; i<arr.size(); i++){
	    	if(i!=3)
	         sum4+=arr.get(i);        
	    }
	    for(int i=0; i<arr.size(); i++){
	    	if(i!=4)
	         sum5+=arr.get(i);        
	    }
	    sumArray.add(sum1);
	    sumArray.add(sum2);
	    sumArray.add(sum3);
	    sumArray.add(sum4);
	    sumArray.add(sum5);
      
       //sumArray.stream().sorted().limit(1).forEach(num -> System.out.println(num));
       
       int min = Collections.min(sumArray);
       int max = Collections.max(sumArray);
       
       System.out.println(min +" "+max);*/
		
		Collections.sort(arr);
       long minSum=0;
       long maxSum = 0;
       System.out.println(arr.size());
       for(int i=0; i< arr.size()-1; i++) {
    	   System.out.println(i);
    	   minSum+=arr.get(i);
    	   maxSum+=arr.get(arr.size()-1-i);
       }
       System.out.println(minSum +" "+maxSum);
       
       int a=5;
       int b = 10;
       int temp=0;
       
       temp = a;
       a=b;
       b =temp;
       a = a+b;
       b = a - b;
       a = a- b;
       
       String str= "Sujani";
       String reverse="";
       
       for(int i=str.length()-1; i>=0; i--) {
    	   reverse+=str.charAt(i);
       }
       System.out.println(reverse);
       
       Map<Integer, String> map = new HashMap<>();
       map.put(3, "Cherry");
       map.put(1, "Apple");
       map.put(2, "Banana");

       map.forEach((key,value) -> System.out.println(key +" "+ value));
	}

}
