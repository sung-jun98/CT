import java.util.*;
import java.io.*;

public class Main {
    static int N, d, k, c;
    static int[] dishes;
    static int max, answer;
    static boolean flag;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        dishes = new int[N];
         
        for(int i = 0; i < N; i++){
            dishes[i] = Integer.parseInt(br.readLine());
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        int types = 0;
        
        for(int i = 0; i < k; i++){
            int prev = count.getOrDefault(dishes[i], 0);
            if(prev == 0){
                types += 1;
            }
            
            count.put(dishes[i], prev + 1);
        }
        
        int maxTypes = types;
        if(count.getOrDefault(c, 0) == 0){
            maxTypes += 1;
        }
        
        for(int start = 1; start < N; start++){
           // 이전 시작점 제거
            int oldStart = dishes[start - 1];
            count.put(oldStart, count.get(oldStart) - 1);
            if(count.get(oldStart) == 0){
                count.remove(oldStart);
                types -= 1;
            }
            
            // 끝점 추가
            int newEnd = dishes[(start + k - 1) % N];
            int prev = count.getOrDefault(newEnd, 0);
            
            if(prev == 0){
                types += 1;
            }
            count.put(newEnd, prev + 1);
            
            int currentMax = types;
            if(count.getOrDefault(c, 0) == 0){
                currentMax += 1;
            }
        
            maxTypes = Math.max(maxTypes, currentMax);
        }
        
        System.out.println(maxTypes);
    }
}
