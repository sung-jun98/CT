import java.util.*;
import java.io.*;
/**
2 1 1 0
1 1 0 1
*/
public class Main {
    static int T;
    static int input;
    static long[] dp0;
    static long[] dp1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        dp0 = new long[41];
        dp1 = new long[41];
        
        //Arrays.fill(dp0, -1L);
        //Arrays.fill(dp1, -1L);
        dp0[0] = 1;
        dp0[1] = 0;
        dp1[0] = 0;
        dp1[1] = 1;
        
        for(int i = 2; i <= 40; i++){
            dp0[i] = dp0[i - 1] + dp0[i - 2];
            dp1[i] = dp1[i - 1] + dp1[i - 2];
            
        }
        
        for(int t = 1; t <= T; t++){
            input = Integer.parseInt(br.readLine());
            System.out.print(dp0[input] + " " + dp1[input]);
            System.out.println();
        }
    }
    
    
}
