import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int max, maxIndex;
    static boolean[] visited;
    static List<List<int[]>> inputs;
    
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        maxIndex = 0;
        inputs = new ArrayList<>();
        visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++){
            inputs.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            inputs.get(from).add(new int[] {to, cost}); 
            inputs.get(to).add(new int[] {from, cost});           
        }
        
        
        dfs(1, 0);
        
        max = Integer.MIN_VALUE;
        visited = new boolean[n + 1];
        
        dfs(maxIndex, 0);
        
        System.out.println(max);
        
    }
    
    private static void dfs(int start, int dist){
        if(dist > max){
            maxIndex = start;
            max = dist;
        }
            
        visited[start] = true;
        List<int[]> curr = inputs.get(start);
        for(int[] conn : curr){
            int to = conn[0];
            int cost = conn[1];
            
            
            int totalCost = dist + cost;
            
            if(!visited[to]){
                
                dfs(to, totalCost);
            }
        }
    }
}
