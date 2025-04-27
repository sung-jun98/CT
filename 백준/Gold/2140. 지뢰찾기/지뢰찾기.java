

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[][] input;
	static int[][] board;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new char[N][N];
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			input[i] = line.toCharArray();
			for (int j = 0; j < N; j++) {
				if (input[i][j] != '#') {
					board[i][j] = input[i][j] - '0';
				} else {
					board[i][j] = -1;
				}
			}
		}

		int answer = 0;

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (input[i][j] == '#' && canPut(i, j)) {
					answer++;
					update(i, j, -1);
				}
			}
		}

		System.out.println(answer);
	}

	static boolean canPut(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (board[nr][nc] == 0)
				return false;

		}
		return true;
	}

	static void update(int r, int c, int diff) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (board[nr][nc] >= 0)
				board[nr][nc] += diff;
		}
	}

}
