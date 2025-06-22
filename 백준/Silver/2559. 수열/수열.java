import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] inputs;
    static int[] arrSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        inputs = new int[N];
        arrSum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        arrSum[0] = inputs[0];

        for (int i = 1; i < N; i++) {
            arrSum[i] = arrSum[i - 1] + inputs[i];
        }

        int answer = Integer.MIN_VALUE;

        for (int i = K - 1; i < N; i++) {
            int tmpSum;
            if(i - K < 0){
                tmpSum = arrSum[i];
            } else{
                tmpSum = arrSum[i] - arrSum[i - K];
            }

            answer = Math.max(answer, tmpSum);
        }

        System.out.println(answer);

    }
}
