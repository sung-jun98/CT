import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[] inputs, targets;
    static List<Integer> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        answer = new ArrayList<>();

        String[] line1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(line1[i]);
        }

        M = Integer.parseInt(br.readLine());
        targets = new int[M];
        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(line2[i]);
        }

        Arrays.sort(inputs);
        for (int i = 0; i < M; i++) {
            int upper = upperBound(targets[i]);
            int lower = lowerBound(targets[i]);
            int count = upper - lower;

            sb.append(count);
            if(i < M - 1){
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    private static int upperBound(int target) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (inputs[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int lowerBound(int target) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (inputs[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
