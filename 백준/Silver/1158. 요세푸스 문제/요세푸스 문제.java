

import java.util.*;
import java.io.*;

public class Main{
	static int N, K;
	static Deque<Integer> deque;
	static int cntN = 0;
	static int cnt = 0;
	static ArrayList<Integer> answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		deque = new ArrayDeque<>();
		answer = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			deque.offerLast(i);
		}

		while (cntN != N) {
			cnt += 1;
			// System.out.println(cnt);
			int next = deque.pollFirst();
			if (cnt % K == 0) {
				answer.add(next);
				cntN += 1;
				// System.out.println(next);
			} else {
				deque.offerLast(next);
			}

		}

		System.out.print("<");
		for (int i = 0; i < N; i++) {
			System.out.print(answer.get(i));
			if (i != N - 1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}

}
