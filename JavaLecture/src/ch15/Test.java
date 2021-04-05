package ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
//		test1();
		countDistinctWord();
		
	}
	
	
	private static void countDistinctWord() {
//		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		File file = new File("wordbook.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String s = null;
			while((s = br.readLine()) != null) {
//				System.out.println(s);
//				set.add(s);
				Integer n = map.get(s);
				if(n == null) {
					map.put(s, 1);
				}else {
					map.put(s, n + 1);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
//		System.out.println("중복되지 않은 단어 수 : " + set.size());
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key + ":" + value + " ");
		}
		
	}
	
	private static void test1() {
		// HashSet
		// 순서 없고, 중복허용하지 않는 집합 HashSet...
//		Set<String> set = new HashSet<>();
		// LinkedHashSet은 중복은 허용하지 않지만, 입력된 순서는 유지된다 => 입력된 순서로 인출 된다.
		
		// TreeSet은 중복은 허용하지 않지만, 값에 따라 정렬한다. 값의 순서대로 출력된다.
		// 정렬 방식을 바꾸고 싶으면 comparator을 구현해서 주면 된다.
		
//		Set<String> set = new HashSet<>();
//		Set<String> set = new LinkedHashSet<>();
//		Set<String> set = new TreeSet<>();
		Set<String> set = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		String[] strArr = {"단어", "중복", "구절", "중복"};
		for (String s : strArr) {
//			set.add(s);
			if(set.add(s) == false) {
				System.out.println(s + "는 이미 존재하는 값...!");
			}
			
		}
		System.out.println(set);
		
		Iterator<String> iter =  set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
//		iter.next(); 한번 돈 것으로는 접근 불가능.. 다시 한번 만들어 받아야함
//		System.out.println(iter.next());
		System.out.println("끝!!");
		
		
	}
	
	private void test0() {
		//List<String> list = new ArrayList<>();
		
		
	}
}
