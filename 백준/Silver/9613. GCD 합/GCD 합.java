

import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int N;
	static int[] inputs;
	static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			inputs = new int[N];
			answer = 0;
			boolean[] visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				inputs[i] = Integer.parseInt(st.nextToken());
			}

			comb(visited, 0, 2);
			System.out.println(answer);
		}
	}

	static public void comb(boolean[] visited, int start, int r) {
		if (r == 0) {
			int[] tmpGcd = new int[2];
			int index = 0;
			for (int i = 0; i < inputs.length; i++) {
				if (visited[i] == true) {
					tmpGcd[index] = inputs[i];
					index += 1;
				}
			}
			
			Arrays.sort(tmpGcd);
			gcd(tmpGcd[0], tmpGcd[1]);
			
			return;
		}

		for (int i = start; i < N; i++) {
			visited[i] = true;
			comb(visited, i + 1, r - 1);
			visited[i] = false;
		}
	}

	static public int gcd(int a, int b) { // a > b 일때
		if (b == 0) {
			answer += a;
			
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}
