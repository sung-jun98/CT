
import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] table;
	static int answerX, answerY;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		table = new int[N][N];
		answerX = 0;
		answerY = 0;
		// 시작지점: (N / 2)
		int start = N / 2;
		dfs(start, start, -1, 1);
		
		printVal();
		System.out.println((answerX + 1) + " " + (answerY + 1));
		
	}

	private static void dfs(int x, int y, int dir, int num) {
		if(num > N * N) {
			return ;
		}
		
		if(num == M) {
			answerX = x;
			answerY = y;
		}
		
		// printVal();
		int nextDir = dir + 1;
		table[x][y] = num;

		int nx = x + dx[nextDir % 4];
		int ny = y + dy[nextDir % 4];

		if (isIn(nx, ny) && table[nx][ny] == 0) {
			dfs(nx, ny, nextDir, num + 1);

		} else if (isIn(nx, ny) && table[nx][ny] != 0) {
			nx = x + dx[(dir) % 4];
			ny = y + dy[(dir) % 4];
			dfs(nx, ny, dir, num + 1);
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	private static void printVal() {
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
}
