import java.util.*;
import java.io.*;

public class Main {
    static int N, E;
    static List<List<int[]>> nodes;
    static int answer;
    static int mustFrom, mustTo;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        nodes = new ArrayList<>();
        answer = -1;
        
        for(int i = 0; i < N + 1; i++){
            nodes.add(new ArrayList<>());
        }
        
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            nodes.get(from).add(new int[] {to, cost});
            nodes.get(to).add(new int[] {from, cost});
        }
        
        st = new StringTokenizer(br.readLine());
        
        mustFrom = Integer.parseInt(st.nextToken());
        mustTo = Integer.parseInt(st.nextToken());
        
        int INF = Integer.MAX_VALUE;
        int[] dist1 = dijikstra(1);
        int[] dist2 = dijikstra(mustFrom);
        int[] dist3 = dijikstra(mustTo);
        
        int cand1 = Integer.MAX_VALUE;
        int cand2 = Integer.MAX_VALUE;
        // to -> mustTo -> mustFrom -> N
        if(dist1[mustTo] < INF && dist3[mustFrom] < INF && dist2[N] < INF){
            cand1 = dist1[mustTo] + dist3[mustFrom] + dist2[N];
        }
        
        // to -> mustFrom -> mustTo -> N
        if(dist1[mustFrom] < INF && dist2[mustTo] < INF && dist3[N] < INF){
            cand2 = dist1[mustFrom] + dist2[mustTo] + dist3[N];
        }
        
        if(cand1 != INF && cand2 != INF){
            answer = Math.min(cand1, cand2);
        }
       
        
        System.out.println(answer);
    }
    
    private static int[] dijikstra(int from){
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[from] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.offer(new int[] {from, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            int currNode = curr[0];
            int currCost = curr[1];
            
            if(visited[currNode]){
                continue;
            }
            
            visited[currNode] = true;
            for(int[] conn : nodes.get(currNode)){
                int next = conn[0];
                int cost = conn[1];
                
                if(!visited[next] && currCost + cost < dist[next]){
                    dist[next] = currCost + cost;
                    pq.offer(new int[] {next, currCost + cost});
                }
                
            }
        }
        
        return dist;
        
    }
}
