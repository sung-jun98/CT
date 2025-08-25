import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] inputs;
    static List<Character> set;
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new String[N];
        answer = 0;
        set = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            inputs[i] = br.readLine();
        }
        
        for(int i = 0; i < N; i++){
            set = new ArrayList<>();
            String sentence = inputs[i];
            set.add(sentence.charAt(0));
            char prev = set.get(0);
            boolean flag = true;
            
            for(int j = 1; j < sentence.length(); j++){
                char curr = sentence.charAt(j);
                if(set.contains(curr)){
                    if(prev == curr){
                        continue;
                    } else{
                        flag = false;
                        break;
                    }
                } else {
                    set.add(curr);
                    prev = curr;
                }
                
            }
            
            if(flag){
                answer += 1;
            }
        }
        
        System.out.println(answer);
    }
}
