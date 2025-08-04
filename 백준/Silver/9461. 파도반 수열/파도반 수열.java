import java.util.*;
import java.io.*;

/**
 * 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
 * func(6) == 3 (1-index)
 */
public class Main {
    static int T;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        dp = new long[100 + 1];
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        for (int t = 0; t < T; t++) {
            int input = Integer.parseInt(br.readLine());
            long result = func(input);
            sb.append(result).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static long func(int input) {
        if (dp[input] == 0) {
            dp[input] = func(input - 2) + func(input - 3);
        }

        return dp[input];
    }
}
