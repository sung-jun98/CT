

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] A;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		answer = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		// System.out.println(Arrays.toString(A));

		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;

			while (true) {
				if (right <= left) {
					break;
				}
				if (i == right) {
					right--;
					continue;

				} else if (i == left) {
					left++;
					continue;
				}
				if (A[left] + A[right] == A[i]) {
					answer += 1;
					break;
				} else if (A[left] + A[right] > A[i]) {
					right -= 1;
				} else if (A[left] + A[right] < A[i]) {
					left += 1;
				}

				// System.out.println(left + " " + right);

			}
		}

		System.out.println(answer);
	}
}
