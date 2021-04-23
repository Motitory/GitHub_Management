package ch15;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		/*
		 * Map은 인터페이스이고 이놈을 구현한 구현 클래스가
		 * HashMap, TreeMap, LinkedHashMap 3개가 있다.
		 * 그래서 Map 타입의 변수는 위의 3개 타입의 객체를
		 * 수용할 수 있다.
		 * Map은 값을 <key, value> 쌍으로 저장한다.
		 * Map은 Generic이다.
		 * 클래스, 메소드 내부에서 사용할 데이터 타입을 정해져 있지 않고
		 * 실제 그 클래스 객체를 만들거나 메소드를 호출할 때
		 * 사용할 데이터 타입을 파라미터로 받아서 처리하는 것.
		 * 문자열 타입의 학번을 key로, Student 객체를 값으로 Map에 저장. 
		 */
		
		Map<String, Student2> map = new HashMap<>();
		
		// Map에 원소 (<key, value>로 구성된 entry)를 넣을때는
		// put 메소드를 사용 : put 메소드는 원소 삽입과 변경에 모두 사용됨.
		// Map에서 원소(Entry)를 읽을 때는 get(key) 메소드를 사용.
		
		// 이미 존재하는 키 값으로 put 하면
		// 기존 원소를 replace 하게 된다.(대체한다.)
		
		map.put("20201234", new Student2(20201234, "홍길동"));
		map.put("20201235", new Student2(20201235, "일지매"));
		map.put("20201236", new Student2(20201236, "성춘향"));
		map.put("20201237", new Student2(20201237, "이몽룡"));
		map.put("20201238", new Student2(20201238, "월매"));
		
		// 원소값을 읽을 때는 키 값을 주어야 한다.
//		Student2 std = map.get("20201237");
//		System.out.println(std);
		
		// map 객체에게 니가 가진 key 값을 다 줘... 라고 할 수 있다.
		Set<String> keyset = map.keySet();
		// keyset에 있는 각 원소를 통해서 map에게 값을 요구하면 된다.
		// 왜냐하면 그 원소가 map에 저장된 값이 key니까...
		
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Student2 std = map.get(key);
			System.out.println(std);
		}
		
		// Entry의 Set : <key, value> pair의 set
		
		/*
		 * Map 객체에게 entrySet 메소드를 호출하면
		 * Map.Entry 타입 객체를 원소로 가지는 Set 객체가 봔환된다.
		 */
		
		Set<String> set1;
		Set<Integer> set2;
		Set<Student> set3;
		
		Set<Map.Entry<String, Student2>> entrySet =  map.entrySet();
		
		Iterator<Map.Entry<String, Student2>> iter2 = entrySet.iterator();
		while(iter2.hasNext()) {
			Map.Entry<String, Student2> entry = iter2.next();
			String myKey = entry.getKey();
			Student2 mystd = entry.getValue();
			System.out.println("key: " + myKey + ", value " + mystd);
		}
		
		for(Map.Entry<String, Student2> entry : map.entrySet()) {
			String mykey = entry.getKey();
			Student2 mystd = entry.getValue();
			System.out.println("key: " + mykey + ", value: " + mystd);
		}
	}
}

class Student2 {
	int number;
	String name;

	public String toString() {
		return "[number: " + number + ", name: " + name + "]";
	}

	public Student2(int number, String name) {
		this.number = number;
		this.name = name;
	}
}
