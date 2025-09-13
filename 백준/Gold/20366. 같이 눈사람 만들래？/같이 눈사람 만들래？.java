import java.util.*;
import java.io.*;
/**
2 3 4 5 7 9

11 10
12 
*/
public class Main {
    static int N;
    static long[] inputs;
    static long snow1, snow2;
    static long min = Long.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inputs = new long[N];
        for(int i = 0; i < N; i++){
            inputs[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(inputs);
        
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                snow1 = inputs[i] + inputs[j];
                int left = 0;
                int right = N - 1;
                
                while(left < right){
                    if(left == i || left == j){
                        left += 1;
                        continue;
                    }
                    
                    if(right == i || right == j){
                        right -= 1;
                        continue;
                    }
                    
                    snow2 = inputs[left] + inputs[right];
                    min = Math.min(min, Math.abs(snow1 - snow2));
                    
                    if(snow2 > snow1){
                        
                        right -= 1;
                    } else if(snow1 > snow2){
                        
                        left += 1;
                    } else if(snow1 == snow2){
                        System.out.println(0);
                        return ;
                    }
                }
                
            }
            
            
        }
        
        System.out.println(min);
    }
}
