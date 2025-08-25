import java.util.*;
import java.io.*;

public class Main {
    static int N, M, X;
    static List<List<int[]>> nodes;
    static int answer;
    static int[] distFromX;
    
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        nodes = new ArrayList<>();
        distFromX = new int[N + 1];
        answer = Integer.MIN_VALUE;
        
        for(int i = 0; i <= N; i++){
            nodes.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            nodes.get(from).add(new int[]{to, cost});
            
        }
        
        distFromX = dijikstra(X);
        
        for(int i = 1; i < N + 1; i++){
            if(i == X){
                continue;
            }
            
            int[] dists = dijikstra(i);
            
            answer = Math.max(answer, dists[X] + distFromX[i]);
        }
        
        System.out.println(answer);
    }
    
    private static int[] dijikstra(int start){
        boolean[] visited = new boolean[N + 1];
        int[] dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currCost = curr[1];
            
            if(visited[currNode]){
                continue;
            } 
            
            visited[currNode] = true;
            for(int[] connNodes : nodes.get(currNode)){
                int nextNode = connNodes[0];
                int nodeCost = connNodes[1];
                
                int nextCost = currCost + nodeCost;
                if(dists[nextNode] > nextCost){
                    dists[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
                
                
            }
        }
        
        return dists;
        
    }
}
