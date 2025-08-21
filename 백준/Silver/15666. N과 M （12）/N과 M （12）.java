import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] inputs;
    static Set<List<Integer>> set;
    
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
        dfs(0, new ArrayList<>());
        
    }
    
    private static void dfs(int start, List<Integer> cand){
        if(cand.size() == M){
            int setSize = set.size();
            set.add(cand);
            if(setSize == set.size()){
                return ;
            } else {
                for(int i = 0; i < M; i++){
                    System.out.print(cand.get(i) + " ");
                }
                System.out.println();
            }
            return ;
        }
        
        for(int i = start; i < inputs.length; i++){
            cand.add(inputs[i]);
            dfs(i, cand);
            cand.remove(cand.size() - 1);
        }
    }
}
