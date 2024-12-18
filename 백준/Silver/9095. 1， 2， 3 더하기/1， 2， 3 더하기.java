
import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int[] table;
	static int input, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		table = new int[11];

		table[1] = 1;
		table[2] = 2;
		table[3] = 4;

		for (int i = 4; i < 11; i++) {
			table[i] = table[i - 1] + table[i - 2] + table[i - 3];
			
		}
		
		for (int t = 1; t <= T; t++) {
			input = Integer.parseInt(br.readLine());
			
			sb.append(table[input]).append('\n');
		}
		
		System.out.println(sb.toString());
		
	}

}
