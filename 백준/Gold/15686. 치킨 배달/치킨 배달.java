import java.util.*;
import java.io.*;

/**
 * 깊게 생각 안하고 좌표를 보자마자 그래프 문제라고 생각한게 실수.
 * 조합도 어렵고 1년동안 난 성장을 아예 안했구나
 */
public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> chickens;
    static List<int[]> people;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        N = Integer.parseInt(line1[0]);
        M = Integer.parseInt(line1[1]);

        chickens = new ArrayList<>();
        people = new ArrayList<>();

        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String[] line2 = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(line2[j]);
                if (input == 1) {
                    people.add(new int[]{i, j});
                } else if (input == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0, new boolean[chickens.size()]);

        System.out.println(answer);
    }

    private static void dfs(int start, int choose, boolean[] visited) {
        if (choose == M) {
            int distSum = 0;
            for (int i = 0; i < people.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                int[] person = people.get(i);
                int px = person[0];
                int py = person[1];

                for (int j = 0; j < chickens.size(); j++) {
                    if (visited[j]) {
                        int[] chicken = chickens.get(j);
                        int cx = chicken[0];
                        int cy = chicken[1];

                        int dist = Math.abs(px - cx) + Math.abs(py - cy);
                        tmp = Math.min(tmp, dist);
                    }
                }

                distSum += tmp;
            }

            answer = Math.min(distSum, answer);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            dfs(i + 1, choose + 1, visited);
            visited[i] = false;
        }
    }
}