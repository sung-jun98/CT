import java.util.*;
import java.io.*;
/**
1 2 4 6 9
1 2 3 4 5 6 12 
*/
public class Main {
    static long N, K;
    
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        
        long left = 0;
        long right = N - 1;
        
        while(left <= right){
            long mid = left + (right - left) / 2;
            long cand = (mid + 1) * (N - mid + 1);
            
            if(cand == K){
                System.out.println("YES");
                return ;
                
            } else if(cand < K){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println("NO");
    }
}
