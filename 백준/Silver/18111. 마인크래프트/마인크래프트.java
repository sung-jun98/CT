import java.util.*;
import java.io.*;

public class Main {
    static int N, M, B;
    static int[][] inputs;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] answers;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        inputs = new int[N][M];
        answers = new int[2];
        answers[0] = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                inputs[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, inputs[i][j]);
                max = Math.max(max, inputs[i][j]);
            }
        }
        
        for(int height = min; height <= max; height++){
            int pocket = B;
            int removedBlock = 0; 
            int neededBlock = 0; 
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    int curr = inputs[i][j];
                    if(height > curr){
                        neededBlock += (height - curr);
                        
                    } else if(height < curr){
                        removedBlock += (curr - height);
                    }
                }
            }
            
            if(removedBlock + pocket < neededBlock){
                continue;
            } else {
                int time = neededBlock + 2 * removedBlock;
                
                if(answers[0] > time){
                    answers[0] = time;
                    answers[1] = height;
                    
                } else if(answers[0] == time && answers[1] < height){
                    answers[1] = height;
                }
            }
        }
        
        System.out.println(answers[0] + " " + answers[1]);
        
        
    }
}
