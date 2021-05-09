package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("in.txt"));
		String n = br.readLine();
		System.out.println(n);
	}
}
