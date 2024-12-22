

import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] input;
	static int[][] dp;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		input = new int[n][m];
		dp = new int[n][m];
		answer = 0;

		for (int i = 0; i < n; i++) {
			String col = br.readLine();

			for (int j = 0; j < m; j++) {
				input[i][j] = (int) col.charAt(j) - '0';
				dp[i][j] = (int) col.charAt(j) - '0';
				
				if(input[i][j] == 1) {
					answer = 1;
				}
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (input[i][j] == 1) {
					cntSquare(i, j);
				}
			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(answer * answer);

	}

	static void cntSquare(int x, int y) {
		if (input[x - 1][y] == 1 && input[x][y - 1] == 1) {
			dp[x][y] = Math.min(dp[x][y - 1], Math.min(dp[x - 1][y], dp[x - 1][y - 1])) + 1;

			if (dp[x][y] > answer) {
				answer = dp[x][y];
			}
		}
	}
}
