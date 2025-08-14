import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static Set<List<Integer>> set;
    static int[] inputs;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        inputs = new int[N];
        set = new LinkedHashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(inputs);
        
        dfs(new ArrayList<Integer>(), new boolean[N]);
        
        for(List<Integer> curr : set){
            for(int currDetail : curr){
                System.out.print(currDetail + " ");
            }
            
            System.out.println();
        }
    }
    
    private static void dfs(List<Integer> curr, boolean[] visited){
        if(curr.size() == M){
            set.add(new ArrayList<>(curr));
            return ;
        }       
        
        
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                curr.add(inputs[i]);
                
                dfs(curr, visited);
                
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
        
    }
}
