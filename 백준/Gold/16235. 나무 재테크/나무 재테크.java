

import java.util.*;
import java.io.*;

public class Main{
	static int N, M, K;
	static int[][] A, nutrition;
	static PriorityQueue<Tree>[][] forest;

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		nutrition = new int[N][N];
		forest = new PriorityQueue[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				nutrition[i][j] = 5;
				forest[i][j] = new PriorityQueue<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			forest[r][c].offer(new Tree(age));
		}

		for (int year = 0; year < K; year++) {
			springAndSummer();
			autumn();
			winter();
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer += forest[i][j].size();
			}
		}

		System.out.println(answer);
	}

	static void springAndSummer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (forest[i][j].isEmpty())
					continue;

				PriorityQueue<Tree> next = new PriorityQueue<>();
				int dead = 0;

				while (!forest[i][j].isEmpty()) {
					Tree tree = forest[i][j].poll();
					if (nutrition[i][j] >= tree.age) {
						nutrition[i][j] -= tree.age;
						next.offer(new Tree(tree.age + 1));
					} else {
						dead += tree.age / 2;
					}
				}

				forest[i][j] = next;
				nutrition[i][j] += dead;
			}
		}
	}

	static void autumn() {
		List<int[]> toAdd = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Tree tree : forest[i][j]) {
					if (tree.age % 5 != 0)
						continue;

					for (int d = 0; d < 8; d++) {
						int ni = i + dr[d];
						int nj = j + dc[d];
						if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
							forest[ni][nj].offer(new Tree(1));
						}
					}
				}
			}
		}
	}
	
	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nutrition[i][j] += A[i][j];
			}
		}
	}

	static class Tree implements Comparable<Tree> {
		int age;

		Tree(int age) {
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}
}
