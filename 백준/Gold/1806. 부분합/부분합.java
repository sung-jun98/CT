import java.util.*;
import java.io.*;

public class Main {
    static int N, S;
    static int[] inputs;
    
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        inputs = new int[N];
        answer = Integer.MAX_VALUE;
        
        st = new StringTokenizer(br.readLine());
        inputs[0] = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int sum = 0;
        
        for(int right = 0; right < N; right++){
            sum += inputs[right];
            
            while(sum >= S){
                answer = Math.min(answer, right - left + 1);
                sum -= inputs[left];
                left += 1;
            }
        }
        
        if(answer == Integer.MAX_VALUE){
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
        
    }
}
