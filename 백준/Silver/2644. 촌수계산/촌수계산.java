import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static List<Integer>[] node;
    static int start, end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] line1 = br.readLine().split(" ");
        start = Integer.parseInt(line1[0]);
        end = Integer.parseInt(line1[1]);
        m = Integer.parseInt(br.readLine());

        node = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] line2 = br.readLine().split(" ");
            int start = Integer.parseInt(line2[0]);
            int end = Integer.parseInt(line2[1]);

            node[start].add(end);
            node[end].add(start);

        }

        int answer = bfs(start);
        System.out.println(answer);
    }

    private static int bfs(int start){
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int answer = -1;

        deque.offerLast(new int[]{start, 0});
        visited[start] = true;

        while(!deque.isEmpty()){
            int[] curr = deque.pollFirst();
            int currNode = curr[0];
            int currCost = curr[1];

            if(currNode == end){
                answer = currCost;
                return answer;
            }

            for(int next : node[currNode]){
                if(!visited[next]){
                    visited[next] = true;
                    deque.offerLast(new int[]{next, currCost + 1});
                }
            }
        }

        return answer;
    }
}
