import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] inputs;
    static int cnt, answer;
    static Deque<int[]> queue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputs = new int[M][N];
        visited = new boolean[M][N];
        queue = new ArrayDeque<>();
        cnt = 0;
        answer = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());

                if (inputs[i][j] == 1) {
                    queue.offerLast(new int[]{i, j, 0});
                    visited[i][j] = true;
                } else if (inputs[i][j] == 0) {
                    cnt += 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.pollFirst();
            int currX = curr[0];
            int currY = curr[1];
            int currDist = curr[2];

            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if (isIn(nx, ny) && !visited[nx][ny] && inputs[nx][ny] == 0) {
                    queue.offerLast(new int[]{nx, ny, currDist + 1});
                    visited[nx][ny] = true;
                    cnt -= 1;
                    answer = Math.max(answer, currDist + 1);
                }
            }
        }

        if (cnt == 0) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
