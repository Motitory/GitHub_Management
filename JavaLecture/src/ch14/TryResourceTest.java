package ch14;

import java.io.*;

public class TryResourceTest {
	public static void main(String[] args) {
		writeList();
	}

	public static void writeList() {
//		PrintWriter out = null;
//		FileOutputStream fout = null;
//		try {
//			out = new PrintWriter("C:/myfile/outfile.txt");
////			out = new PrintWriter("outfile.txt");
//			for (int i = 0; i < 10; i++) {
//				out.println("배열 원소 " + i + "= " + i);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			if(out != null)
//				out.close();
//			System.out.println("파일을 닫았습니다...");
//		}

//		try (PrintWriter out = new PrintWriter("outfile.txt")){
//			for (int i = 0; i < 10; i++) {
//				out.println("배열 원소 " + i + " = " + i);
//			}
//		}catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}

		try(MyResource rc = new MyResource()){
			System.out.println(rc.getValue());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
