package ch15;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackExercise {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("수식을 입력하세요.");
		String exp = input.nextLine();

		StringTokenizer st = new StringTokenizer(exp, " "); // 문자열을 구분자를 기준으로 토근으로 분리해줌

		Stack<String> stack = new Stack<>();
		while (st.hasMoreTokens()) {
//			System.out.println("[" + st.nextToken() + "]");
			String token = st.nextToken();
			if (token.equals("("))
				stack.push(token);
			else if (token.equals(")")) {
				if (stack.isEmpty() == false)
					stack.pop();
				else {
					System.out.println("유효하지 않은 식입니다");
					// 메소드 종료
					return;
				}
			}
		}

		if (stack.isEmpty())
			System.out.println("유효한 식입니다.");
		else
			System.out.println("유효하지 않는 식입니다.");
	}

	public static void stringTokenizerTest() {
		StringTokenizer st = new StringTokenizer("APPLE, GRAPE, BANANA, MELON, STRAWBERRY", ", ");
		while (st.hasMoreTokens()) {
			System.out.println("[" + st.nextToken() + "]");
		}
	}
}
