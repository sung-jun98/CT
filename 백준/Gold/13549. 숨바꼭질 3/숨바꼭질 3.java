import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];
        
        int answer = dijikstra(N, K);
        
        System.out.println(answer);
    }
    
    private static int dijikstra(int start, int dest){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dists = new int[100_001];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;
        
        pq.offer(new int[]{start, 0});
        
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currPoint = curr[0];
            int currCost = curr[1];
            
            // if(visited[currPoint] && currPoint == K){
                // return currCost;
            // }
            
            if(visited[currPoint]){
                continue;
            }
            
            visited[currPoint] = true;
            int nextPoint  = 0;
            int nextCost = 0;
            
            // 0초후
            nextPoint = currPoint * 2;
            nextCost = currCost;
            if(isIn(nextPoint) && dists[nextPoint] > nextCost){
                dists[nextPoint] = nextCost;
                pq.offer(new int[]{nextPoint, nextCost});
            }
            
            // 1초후
            nextPoint = currPoint + 1;
            nextCost = currCost + 1;
            if(isIn(nextPoint) && dists[nextPoint] > nextCost){
                dists[nextPoint] = nextCost;
                pq.offer(new int[]{nextPoint, nextCost});
            }
            
            nextPoint = currPoint - 1;
            nextCost = currCost + 1;
             if(isIn(nextPoint) && dists[nextPoint] > nextCost){
                dists[nextPoint] = nextCost;
                pq.offer(new int[]{nextPoint, nextCost});
            }
        }
        return dists[K];
    }
    
    private static boolean isIn(int x){
        return x >= 0 && x <= 100_000;
    }
}
