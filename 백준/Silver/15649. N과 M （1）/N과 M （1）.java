import java.util.*;
import java.io.*;

public class Main{
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);


        permute(0, new ArrayList<Integer>(), new boolean[N + 1]);

    }

    private static void permute(int dept, List<Integer> result, boolean[] visited) {
        if (dept == M) {
            for (int answer : result) {
                System.out.print(answer + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {

                result.add(i);
                visited[i] = true;

                permute(dept + 1, result, visited);

                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}
