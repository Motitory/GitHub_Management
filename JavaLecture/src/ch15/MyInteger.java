package ch15;

public class MyInteger {
	private int value;

	public MyInteger(int value) {
		this.value = value;
	}

	public int intValue() {
		return value;
	}

	public static void main(String[] args) {
		MyInteger num = new MyInteger(100);

		int sum = num.intValue() + 20;
	}
}
