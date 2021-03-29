package ch15;

import javax.swing.JFrame;

public class MyBoxTest {
	public static void main(String[] args) {
//		T가 Object로 설정됨 //		Primitive class로 auto boxing을 함
		MyBox<String> box1 = new MyBox<>();
		box1.setValue("홍길동");
//		box1.setValue(100);
//		box1.setValue(123.4); 
//		box1.setValue(new JFrame());

//		아무거나 넣을 수는 있으나
//		꺼낼때는 타입캐스트를 해줘야함... 잘못 타입캐스팅하면 오류남.
		openBox(box1);
//		print(Integer.valueOf(100));
		
		MyBox<Integer> box2 = new MyBox<>();
//		box2.setValue("일지매");
		box2.setValue(100);
		
	}

	private static void print(int val) {
		System.out.println(val);
	}

	private static void openBox(MyBox<String> box) {
//		Object obj = box.getValue();
		String d = box.getValue();
		System.out.println(d);
	}
}
