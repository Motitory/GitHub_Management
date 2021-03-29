package ch15;

import java.util.Arrays;

public class UtilTest {
	public static void main(String[] args) {
		Integer[] arr = {3, 4, 2, 10, 38, 76, 92, 124, 13, 24};
//		Double[] arr = {3.0, 4.0, 2.0, 10.0, 38.0, 76.0, 92.0, 124.0, 13.0, 24.0};
//		Student[] arr = { new Student("가", 78), new Student("나", 88), new Student("다", 66), new Student("라", 56) };

//		System.out.println("배열의 값");
//		Util.println(arr);
//		System.out.println("최대값 : " + Util.getMax(arr));

//		Util.printValueOf5Times(5.0);
//		Util.printValueOf5Times(Math.sqrt(5));
		
		Util.printSum(Arrays.asList(arr));
		
	}
}
