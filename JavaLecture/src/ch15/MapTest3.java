package ch15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MapTest3 {
	public static void main(String[] args) {
		test();
	}
	
	private static void test() {
		String sample = "What a radical idea, the great gift that our Founders gave to us. " +
				"The freedom to chase our individual dreams through our sweat, and toil, " +
				"and imagination — and the imperative to strive together as well, to achieve a common good, a greater good. " +
				"For 240 years, our nation’s call to citizenship has given work and purpose to each new generation. " + 
				"It’s what led patriots to choose republic over tyranny, pioneers to trek west, slaves to brave that makeshift railroad to freedom. " +
				"It’s what pulled immigrants and refugees across oceans and the Rio Grande. " + 
				"It’s what pushed women to reach for the ballot. It’s what powered workers to organize. " +
				"It’s why GIS gave their lives at Omaha Beach and Iwo Jima; " +
				"Iraq and Afghanistan — and why men and women from Selma to Stonewall were prepared to give theirs as well.";

		/*
		 * 한 문자열을 각 단어별로 쪼개보자.
		 * StringTokenizer 이용..., split
		 */
		StringTokenizer st = new StringTokenizer(sample, " .,;—"); // delimiter를 공백, 마침표, 쉼표, 세미콜론, 대쉬.
		// st가 구분자로 분리된 토큰들을 품고 있다.
		// 하나씩 곶감 빼먹듯 빼먹어 보자.
		// 예의바르게. 있어요? 라고 물어보고. 있으면 달라고 해야 된다.
		// Map이라는 자료구조를 이용해서, 각 단어가 몇 번 출현했는지 그 빈도를 저장하고자 한다.
		// Map은 <key, value>의 쌍으로 저장한다. key는 단어로, value를 빈도로.
		// Map은 generic 인터페이스이다. 이 의미는 객체 생성할 때 내부에서 사용할 데이터 타입을 파라미터로 명시해야한다.
		// 예를 들면 ArrayList<String> list = new ArrayList<>(); ArrayList<Integer> list2 = new ArrayList<>();
		// Map<String, Integer> map = new HashMap<>();
		// HashMap<> map = new HashMap<>();
		// Object o = new Student();
		// Student s = new Student();
		
//		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> map = new TreeMap<>(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
		
		// map에 <key, value> 쌍으로 저장한다. 이때 사용하는 메소드는? put
		// put 메소드를 통해 <key, value>의 쌍으로 맵에 저장을 하는데
		// 이전에 이미 추가된 것과 동일한 key가 명시되면, 그 키와 연결된 값이 갱신된다.
		while(st.hasMoreElements()) { //st.hasMoreTokens(), st.hasMoreElements() 둘다 OK
			String str = st.nextToken();
			System.out.println(str);
//			map.put(str, 1);  // <freedom, 1>, <what, 1>
			// map에 넣기 전에, 지금 삽입하고자 하는 key와 연결된 값이 이미 있는지 체크.
			// map.get(key)는 그 key와 연결된 값이 있으면 그 값을 반환하고, 없으면 null을 반환한다.
			Integer value = map.get(str);
			if (value == null) { // 지금 처음 나온 단어
				map.put(str, 1);
			}else { // 이미 이전에 나온 맵에 추가된 단어.
				map.put(str, value + 1); // 그 단어와 연결되어 있던 value 값이 갱신되는 것.
			}
		}
		
//		Integer freq = map.get("freedom");
//		System.out.println("freedom 이라는 단어는 " + freq + "번 출력했습니다.");
		
		// 1. map에게 니가 가진 key들을 다 주세요 라고 요청을 하고,
		// 	  그렇게 전달을 받은 key들에 대해서 값을 하나씩 찍어보면 된다.
		// 2. map에게 니가 가진 모든 <key, value> 쌍들을 주세요.. 라고 요청하고
		//    그렇게 전달받은 그 쌍들을 하나씩 찍는다.
		
		Set<String> keyset = map.keySet();
		
		// Set에 있는 원소를 하나씩 뺄 수 있어야 하는데..
		// 그 방법은 1. Iterator, 2. for each 문...
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key + ":" + value);
		}
		
		ArrayList<Map.Entry<String, Integer>> eList = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Set<Map.Entry<String, Integer>> entryset = map.entrySet(); // Map.Entry<String, Integer> 객체를 원소로 가지는 set을 반환해준다.
		Iterator<Map.Entry<String, Integer>> eIter = entryset.iterator();
		while(eIter.hasNext()) {
			Map.Entry<String, Integer> entry = eIter.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		Collections.sort(eList, new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue() - o1.getValue();
			}
			
		});
		System.out.println("\n\n ###################################");
		System.out.println("정렬 후");
		for (Map.Entry<String, Integer> entry : eList) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		// mission 1) 단어의 알파벳 순으로 그 빈도를 출력.
		// mission 2) 단어가 많이 나온 순으로 그 빈도를 출력.
		
//		List<Integer> list = new ArrayList<>();
//		for (int i = 10; i > 0; i--) list.add(i);
//		System.out.println("정렬하기 전");
//		System.out.println(list);
//		
//		Collections.sort(list);
//		
//		System.out.println("정렬 후");
//		System.out.println(list);
		
		
	}
}
