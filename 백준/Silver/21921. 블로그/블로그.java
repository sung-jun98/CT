import java.util.*;
import java.io.*;
/**
1-index
1 4 2 5 1
1 4

*/
public class Main {
    static int N, X;
    static int[] inputs;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        inputs = new int[N + 1];
        
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){            
            inputs[i] = Integer.parseInt(st.nextToken());
            
        }
        
        int window = 0;
        int maxCnt = 1;
        int max = 0;
        for(int i = 1; i <= X; i++){
            window += inputs[i];
        }
        
        max = window;
        
        for(int i = X + 1; i <= N; i++){
            int remove = inputs[i - X];
            int add = inputs[i];
            
            window = window + add - remove;
            
            if(window > max){
                max = window;
                maxCnt = 1;
                
            } else if(window == max){
                maxCnt++;
            }
        }
        
        if(max == 0){
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(maxCnt);
        }
        
    }
}
