import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        maps = new int[n][m];
        visited = new boolean[n][m];
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int input = Integer.parseInt(st.nextToken());
                
                if(input == 2){
                    queue.offerLast(new int[]{i, j, 0});
                    visited[i][j] = true;
                    maps[i][j] = 0;
                    
                } else {
                    maps[i][j] = input;
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] curr = queue.pollFirst();
            
            int cx = curr[0];
            int cy = curr[1];
            int currCost = curr[2];
            
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nextCost = currCost + 1;
                
                if(isIn(nx, ny) && maps[nx][ny] != 0 && !visited[nx][ny]){
                    maps[nx][ny] = nextCost;
                    queue.offerLast(new int[]{nx, ny, nextCost});
                    visited[nx][ny] = true;
                }
            }
        }
        
    
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i][j] == 1 && !visited[i][j]){
                    maps[i][j] = -1;
                }
            }
        }        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(maps[i][j] + " ");
            }
            
            System.out.println();
        }
    }
    
    private static boolean isIn(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
