package ch15;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class lotto {
	public static void main(String[] args) {
		test1();
	}
	
	private static void test1() {
		Set<Integer> set = new TreeSet<>();
		
		for(; set.size() < 6;) {
			int num = (int)(Math.random() * 45) + 1;
//			Random rand = new Random(System.currentTimeMillis());
//			int num = rand.nextInt(45) + 1;
			set.add(num);
		}
		
		System.out.println("원소의 수 : " + set.size());
		// 출력은 오름차순으로 정렬된 순서로..
		
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		System.out.println("끝");
	}
}
