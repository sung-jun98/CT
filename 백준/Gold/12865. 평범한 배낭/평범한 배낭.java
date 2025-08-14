import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] inputs;
    static int[][] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        inputs = new int[N + 1][2];
        dp = new int[N + 1][K + 1];
        
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            
            inputs[i][0] = Integer.parseInt(st.nextToken());
            inputs[i][1] = Integer.parseInt(st.nextToken());
            
        }
        
        for(int i = 1; i <= N; i++){
            int weight = inputs[i][0];
            int value = inputs[i][1];
            
            for(int j = 0; j <= K; j++){
                dp[i][j] = dp[i - 1][j];
                
                if(j >= weight){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight] + value);
                }
            }
        }
        
        System.out.println(dp[N][K]);
    }
}
