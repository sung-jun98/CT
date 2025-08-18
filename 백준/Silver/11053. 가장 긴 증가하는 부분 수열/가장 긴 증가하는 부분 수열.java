import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] inputs;
    static int[] dp;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        inputs = new int[N];
        
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(inputs[j] < inputs[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < N; i++){
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(answer);
    }
}
