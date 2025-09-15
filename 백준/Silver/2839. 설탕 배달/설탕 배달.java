import java.util.*;
import java.io.*;
/**
1 2 3 4 5 6 7 8 9
0 0 1 0 1 2 0 2 
*/
public class Main {
    static int N;
    static int[] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[5001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[3] = 1;
        dp[5] = 1;
        
        for(int i = 6; i <= N; i++){   
            if(dp[i - 3] != Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }  
            
            if(dp[i- 5] != Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }   
            
            
        }
        
        if(dp[N] == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}
