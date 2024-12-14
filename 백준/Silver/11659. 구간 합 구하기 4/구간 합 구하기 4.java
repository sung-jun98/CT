

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, i, j;
	static int[] num;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N + 1];
		num[0] = 0;
		answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int input = Integer.parseInt(st.nextToken());
			num[i] = num[i - 1] + input;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			answer = num[end] - num[start - 1];
			System.out.println(answer);
		}

	}

}
