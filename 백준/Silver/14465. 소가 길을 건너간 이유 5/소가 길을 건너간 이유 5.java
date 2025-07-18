import java.util.*;
import java.io.*;

public class Main {
    static int N, K, B;
    static int[] inputs;
    static int[] arr;
    static boolean[] lights;
    static int brokeCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        inputs = new int[B];
        arr = new int[N + 1];
        lights = new boolean[N + 1];

        for (int i = 0; i < B; i++) {
            int brokenLight = Integer.parseInt(br.readLine());
            lights[brokenLight] = true;
        }

        if (lights[0]) {
            arr[0] = 1;
            brokeCount += 1;
        } else {
            arr[0] = 0;
        }

        for (int i = 1; i <= K; i++) {
            if (lights[i]) {
                brokeCount += 1;
            }
        }

        int minRepairs = brokeCount;

        // 슬라이딩 윈도우
        for (int i = K + 1; i <= N; i++) {
            int remove = i - K;
            int add = i;

            if (lights[remove]) {
                brokeCount -= 1;
            }

            if (lights[add]) {
                brokeCount += 1;
            }

            minRepairs = Math.min(minRepairs, brokeCount);
        }


        System.out.println(minRepairs);
    }
}
