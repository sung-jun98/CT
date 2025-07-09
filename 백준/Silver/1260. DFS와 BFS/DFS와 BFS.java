import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static List<Integer> bfsAnswer, dfsAnswer;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        N = Integer.parseInt(line1[0]);
        M = Integer.parseInt(line1[1]);
        V = Integer.parseInt(line1[2]);

        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        bfsAnswer = new ArrayList<>();
        dfsAnswer = new ArrayList<>();
        dfsAnswer.add(V);

        for (int i = 0; i < M; i++) {
            String[] line2 = br.readLine().split(" ");

            int start = Integer.parseInt(line2[0]);
            int end = Integer.parseInt(line2[1]);

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        bfs(V);
        dfs(V, new boolean[N + 1]);

        for (int answer : dfsAnswer) {
            System.out.print(answer + " ");
        }

        System.out.println();

        for (int answer : bfsAnswer) {
            System.out.print(answer + " ");
        }

    }

    private static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        bfsAnswer.add(start);

        deque.offerLast(start);

        while (!deque.isEmpty()) {
            int curr = deque.pollFirst();

            for (int next : graph[curr]) {
                if (!visited[next]) {
                    bfsAnswer.add(next);
                    visited[next] = true;
                    deque.offerLast(next);
                }
            }
        }

    }

    private static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        List<Integer> nextList = graph[node];

        for (int nextNode : nextList) {
            if (!visited[nextNode]) {
                dfsAnswer.add(nextNode);
                dfs(nextNode, visited);
            }
        }
    }
}
