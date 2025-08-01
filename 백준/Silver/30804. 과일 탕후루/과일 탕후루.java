import java.util.*;
import java.io.*;

/**
 *
 */
public class Main {
    static int N;
    static int[] inputs;
    static Map<Integer, Integer> fruitCnt;
    static int kindCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        fruitCnt = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int maxCnt = Integer.MIN_VALUE;
        for (int right = 0; right < N; right++) {
            fruitCnt.put(inputs[right], fruitCnt.getOrDefault(inputs[right], 0) + 1);

            if (fruitCnt.size() > 2) {

                fruitCnt.put(inputs[left], fruitCnt.get(inputs[left]) - 1);

                if (fruitCnt.get(inputs[left]) == 0) {
                    fruitCnt.remove(inputs[left]);
                }
                left += 1;
            }

            maxCnt = Math.max(maxCnt, right - left + 1);
        }
        System.out.println(maxCnt);
    }
}
