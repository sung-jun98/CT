
import java.util.*;
import java.io.*;

public class Main {
	static int w, h;
	static int[][] map;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static boolean[][] visited;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];
            answer = 0;

            for (int i = 0; i < h; i++) {  // 높이 h에 대해 반복
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {  // 너비 w에 대해 반복
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 방문하지 않았고 섬인 경우만 bfs 호출
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    private static void bfs(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[] { x, y });
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            int[] xy = deque.pollFirst();
            for (int i = 0; i < 8; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];

                if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    deque.offerLast(new int[] { nx, ny });
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }
}
