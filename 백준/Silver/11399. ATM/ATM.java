import java.util.*;
import java.io.*;

/**
 * 1 2 3 3 4
 * 1 3 6 9 13
 *
 *
 */
public class Main {
    static int N;
    static int[] time;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N];
        answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += time[i];
            answer += sum;
        }

        System.out.println(answer);

    }
}
