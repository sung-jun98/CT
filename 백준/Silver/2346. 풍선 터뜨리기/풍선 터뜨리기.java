import java.io.*;
import java.util.*;

/**
 * 1 2 3 4 5
 * 2 3 4 5
 * 3 4 5 2
 * 4 5 2 3
 * 5 2 3 (1, 4)
 * 3 5 2
 * 2 3 5
 * 2 3 (1, 4, 5)
 * 2 (1, 4, 5, 3)
 */
public class Main {
    static int N;
    static int[] inputs;
    static Deque<Integer> deque;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        inputs = new int[N + 1];


        String[] line2 = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            inputs[i] = Integer.parseInt(line2[i - 1]);
        }

        deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }


        sb.append(deque.pollFirst()).append(" ");
        int next = inputs[1];
        int cnt = 0;

        while (deque.size() != 1) {
            int poll = 0;
            if (next > 0) {
                for (int i = 0; i < next; i++) {
                    poll = deque.pollFirst();

                    if (i != next - 1)
                        deque.offerLast(poll);
                }
            } else {
                for (int i = 0; i < next * -1; i++) {
                    poll = deque.pollLast();

                    if (i != (next * -1) - 1) {
                        deque.offerFirst(poll);
                    }
                }
            }

            next = inputs[poll];

            sb.append(poll).append(" ");

        }


        sb.append(deque.pollFirst()).append(" ");
        
        System.out.println(sb.toString());

    }
}
