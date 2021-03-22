package ch14;

import java.util.Scanner;

public class AssertionTest {
	public static void main(String args[]) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("날짜를 입력하세요.");
			int date = sc.nextInt();
			
			assert(date >= 1 && date <= 31) : "잘못된 날짜: " + date;
			
			System.out.printf("입력된 날짜는 %d 입니다.\n", date);
		}catch(Exception e) {
			
		}
	}
}
