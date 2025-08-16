import java.util.*;
import java.io.*;

public class Main {
    static String input;
    static String target;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        target = br.readLine();
        sb = new StringBuilder();
        
        for(int i = 0; i < input.length(); i++){
            sb.append(input.charAt(i));
            if(sb.length() >= target.length()){
                int start = sb.length() - target.length();
                boolean flag = true;
                
                for(int j = 0; j < target.length(); j++){
                    if(sb.charAt(start + j) != target.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                
                if(flag){
                   sb.delete(start, sb.length()); 
                }
                
            }
        }
        
        if(sb.length() == 0){
            System.out.println("FRULA");
        } else{
            System.out.print(sb.toString());
        }
    }
}
