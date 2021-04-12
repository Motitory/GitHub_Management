package ch15;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return (o1.intValue() - o2.intValue()) * -1;
	}
}

public class QueueTest {

	public static void main(String[] args) {
		testPriorityQueue();
	}

	private static void testPriorityQueue() {
		Queue<Integer> queue = new PriorityQueue<>(new MyComparator());
//		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o1.intValue() - o2.intValue();
//			}
//			
//		});
		for (int i = 10; i > 0; i--)
			queue.offer(i);

		System.out.println(queue);

		for (Integer n : queue)
			System.out.print(n + " ");

		System.out.println();

		int length = queue.size();
		for (int i = 0; i < length; i++) {
			System.out.println((i + 1) + "번째 원소 : " + queue.poll());
		}
	}
}
