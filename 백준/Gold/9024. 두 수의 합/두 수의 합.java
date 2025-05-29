

import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int n;
	static long K;
	static long[] inputs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			String[] input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			K = Integer.parseInt(input[1]);

			inputs = new long[n];
			input = br.readLine().split(" ");

			for (int i = 0; i < n; i++) {
				inputs[i] = Long.parseLong(input[i]);
			}

			Arrays.sort(inputs);
			int left = 0;
			int right = n - 1;
			long minDiff = Long.MAX_VALUE;
			int count = 0;

			while (left < right) {
				long sum = inputs[left] + inputs[right];
				long diff = Math.abs(K - sum);

				if (diff < minDiff) {
					minDiff = diff;
					count = 1;
				} else if (diff == minDiff) {
					count += 1;
				}

				if (sum < K) {
					left += 1;
				} else {
					right -= 1;
				}
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb.toString());
	}
}
