import java.util.*;
import java.io.*;
/**
1-index
*/
public class Main {
    static int N, M;
    static boolean[] visited;
    static int answer;
    static List<List<Integer>> inputs;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N + 1];
        inputs = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            inputs.add(new ArrayList<>());
        }
        
        answer = 0;
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            inputs.get(from).add(to);
            inputs.get(to).add(from);
            
        }
        
        for(int i = 1; i <= N; i++){
            Deque<Integer> queue = new ArrayDeque<>();
            if(!visited[i]){
                queue.offerLast(i);
                visited[i] = true;
            }
            
            if(!queue.isEmpty()){
                answer += 1;
            }
            
            while(!queue.isEmpty()){
                int curr = queue.pollFirst();
                List<Integer> connList = inputs.get(curr);
                
                for(int conn : connList){
                    if(!visited[conn]){
                        queue.offerLast(conn);
                        visited[conn] = true;
                    }
                }
            }
            
            
        }
        
        System.out.println(answer);
        
        
    }
}
