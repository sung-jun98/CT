
import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static ArrayList<Integer> cntArea;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        cntArea = new ArrayList<>();
        cnt = 0;

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    bfs(i, j);
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(cntArea);
        for(int answer : cntArea){
            System.out.println(answer);
        }
    }

    static void bfs(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        int numHouse = 0;
        visited[x][y] = true;
        deque.offerLast(new int[] {x, y});

        while(!deque.isEmpty()){
            int[] prevXY = deque.pollFirst();
            int px = prevXY[0];
            int py = prevXY[1];
            numHouse += 1;
            int nx, ny;

            for(int i=0; i<4; i++){
                nx = px + dx[i];
                ny = py + dy[i];

                if(isIn(nx, ny) && !visited[nx][ny]){
                    if(map[nx][ny] == 1){
                        deque.offerLast(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        cntArea.add(numHouse);
    }

    static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
