import java.util.*;
import java.io.*;
/**
1 1 -> 1
2 1^2 + 1^2 -> 1
3 1^2 + 1^2 + 1^2 -> 3
4 2^2 -> 1
5 2^2 + 1^2 -> 2
6 2^2 + 1^2 + 1^2 -> 3
7 2^2 + 1^2 + 1^2 + 1^2 -> 4
8 2^2 + 2^2 -> 2
9 3^2 -> 1
10 
*/
public class Main {
    static int N;
    static int[] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[50_001];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i < 50_001; i++){
            int min = Integer.MAX_VALUE;
            
            for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - j * j]);
			}
			dp[i] = min + 1;

        }
        
        System.out.println(dp[N]);
    }
}
