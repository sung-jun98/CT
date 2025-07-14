import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);

        time = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        // init end

        if (m == 0) {
            System.out.println(0);
            return;
        }
        long answer = slidingWindow(m);
        System.out.println(answer);
    }

    private static long slidingWindow(int m) {
        int left = 1;
        int right = m;
        long windowSum = 0;


        for (int i = left; i <= right; i++) {
            windowSum += time[i];
        }

        long maxSum = windowSum;

        for (int i = right + 1; i <= n; i++) {
            int leftPoint = i - m;
            int rightPoint = i;

            windowSum -= time[leftPoint];
            windowSum += time[rightPoint];

            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        return maxSum;
    }
}
