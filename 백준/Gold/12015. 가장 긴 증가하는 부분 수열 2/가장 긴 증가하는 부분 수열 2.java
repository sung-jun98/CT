

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] A;
	static int[] dp;
	static int maxIndex = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());

		}

		dp[0] = A[0];
		for (int i = 1; i < N; i++) {
			if (A[i] > dp[maxIndex]) {
				maxIndex += 1;
				dp[maxIndex] = A[i];

			} else {
				int index = Arrays.binarySearch(dp, 0, maxIndex + 1, A[i]);
				if (index < 0) {
					index = index * -1 - 1;

				}
				dp[index] = A[i];

			}
		}

		System.out.println(maxIndex + 1);

	}
}
