package ch15;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<>();

		// 시험 필수
		
		for (int i = 1; i <= 10; i++) {
			dq.add(i);
//			dq.push(i); // addFirst();
//			dq.addFirst(i);
//			dq.addLast(i);  
		}

		while (dq.size() > 0) {
			Integer val = dq.poll(); // first in First out
//			poll(), pollFirst()
//			Integer val = dq.pollLast(); // Last in First out
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
