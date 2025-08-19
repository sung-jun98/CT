import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<List<Integer>> inputs;
    static int[] parents;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new ArrayList<>();   
        parents = new int[N + 1];
        visited = new boolean[N + 1];
        
        for(int i = 0; i < N + 1; i++){
            inputs.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            inputs.get(from).add(to);
            inputs.get(to).add(from);
        }
        
        visited[1] = true;
        dfs(1);
        
        for(int i = 2; i <= N; i++){
            System.out.println(parents[i]);
        }
    }
    
    private static void dfs(int start){
        List<Integer> conn = inputs.get(start);
        for(int curr : conn){
            if(!visited[curr]){
                parents[curr] = start;
                visited[curr] = true;
                
                dfs(curr);
            }
        }
    }
}
