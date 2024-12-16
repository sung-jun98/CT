

import java.io.*;
import java.util.*;

public class Main {
	static int N, Q;
	static long[] input;
	static long[] tree;
	static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		input = new long[N];
		tree = new long[N * 4];
		answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Long.parseLong(st.nextToken());

		}

		build(1, 0, N - 1);

		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(x > y) {
				int tmp = y;
				y = x;
				x = tmp;
			}
			
			long sum = query(x - 1, y - 1);
			sb.append(sum).append('\n');
			
			update(a - 1, b);
			
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

		tree[node] = tree[2 * node] + tree[2 * node + 1];
	}

	static void update(int index, int newValue) {
		update(1, 0, N - 1, index, newValue);
	}

	static void update(int node, int start, int end, int index, int newValue) {
		if (start == end) {
			tree[node] = newValue;

			return;

		} else {
			int mid = (start + end) / 2;
			if (index <= mid) {
				update(node * 2, start, mid, index, newValue);

			} else if (index > mid) {
				update(node * 2 + 1, mid + 1, end, index, newValue);
			}

			tree[node] = tree[node * 2] + tree[node * 2 + 1];

		}
	}

	static long query(int L, int R) {
		return query(1, 0, N - 1, L, R);
	}

	static long query(int node, int start, int end, int L, int R) {
		// 일치할때
		if (L <= start && end <= R) {
			return tree[node];
		}

		// 범위 벗어날때
		else if (end < L || R < start) {
			return 0;
		}

		// 범위 일부 겹칠때
		int mid = (start + end) / 2;
		long n1 = query(node * 2, start, mid, L, R);
		long n2 = query(node * 2 + 1, mid + 1, end, L, R);

		return n1 + n2;
	}
}
