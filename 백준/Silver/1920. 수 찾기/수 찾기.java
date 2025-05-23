

import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static long[] A;
	static int M;
	static long[] B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		A = new long[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		B = new long[M];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			B[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(A);

		for (int j = 0; j < M; j++) {
			int result = Arrays.binarySearch(A, B[j]);

			if (result >= 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
