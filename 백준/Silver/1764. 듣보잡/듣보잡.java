import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        
        Set<String> notHeard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            notHeard.add(br.readLine());
        }
        
       
        Set<String> result = new TreeSet<>(); 
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (notHeard.contains(name)) {  
                result.add(name);
            }
        }
        
        // 출력
        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}