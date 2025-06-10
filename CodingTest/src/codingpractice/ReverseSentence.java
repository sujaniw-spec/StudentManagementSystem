package codingpractice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abc de f";
		StringBuilder sb = new StringBuilder();
		
		for(String word: input.split(" ")) {
			sb.append(new StringBuilder(word).reverse()).append(" ");
		}
		
		System.out.println(sb);
		
		String result = Arrays.stream(input.split(" "))
		      .map(word -> new StringBuilder(word).reverse().toString())
		      .collect(Collectors.joining(" "));
		System.out.println(result);
	}

}
