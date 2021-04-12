package ch15;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < 10; i++) {
			// auto boxing
			// stack.push(Character c); // char의 Wrapper class
			// stack.push(char c);
			stack.push((char)('A' + i));
		}
		
		System.out.println(stack);
		
		// 다음에 인출될 원소를 엿보기.
		System.out.println("다음에 인출된 원소는 " + stack.peek());
		System.out.println("다음에 인출된 원소는 " + stack.peek());
		System.out.println("다음에 인출된 원소는 " + stack.peek());
		
		System.out.println(stack);
		
		System.out.println("인출시작");
		
		while(stack.size() > 0) {
			Character nextVal = stack.pop();
			System.out.println(nextVal);
		}
		
//		int size = stack.size();
//		for(int i = 0; i < size; i++) {
//			System.out.println(stack.pop() + " ");
////			System.out.println("다음에 인출된 원소는 " + stack.peek());
//		}
//		System.out.println("\n인출끝");
		
		System.out.println(stack);
		
	}
}
;