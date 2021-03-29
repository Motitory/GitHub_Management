package ch15;

import java.util.*;

public class UtilTest2 {
	public static void main(String[] args) {
		Number n = Integer.valueOf(100);

//		아래 코드는 MisMatch 발생
//		ArrayList<Number> list = new ArrayList<Integer>();

//		아래 메소드를 만들면 가능
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Double> list2 = new ArrayList<Double>();
//		Number 메소드로는 둘 동시에 처리 불가능
		process1(list);
		process2(list2);
		
		process(list);
		process(list2);
		
//		Generic을 쓰는 이유?
//		로직은 같고 내부적으로 사용하는 데이터의 타입만
//		다른 경우에도, 하나의 클래스만 생성해서 사용할 수 있도록 하기 위해...
//		실제로 사용할 데이터 타입은
//		객체 생성 시에 type parameter로 받아서 처리.
//		그리고, 명시적인 type casting도 안해도 되도록 하기 위해...	
		
		
	}

	// public static void process(ArrayList<Number> list) {
	//
	// }

	// 와일드카드 사용시 하나로 처리 가능
	public static void process(ArrayList<? extends Number> list) {

	}

	public static void process1(ArrayList<Integer> list) {
		// 이처럼 메소드 작성시 개별로 가능함.
	}

	public static void process2(ArrayList<Double> list) {

	}
}
