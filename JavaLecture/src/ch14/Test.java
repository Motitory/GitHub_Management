package ch14;

public class Test {
	public static void main(String[] args) {
		String id = "scpark";
		String pw = "11111";

		// 예외처리 부분에서 try, catch를 해야함
		try {
			login(id, pw);
			System.out.println("환영합니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n제대로 입력하세요.");
//			e.printStackTrace();
		}
	}
	
	private static void login(String id, String pw) throws Exception {
//		위에 코드에다가 오류부분을 알려줘야함
//		try {
//			checkDB(id, pw);
//		} catch (Exception e) {
//			// 오류처리...
//			System.out.println(e.getMessage());
////			e.printStackTrace();
//		}
		// 그냥 Exception을 던져줌
		checkDB(id, pw);                                                                                                                                                                                                                                                     
	}
	
	private static void checkDB(String id, String pw) throws Exception {
		if(id.equals("scpark") == false) {
			// id error
			throw new LoginIDException("ID ERROR");
		}else if(pw.equals("1111") == false) {
			// pw error
			throw new LoginPWException("PASSWORD ERROR");
		}else {
			// login 성공
		}
	}
}
