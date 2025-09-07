import java.util.*;
import java.io.*;
/**
2 -5 2 3 -4 7 -4 0 1 -6
-6 -5 -4 -4 0 1 2 2 3 7
*/
public class Main {
    static int N;
    static int[] inputs;
    static long answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        inputs = new int[N];
        answer = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(inputs);
        
        
        for(int left = 0; left < N - 2; left++){
            for(int right = left + 1; right <= N - 2; right++){
                int target = -1 * (inputs[left] + inputs[right]);
                
                if(right + 1 >= N){
                    continue;
                }
                
                int start = lowerBound(right + 1, N, target);
                int end = upperBound(right + 1, N, target);
                
                answer += (end - start);
                
            }
        }
        
        System.out.println(answer);
    }
    
    private static int lowerBound(int left, int right, int target){
        
        // lower bound
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(inputs[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private static int upperBound(int left, int right, int target){
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(inputs[mid] <= target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
