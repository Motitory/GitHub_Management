package ch14;

public class MyResource implements AutoCloseable{
	
	public int getValue() throws Exception {
		int val =(int)Math.random() * 2;
		if(val == 1)
			return val;
		else
			throw new Exception("오류 발생...");
	}
	
	
	@Override
	public void close() throws Exception{
		System.out.println("My Resource is closed...");
	}
}
