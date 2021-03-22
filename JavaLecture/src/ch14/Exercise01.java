package ch14;

import java.util.Scanner;

public class Exercise01 {
	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
		try {
			while (true) {
				int val = getInput();
				switch (val) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
					System.out.println("5이하의 수 : " + val);
					break;
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
					System.out.println("5 초과 10이하의 수 : " + val);
					break;
				default:
					System.out.println("1~10 사이의 값을 입력하세요.");
				}
			}
		} catch (Exception e) {
			System.out.println("일반 문자 말고 숫자!!");
		} finally {

		}

	}

	private static int getInput() {
		Scanner sc = new Scanner(System.in);
//		String val = sc.nextLine();
//		for(int i = 0; i < val.length(); i++) {
//			if(val.charAt(i) < '0' || val.charAt(i) > '9') {
//				return -1;
//			}
//		}

//		return Integer.parseInt(val);
		System.out.println("1~10 사이의 수를 입력하세요...");
		return sc.nextInt();
	}

}
