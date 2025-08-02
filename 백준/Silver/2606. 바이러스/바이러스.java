import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<List<Integer>> inputs;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        inputs = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            inputs.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            inputs.get(a).add(b);
            inputs.get(b).add(a);
        }

        answer = bfs(1, new boolean[N + 1]);

        System.out.println(answer);
    }

    private static int bfs(int start, boolean[] visited) {

        Deque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offerLast(start);
        int cnt = 0;

        while (!queue.isEmpty()) {
            int curr = queue.pollFirst();

            for (int next : inputs.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt += 1;
                    queue.offerLast(next);
                }
            }
        }

        return cnt;
    }
}
