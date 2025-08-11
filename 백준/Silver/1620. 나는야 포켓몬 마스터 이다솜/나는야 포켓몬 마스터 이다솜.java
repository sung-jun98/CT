import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static Map<String, Integer> stringMap;
    static Map<Integer, String> intMap;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        stringMap = new HashMap<>();
        intMap = new HashMap<>();
        
        for(int i = 1; i <= N; i++){
            String input = br.readLine();
            stringMap.put(input, i);
            intMap.put(i, input);
            
        }
        
        for(int i = 0; i < M; i++){
            String input = br.readLine();
            
            if(isInt(input)){
                String answer = intMap.get(Integer.parseInt(input));
                System.out.println(answer);
            } else {
                int answer = stringMap.get(input);
                System.out.println(answer);
            }
        }
        
    }
    
    private static boolean isInt(String input){
        try {
            Integer.parseInt(input);
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
}
