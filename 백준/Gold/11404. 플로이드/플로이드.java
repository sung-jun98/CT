import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] inputs;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        inputs = new int[n + 1][n + 1];
        
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == j){
                    inputs[i][j] = 0;
                } else{
                    inputs[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            st =  new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            inputs[from][to] = Math.min(inputs[from][to], cost);
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(inputs[i][k] != Integer.MAX_VALUE && inputs[k][j] != Integer.MAX_VALUE){
                        inputs[i][j] = Math.min(inputs[i][k] + inputs[k][j], inputs[i][j]);
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(inputs[i][j] == Integer.MAX_VALUE){
                    System.out.print(0 + " ");
                } else{
                    System.out.print(inputs[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
