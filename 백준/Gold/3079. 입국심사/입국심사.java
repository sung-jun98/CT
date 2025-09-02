import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long[] times;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        times = new long[N];
        long minTime = Long.MAX_VALUE;
        
        for(int i = 0; i < N; i++){
            times[i] = Integer.parseInt(br.readLine());
            minTime = Math.min(minTime, times[i]);
        }
        
        long left = 1L; 
        long right = minTime * M;
        
        while(left < right){
            long mid = left + (right - left) / 2;
            
            
            if(canFit(mid)){
                right = mid;
                
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(right);
    }
    
    private static boolean canFit(long fitTime){
        long totalPpl = 0;
        for(int i = 0; i < N; i++){
            totalPpl += (fitTime / times[i]);
            if(totalPpl >= M){
                return true;
            }
        }
        
        return false;
    }
}
