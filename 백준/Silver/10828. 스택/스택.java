import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static Deque<Integer> deque;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int num = 0;

            switch (inputs[0]) {
                case "push":
                    num = Integer.parseInt(inputs[1]);
                    deque.offerLast(num);

                    break;
                case "top":
                    if (deque.isEmpty()) {
                        num = -1;
                        System.out.println(num);
                    } else {
                        num = deque.peekLast();
                        System.out.println(num);
                    }

                    break;
                case "pop":
                    if (deque.isEmpty()) {
                        num = -1;
                    } else {
                        num = deque.pollLast();
                    }
                    System.out.println(num);

                    break;
                case "size":
                    num = deque.size();

                    System.out.println(num);
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }

                    break;
            }
        }
    }
}
