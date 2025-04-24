

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] towers;
	static int[] answer;
	static Deque<int[]> deque;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		towers = new int[N + 1];
		answer = new int[N + 1];
		deque = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		int firstTower = Integer.parseInt(st.nextToken());
		deque.offerFirst(new int[] { 1, firstTower });

		for (int i = 2; i < N + 1; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
			getTower(i);
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	private static void getTower(int index) {
		int height = towers[index];

		while (!deque.isEmpty() && deque.peekFirst()[1] < height) {
			int[] top = deque.peekFirst();
			int topIndex = top[0];
			int topHeight = top[1];

			if (topHeight <= height) {
				deque.pollFirst();
			}
		}

		if (deque.isEmpty()) {
			answer[index] = 0;
		} else {
			answer[index] = deque.peekFirst()[0];
		}
		
		deque.offerFirst(new int[] { index, height });

	}
}
