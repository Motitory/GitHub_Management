package ch15;

public class MyBox <T>/*제네릭 클래스*/{
	// T의 데이터타입만 바꿔주면 됨
	T value;
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
}
