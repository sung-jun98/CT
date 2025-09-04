import java.util.*;
import java.io.*;
/**
-99 -2 -1 4 98

*/
public class Main {
    static int N;
    static int[] inputs;
    static long minSum = Long.MAX_VALUE;
    static int[] answers;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        answers = new int[2];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(inputs);
        int left = 0;
        int right = N - 1;
        
        while(left < right){
            long sum = inputs[left] + inputs[right];
            
            if(sum > 0){
                
                if(Math.abs(sum) < Math.abs(minSum)){
                    minSum = sum;
                    answers[0] = inputs[left];
                    answers[1] = inputs[right];
                }
                
                right -= 1;
            } else if(sum < 0){
                
                if(Math.abs(sum) < Math.abs(minSum)){
                    minSum = sum;
                    answers[0] = inputs[left];
                    answers[1] = inputs[right];
                }
                
                left += 1;
            } else {
                System.out.println(inputs[left] + " " + inputs[right]);
                return ;
            }
            
        }
        
        System.out.println(answers[0] + " " + answers[1]);
    }
    
    
}
