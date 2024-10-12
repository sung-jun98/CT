

import java.util.*;
import java.io.*;

public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		answer = 0;

		for (int i = 0; i < R; i++) {
			String inputStr = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = inputStr.charAt(j);
			}
		}


		Set<Character> set = new HashSet<>();
		set.add(map[0][0]);

		dfs(0, 0, 1, set);

		System.out.println(answer);
		// printVal();
	}

	private static void dfs(int x, int y, int dept, Set<Character> set) {
		answer = Math.max(dept, answer);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isIn(nx, ny) && !set.contains(map[nx][ny])) {
				set.add(map[nx][ny]);
				dfs(nx, ny, dept + 1, set);
				set.remove(map[nx][ny]);
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

	private static void printVal() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
