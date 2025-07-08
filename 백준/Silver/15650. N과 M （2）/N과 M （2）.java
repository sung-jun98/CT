import java.util.*;
import java.io.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        permute(1, new ArrayList<Integer>(), 0);

    }

    private static void permute(int start, List<Integer> result, int selected) {
        if (selected == M) {
            for (int answer : result) {
                System.out.print(answer + " ");
            }
            System.out.println();

            return;
        }

        for (int i = start; i <= N; i++) {
            result.add(i);
            permute(i + 1, result, selected + 1);
            result.remove(result.size() - 1);
        }
    }
}
