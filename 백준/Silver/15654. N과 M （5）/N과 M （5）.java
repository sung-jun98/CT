import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] inputs;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        inputs = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(inputs);
        
        dfs(0, new ArrayList<>());
    }
    
    private static void dfs(int start, List<Integer> selected){
        if(selected.size() == M){
            
            for(int i = 0; i < M; i++){
                System.out.print(selected.get(i) + " ");
            }
            
            System.out.println();
            return ;
        }
        
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                
                selected.add(inputs[i]);
                dfs(start, selected);
                selected.remove(selected.size() - 1);
                
                visited[i] = false;
            }
        }
    }
}
