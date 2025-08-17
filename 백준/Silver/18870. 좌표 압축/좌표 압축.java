import java.util.*;
import java.io.*;
/**
1. inputs 정렬
2. Map (인덱스 : 순위)로 저장
3. answer 채워넣기


*/
public class Main {
    static int N;
    static int[] inputs;
    static int[] answer;
    static Map<Integer, Integer> map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        answer = new int[N];
        map = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        int[] sortedInputs = inputs.clone();
        Arrays.sort(sortedInputs);
        
        int rank = 0;
        map.put(sortedInputs[0], rank);
        for(int i = 1; i < N; i++){
            if(sortedInputs[i] != sortedInputs[i - 1]){
                rank += 1;
                map.put(sortedInputs[i], rank);
            } 
        }
        
        for(int i = 0; i < N; i++){
            int tmp = map.get(inputs[i]);
            answer[i] = tmp;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(answer[i]).append(" ");
            
        }
        
        System.out.println(sb.toString());
    }
}
