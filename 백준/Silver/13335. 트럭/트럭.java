import java.util.*;
import java.io.*;

public class Main {
    static int n, w, L;
    static Deque<Integer> trucks;
    static Deque<Integer> bridge;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        w = Integer.parseInt(line1[1]);
        L = Integer.parseInt(line1[2]);

        trucks = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int truckWeight = Integer.parseInt(st.nextToken());
            trucks.offerLast(truckWeight);
        }

        bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            bridge.offerLast(0);
        }

        int time = 0;
        int currWeight = 0;

        while (!trucks.isEmpty() || currWeight > 0) {
            time += 1;
            int exitTruck = bridge.pollFirst();
            currWeight -= exitTruck;

            if (!trucks.isEmpty()) {
                int nextTruck = trucks.peekFirst();

                if (currWeight + nextTruck <= L) {
                    trucks.pollFirst();
                    bridge.offerLast(nextTruck);
                    currWeight += nextTruck;
                } else {
                    bridge.offerLast(0);
                }
            } else {
                bridge.offerLast(0);
            }
        }

        System.out.println(time);
    }
}
