import java.util.*;
import java.io.*;
/**
0 1 2 3 4 5 6 7 8 9 10 20 21 30 31 32 40 41 42 43 50 51 52 53 54 
*/
public class Main {
    static int N;
    static List<Long> possible = new ArrayList<>();
    static int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dfs(0, 0);
        
        Collections.sort(possible);
        
        try {
            System.out.println(possible.get(N - 1));    
        } catch(Exception e){
            System.out.println(-1);
        }
    }
    
    private static void dfs(int pos, long curr){
        if(!possible.contains(curr)){
            possible.add(curr);
        }
        
        if(pos >= 10){
            return ;
        }
        
        
        long next = curr * 10 + arr[pos];
        // 선택할때
        dfs(pos + 1, next);
        // 선택하지 않을때
        dfs(pos + 1, curr);
        
    }
}
