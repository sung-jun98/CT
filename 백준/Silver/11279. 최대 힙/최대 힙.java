import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a, b) -> ( b - a));

        for (int i = 0; i < N; i++) {
            int order = Integer.parseInt(br.readLine());
            if (order == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(order);
            }
        }

    }
}
