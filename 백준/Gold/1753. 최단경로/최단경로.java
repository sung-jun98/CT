import java.util.*;
import java.io.*;

public class Main{
    static int V, E;
    static int K;
    static List<List<Node1753>> nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        V = Integer.parseInt(line1[0]);
        E = Integer.parseInt(line1[1]);
        K = Integer.parseInt(br.readLine());

        nodes = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] line2 = br.readLine().split(" ");
            int u = Integer.parseInt(line2[0]);
            int v = Integer.parseInt(line2[1]);
            int w = Integer.parseInt(line2[2]);

            Node1753 node = new Node1753(v, w);
            nodes.get(u).add(node);
        }

        int[] dist = new int[V + 1];
        dist = dijikstra1753(K);

        for (int i = 1; i <= V; i++) {
            int answer = dist[i];

            if (answer == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(answer);
            }
        }
    }

    private static int[] dijikstra1753(int start) {
        PriorityQueue<Node1753> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        pq.offer(new Node1753(start, 0));

        while (!pq.isEmpty()) {
            Node1753 curr = pq.poll();
            int end = curr.end;
            int currWeight = curr.weight;

            if (visited[end]) {
                continue;
            }
            visited[end] = true;

            for (Node1753 next : nodes.get(end)) {
                int nextEnd = next.end;
                int nextWeight = next.weight;

                if (!visited[nextEnd] && dist[end] + nextWeight < dist[nextEnd]) {
                    dist[nextEnd] = dist[end] + nextWeight;
                    pq.offer(new Node1753(nextEnd, dist[nextEnd]));
                }
            }
        }

        return dist;
    }

    private static class Node1753 {
        int end;
        int weight;

        Node1753(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
