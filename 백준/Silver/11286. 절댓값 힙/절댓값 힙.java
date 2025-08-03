import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Map<Integer, Integer> map;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    int val = pq.poll();
                    int negVal = -1 * val;

                    if (map.containsKey(negVal)) {
                        System.out.println(negVal);

                        map.put(negVal, map.get(negVal) - 1);

                        if (map.get(negVal) == 0) {
                            map.remove(negVal);
                        }

                    } else if (map.containsKey(val)) {
                        System.out.println(val);

                        map.put(val, map.get(val) - 1);

                        if (map.get(val) == 0) {
                            map.remove(val);
                        }
                    }
                }

            } else {
                map.put(input, map.getOrDefault(input, 0) + 1);
                int absInput = Math.abs(input);
                pq.offer(absInput);

            }

        }
    }
}
