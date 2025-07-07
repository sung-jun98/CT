import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static Deque<Character> deque;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        flag:
        for (int t = 1; t <= T; t++) {
            deque = new ArrayDeque<>();
            String line2 = br.readLine();

            for (int i = 0; i < line2.length(); i++) {
                char input = line2.charAt(i);

                if (input == '(') {
                    deque.offerLast(input);

                } else if (input == ')') {
                    if (deque.isEmpty()) {
                        System.out.println("NO");
                        continue flag;
                    }

                    deque.pollLast();
                }
            }

            if (deque.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
