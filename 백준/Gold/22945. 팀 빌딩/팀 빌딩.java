import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] inputs;
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        answer = Integer.MIN_VALUE;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        
        
        int left = 0;
        int right = N - 1;
        
        while(left < right){
            int sum = (right - left - 1) * Math.min(inputs[left], inputs[right]);
            answer = Math.max(answer, sum);
                
            int min = Math.min(inputs[left], inputs[right]);
            if(inputs[left] == min){
                left += 1;
            } else {
                right -= 1;
            }
        }
        
        
        System.out.println(answer);
    }
}
