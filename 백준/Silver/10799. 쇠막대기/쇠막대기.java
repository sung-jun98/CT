import java.util.*;
import java.io.*;

public class Main {
    static Deque<Character> stack;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        char[] input = line1.toCharArray();

        stack = new ArrayDeque<>();
        boolean flag = false;

        for(char curr : input){
            if(curr == '('){
                stack.offerLast('(');
                flag = true;

            } else if(curr == ')'){
                if(flag) { // 레이저일시
                    stack.pollLast();
                    answer += stack.size();
                    flag = false;
                    continue;
                }

                stack.pollLast(); //레이저가 아닐시
                answer += 1;
            }
        }

        System.out.println(answer);


    }
}
