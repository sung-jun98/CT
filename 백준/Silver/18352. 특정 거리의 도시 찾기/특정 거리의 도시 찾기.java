import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, X;
    static int[] results;
    static boolean[] visited;
    //static PriorityQueue<Integer> pq;
    static List<List<Integer>> nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        N = Integer.parseInt(line1[0]);
        M = Integer.parseInt(line1[1]);
        K = Integer.parseInt(line1[2]);
        X = Integer.parseInt(line1[3]);

        nodes = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            nodes.get(start).add(end);
        }

        int[] dist = dijikstra(X);
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            if(dist[i] == K){
                answer.add(i);
            }
        }

        if(answer.isEmpty()){
            System.out.println(-1);
            return ;
        }

        Collections.sort(answer);
        for(int tmp : answer){
            System.out.println(tmp);
        }

    }

    private static int[] dijikstra(int start) {
        results = new int[N + 1];
        Arrays.fill(results, Integer.MAX_VALUE);
        results[start] = 0;

        visited = new boolean[N + 1];


        Queue<Integer> queue = new ArrayDeque<>(); // 원래 다익스트라에서는 pq를 써야 하지만, 여기서는 가중치가 다 1이니까 PQ가 아니라 ArrayDeque로 푼다.
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if(visited[now]){
                continue;
            }
            visited[now] = true;

            for (int next : nodes.get(now)) {
                if (results[now] + 1 < results[next]) {
                    results[next] = results[now] + 1;
                    queue.offer(next);
                }
            }
        }

        return results;
    }
}
