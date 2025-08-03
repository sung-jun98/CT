import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String input;
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        for (int i = 0; i < N; i++) {
            int curr = input.charAt(i) - '0';

            answer += curr;
        }

        System.out.println(answer);
    }
}
