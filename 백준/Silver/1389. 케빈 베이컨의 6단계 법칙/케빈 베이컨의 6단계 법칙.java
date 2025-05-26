

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int INF = Integer.MAX_VALUE;
	static int flag = Integer.MAX_VALUE;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			String[] line = br.readLine().split(" ");

			int from = Integer.parseInt(line[0]);
			int to = Integer.parseInt(line[1]);

			map[from][to] = 1;
			map[to][from] = 1;
		}

		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (map[i][k] != INF && map[k][j] != INF) {
						map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
					}
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			int sum = 0;

			for (int j = 1; j < N + 1; j++) {
				sum += map[i][j];
			}

			if (sum < flag) {
				flag = sum;
				answer = i;
			}
		}

		System.out.println(answer);
	}
}
