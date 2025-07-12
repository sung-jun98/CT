import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static long[] inputs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        K = Integer.parseInt(line1[0]);
        N = Integer.parseInt(line1[1]);

        inputs = new long[K];
        for (int i = 0; i < K; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        long answer = binarySearch();
        System.out.println(answer);

    }

    private static long binarySearch() {

        long max = Long.MIN_VALUE;
        for (long tmp : inputs) {
            if (tmp > max) {
                max = tmp;
            }
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long calcResult = calc(mid);

            if (calcResult < N) {
                right = mid - 1;

            } else {
                result = mid;
                left = mid + 1;

            }
        }

        return result;
    }

    private static int calc(long len) {
        int sum  = 0;

        for(long tree : inputs){
            long rest = tree / len;
            sum += rest;
        }

        return sum;
    }
}
