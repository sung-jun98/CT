import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] inputs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inputs = new int[N];

        int max = Integer.MIN_VALUE;
        int totalSum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, inputs[i]);
            totalSum += inputs[i];
        }

        int left = max;
        int right = totalSum;
        int mid = totalSum;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (calc(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private static boolean calc(int capacity) {
        int box = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if ((sum + inputs[i]) > capacity) {
                sum = inputs[i];
                box += 1;
                if (box > M) {
                    return false;
                }
            } else {
                sum += inputs[i];
            }
        }


        return true;

    }
}
