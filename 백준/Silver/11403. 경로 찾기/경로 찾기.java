import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] inputs;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < N; j++){
                inputs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(inputs[i][k] != 0 && inputs[k][j] != 0){
                        
                        inputs[i][j] = 1;
                        
                    }
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(inputs[i][j] + " ");
            }
            System.out.println();
        }
    }
}
