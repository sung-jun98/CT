import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N + 1];
        
        dfs(new int[M], 1, 0);
    }
    
    private static void dfs(int[] selected, int start, int dept){
        if(dept == M){
            for(int i = 0; i < M; i++){
                System.out.print(selected[i] + " ");
            }
            
            System.out.println();
            return ;
        }
        
        for(int i = start; i <= N; i++){
            selected[dept] = i;
            dfs(selected, i, dept + 1);
        }
    }
}
