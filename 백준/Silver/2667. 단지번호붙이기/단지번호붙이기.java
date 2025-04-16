

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static Deque<int[]> deque;
	static ArrayList<Integer> answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		answer = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false && map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(answer);
		
		System.out.println(answer.size());
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}

	private static void bfs(int x, int y) {
		deque = new ArrayDeque<>();
		deque.offerLast(new int[] { x, y });
		visited[x][y] = true;
		int cnt = 1;

		while (!deque.isEmpty()) {
			int[] next = deque.pollFirst();
			

			for (int i = 0; i < 4; i++) {
				int nx = next[0] + dx[i];
				int ny = next[1] + dy[i];

				if (isIn(nx, ny) && visited[nx][ny] == false && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					deque.offerLast(new int[] { nx, ny });
					cnt += 1;
				}
			}
		}
		answer.add(cnt);
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
