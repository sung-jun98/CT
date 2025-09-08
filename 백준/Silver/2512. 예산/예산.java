import java.util.*;
import java.io.*;

public class Main {
    static int N, total;
    static int[] inputs;
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, inputs[i]);
        }
        
        total = Integer.parseInt(br.readLine());
        answer = 0;
        Arrays.sort(inputs);
        
        int left = 0;
        int right = max;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(getSum(mid) <= total){
                answer = mid;
                left = mid + 1;
                
            } else {
                right = mid - 1;
                
            }
        }
        
        System.out.println(answer);
        
    }
    
    private static int getSum(int money){
        int sum = 0;
        for(int i = 0; i < N; i++){
            if(inputs[i] > money){
                sum += money;
            } else {
                sum += inputs[i];
            }
            
        }
        
        return sum;
    }
}
