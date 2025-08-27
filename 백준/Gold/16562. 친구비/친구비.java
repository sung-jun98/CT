import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[] costs;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        costs = new int[N];
        st = new StringTokenizer(br.readLine());
        UnionFind uf = new UnionFind(N);
        
        for(int i = 0; i < N; i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());
            
            uf.union(friend1, friend2);
            
        }
        
        int answer = uf.check();
        
        if(answer == -1){
            System.out.println("Oh no");
            
        } else{
            System.out.println(answer);
        }
    }
    
    static class UnionFind {
        int[] parents;
    
        UnionFind(int N) {
            this.parents = new int[N + 1];
            
            for(int i = 0; i <= N; i++){
                this.parents[i] = i;
            }
        }
        
        public boolean union(int a, int b){
            int parentA = find(a);
            int parentB = find(b);
            
            if(parentA != parentB){
                parents[parentB] = parentA;
                
                return true;
            } else {
                return false;
            }
        }
        
        public int find(int num){
            if(parents[num] != num){
                parents[num] = find(parents[num]);
            }
            
            return parents[num];
        }
        
        public int check(){
            Map<Integer, Integer> map = new HashMap<>();
            
            for(int i = 1; i <= N; i++){
                int groupNum = find(i);
                int minValue = Math.min(map.getOrDefault(groupNum, Integer.MAX_VALUE), costs[i - 1]);
                
                map.put(groupNum, minValue);
            }
            
            int answer = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                answer += entry.getValue();
            }
        
            if(answer <= K){
                return answer;
            }
            
            return -1;    
        }
        
    }
}
