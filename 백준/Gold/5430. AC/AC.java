import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static Deque<Integer> deque;
    static boolean isReverse;
    static String answer;
    
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            deque = new ArrayDeque<>();
            isReverse = false;
            StringBuilder sb = new StringBuilder();
            
            String[] func = br.readLine().split("");
            int len = Integer.parseInt(br.readLine());
            String inputLine = br.readLine();
            boolean isError = false;
            
            if(len > 0){
                String[] input = inputLine.replace("[", "").replace("]", "").split(",");
                
                for(int i = 0; i < len; i++){
                    deque.offerLast(Integer.parseInt(input[i]));
                }
            }
            
            
           
            for(String order : func){
                if(order.equals("R")){
                    
                    if(isReverse){
                        isReverse = false;
                    } else{
                        isReverse = true;
                    }
                    
                } else if(order.equals("D")){
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }
                    
                    if(isReverse){ // 오른쪽 버리기
                        deque.pollLast();
                    } else { // 왼쪽 버리기
                        deque.pollFirst();
                    }
                    
                }
            }
            
            if(isError){
                sb.append("error");
                
            } else if(!isReverse) {
                sb.append("[");
                while(!deque.isEmpty()){
                    sb.append(deque.pollFirst());
                    if(!deque.isEmpty()){
                        sb.append(",");
                    }
                }
                
                sb.append("]");
            } else if(isReverse){
                sb.append("[");
                while(!deque.isEmpty()){
                    sb.append(deque.pollLast());
                    if(!deque.isEmpty()){
                        sb.append(",");
                    }
                }
                
                sb.append("]");
            }
            
            System.out.println(sb.toString());
        }

    }
}
