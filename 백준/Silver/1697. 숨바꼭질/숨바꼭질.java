

import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] dept;
	static boolean[] visited;
	static int[] nextStep = { -1, 1, 2 };
	static int answer;
	static Deque<Integer> deque;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = Math.abs(N - K);
		dept = new int[100001];
		visited = new boolean[100001];
		count = -1;

		// dfs(N, 0);
		bfs();
		System.out.println(answer);

	}

	private static void bfs() {
		deque = new ArrayDeque<>();
		deque.offerLast(N);
		visited[N] = true;
		while (!deque.isEmpty()) {
			int next = deque.pollFirst();
			count += 1;
			// 종료조건
			if (next == K) {
				answer = dept[next];
			}

			for (int step : nextStep) {
				int nextStep = 0;
				if (step == -1 || step == 1) {
					nextStep = next + step;
					if (nextStep >= 0 && nextStep < 100001 && visited[nextStep] == false) {
						deque.offerLast(nextStep);
						visited[nextStep] = true;
						dept[nextStep] = dept[next] + 1;
					}
					
				} else if (step == 2) {
					nextStep = next * 2;
					if (nextStep >= 0 && nextStep < 100001 && visited[nextStep] == false) {
						deque.offerLast(nextStep);
						visited[nextStep] = true;
						dept[nextStep] = dept[next] + 1;
					}
				}
			}

			

		}
	}

	private static void dfs(int now, int sec) {
		// 종료조건
		if (sec > answer) {
			return;
		} else if (now == K && sec < answer) {
			answer = sec;
			dept[now] = sec;
			return;
		}

		// 값 갱신
		if (dept[now] > sec) {
			dept[now] = sec;
		}

		for (int step : nextStep) {
			if (isIn(now + step)) {
				if (step == 2) {
					dfs(now * 2, sec + 1);
				} else {
					dfs(now + step, sec + 1);
				}
			}
		}
	}

	private static boolean isIn(int n) {
		return n >= 0 && n <= 100000;
	}

}
