

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static long[] input;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		input = new long[N];
		tree = new long[N * 4];

		for (int i = 0; i < N; i++) {
			input[i] = Long.parseLong(br.readLine());
		}

		// 트리 초기화
		build(1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			// 수정
			if (a == 1) {
				update(1, 0, N - 1, b - 1, c);
				
			}
			// 누적합
			else if (a == 2) {
				long answer = query(b - 1, c - 1);
				//System.out.println(answer);
				
				sb.append(answer).append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

	static void build(int node, int start, int end) {
		if (start == end) {
			tree[node] = input[start];
			return;
		}

		int mid = (start + end) / 2;

		build(2 * node, start, mid);
		build(2 * node + 1, mid + 1, end);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static void update(int node, int start, int end, int index, long newValue) {
		if (start == end) {
			tree[node] = newValue;
		} else {
			int mid = (start + end) / 2;

			if (index <= mid) {
				update(node * 2, start, mid, index, newValue);

			} else {
				update(node * 2 + 1, mid + 1, end, index, newValue);

			}

			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}

	static long query(int L, long R) {

		return query(1, 0, N - 1, L, R);
	}

	static long query(int node, int start, int end, int L, long R) {
		// 구간 안겹칠때
		if (start > R || end < L) {
			return 0;
		}

		// 트리의 노드가 담당하는 범위와 목표 구간과 일치할때
		if (L <= start && end <= R) {
			return tree[node];
		}

		// 구간이 일부 겹칠때
		int mid = (start + end) / 2;
		long left = query(node * 2, start, mid, L, R);
		long right = query(node * 2 + 1, mid + 1, end, L, R);

		return left + right;
	}

}
