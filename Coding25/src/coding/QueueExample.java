package coding;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		Queue <Integer> q = new LinkedList<>();
		
		q.add(5);
		q.add(15);
		q.add(25);
		
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q.peek());
		
	}

}
