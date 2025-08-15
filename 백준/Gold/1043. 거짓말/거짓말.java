import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] truth;
    static int answer;
    static List<int[]> party;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        truth = new boolean[N + 1];
        UnionFind uf = new UnionFind(N);
        party = new ArrayList<>();
        answer = 0;
        
        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < truthNum; i++){
            int known = Integer.parseInt(st.nextToken());
            truth[known] = true;
            
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int total = Integer.parseInt(st.nextToken());
            int[] input = new int[total];
            
            for(int j = 0; j < total; j++){
                input[j] = Integer.parseInt(st.nextToken());
            }
            
            for(int j = 0; j < total - 1; j++){
                uf.union(input[j], input[j + 1]);
            }
    
            party.add(input);
        }
        
        for(int i = 1; i <= N; i++){
            if(truth[i]){
                for(int j = 1; j <= N; j++){
                    if(uf.find(i) == uf.find(j)){
                        truth[j] = true;
                    }
                }
            }
        }
        
        int known = 0;
        for(int[] smallParty : party){
            for(int person : smallParty){
                if(truth[person]){
                    known += 1;
                    break;
                }
            }
        }
        
        System.out.println(M - known);
    }
    
    private static class UnionFind {
        int[] parents;
        
        UnionFind(int N){
            this.parents = new int[N + 1];
            for(int i = 0; i <= N; i++){
                parents[i] = i;
            }
        }
        
        public boolean union(int a, int b){
            int parentA = find(a);
            int parentB = find(b);
            
            if(parentA == parentB){
                return false;
            }
            
            parents[parentB] = parentA;
            return true;
        }
        
        public int find(int index){
            if(index != parents[index]){
                parents[index] = find(parents[index]);
            }
            
            return parents[index];
        }
    }
}
