import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[][] dists;
    static Set<Character> usedChar;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dists = new boolean[128][128];
        usedChar = new TreeSet<>();
        
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            char from = input.charAt(0);
            char to = input.charAt(5);
            
            dists[from][to] = true;
            usedChar.add(from);
            usedChar.add(to);
        }
        
        for(int k = 0; k < 128; k++){
            for(int i = 0; i < 128; i++){
                for(int j = 0; j < 128; j++){
                    if(dists[i][k] && dists[k][j]){
                        dists[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(char curr : usedChar){
            for(char next : usedChar){
                if(dists[curr][next] && curr != next){
                    answer += 1;
                    sb.append(curr).append(" => ").append(next).append('\n');
                }
            }
        }
        System.out.println(answer);
        System.out.println(sb.toString());
    }
}
