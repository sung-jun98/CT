import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] map;
    static int[] direction = new int[] {-1, 1, 2};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[100_001];
        
        Arrays.fill(map, Integer.MAX_VALUE);
        map[N] = 0;
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(N);
        
        while(!queue.isEmpty()){
            int curr = queue.pollFirst();
            
            for(int i = 0; i < 3; i++) {
                int nx = 0;
            
                if(i == 0 || i == 1){
                    nx = curr + direction[i];
                } else {
                    nx = curr * 2;
                }
                
                
                if(isIn(nx) && map[nx] > map[curr] + 1){
                    map[nx] = map[curr] + 1;
                    queue.offerLast(nx);
                    
                }
            }
        }
        
        System.out.println(map[K]);
    }
    
    private static boolean isIn(int x){
        return x >= 0 && x <= 100_000;
    }
}
