import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] count;
    static List<String> result;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            count = new int[26];
            result = new ArrayList<>();
            char[] converted = input.toCharArray();
            
            for(char curr : converted){
                count[curr - 'a'] += 1;
            }
            
            dfs(input, new StringBuilder());
            
            Collections.sort(result);
        
            for(int j = 0; j < result.size(); j++){
                System.out.println(result.get(j));
            }
        }
        
        
    }
    
   private static void dfs(String input, StringBuilder sb){
        if(sb.length() == input.length()){
            result.add(sb.toString());
            
            return ;
        }
    
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                count[i]--;
                sb.append((char)('a' + i));
                
                dfs(input, sb);
                
                sb.deleteCharAt(sb.length() - 1);
                count[i]++;
            }
        }
        
        
        
    }
}
