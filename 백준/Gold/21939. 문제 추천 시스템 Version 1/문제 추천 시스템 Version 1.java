import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static TreeSet<Problem> set;
    static Map<Integer, Problem> map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        set = new TreeSet<>((a, b) -> {
            if(a.hard == b.hard){
              return Integer.compare(b.num, a.num);  
            }
            
            return Integer.compare(b.hard, a.hard);
        } );
        map = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int hard = Integer.parseInt(st.nextToken());
            
            Problem problem = new Problem(num, hard);
            set.add(problem);
            map.put(num, problem);
        }
        
        M = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            
            if(comm.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                int hard = Integer.parseInt(st.nextToken());
                
                Problem problem = new Problem(num, hard);
                set.add(problem);
                
            } else if(comm.equals("recommend")){
                int num = Integer.parseInt(st.nextToken());
                
                if(num == 1){
                    sb.append(set.first().num).append('\n');
                    
                } else if(num == -1){
                    sb.append(set.last().num).append('\n');
                }
                
            } else if(comm.equals("solved")){
                int num = Integer.parseInt(st.nextToken());
                
                Problem searched = map.get(num);
                
                if(searched != null){
                    set.remove(searched);
                    map.remove(num);
                }
            }
        }
        
        System.out.println(sb.toString());
    }
    
    static class Problem {
        int num;
        int hard;
        
        Problem(int num, int hard){
            this.num = num;
            this.hard = hard;
        }
    }
}
