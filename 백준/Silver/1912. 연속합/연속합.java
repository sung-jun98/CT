import java.util.*;
import java.io.*;
/**
O (선택했을때는 이전의 O값 + 현재 || 현재)
X (선택안했을때는 직전의 OX중 max)
*/
public class Main {
    static int N;
    static int[] inputs;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        dp = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }   
        
        dp[0][0] = inputs[0];
        dp[0][1] = inputs[0];
        
        for(int i = 1; i < N; i++){
            dp[i][0] = Math.max(dp[i - 1][0] + inputs[i], inputs[i]);
            dp[i][1] = Math.max(dp[i][0], dp[i - 1][1]);
            
        }
        
        System.out.println(dp[N - 1][1]);
    }
}
