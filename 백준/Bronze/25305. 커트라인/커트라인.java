

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int K;
	static int[] score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		score = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(score);

		System.out.println(score[N - K]);

	}

}
