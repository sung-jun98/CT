

import java.util.*;
import java.io.*;

/*
 * 
 * O O X
 * O X O
 * X O O
 * 
 */
public class Main {
	static int N;
	static int[] inputs;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inputs = new int[N];
		dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
		}

		dp[0][0] = 0;
		dp[0][1] = inputs[0];
		dp[0][2] = 0;

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
			dp[i][1] = dp[i - 1][0] + inputs[i];
			dp[i][2] = dp[i - 1][1] + inputs[i];
		}

		int answer = Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2]));
		System.out.println(answer);
	}

}
