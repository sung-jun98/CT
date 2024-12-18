
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] table;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		table = new int[10000001];
		table[0] = 0;
		table[1] = 0;

		for (int i = 2; i <= N; i++) {
			table[i] = table[i - 1] + 1;
			if (i % 2 == 0) {
				table[i] = Math.min(table[i], table[i / 2] + 1);
				
			} 
            if (i % 3 == 0) {
				table[i] = Math.min(table[i], table[i / 3] + 1);
				
			}

		}

		System.out.println(table[N]);

	}

}
