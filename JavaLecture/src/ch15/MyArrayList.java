package ch15;

public class MyArrayList<T> implements Iterable {
	T[] array;
	private int capacity = 10;
	private int size = 0;

	public MyArrayList() {
		array = (T[]) new Object[capacity];
	}
	
	public int size() {
		return size;
	}

	public void add(T value) {
		if (size < capacity)
			array[size++] = value;
		else {
			int increasedCapacity = (int) (capacity * 1.5);
			T[] tmpArray = (T[]) new Object[increasedCapacity];
//			for(int i = 0; i < size; i++) 
//				tmpArray[i] = array[i];
			System.arraycopy(array, 0, tmpArray, 0, size);
			array = tmpArray;
			capacity = increasedCapacity;
		}
	}

	public T get(int idx) {
		if (idx < size)
			return array[idx];
		else
			return null;
	}

	public void remove(int idx) {

	}

}
