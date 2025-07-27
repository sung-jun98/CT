import java.util.*;
import java.io.*;

/**
 * 동일한 백트래킹 문제더라도, 매개변수로 주어질 상태 변수나, 상태 회복, 상태 변경 로직. 그리고 dfs재귀호출을 할 때 넘겨줄 매개변수의 '값'까지도
 * 다양해 질 수 있다는 것을 알게 된 문제.
 * 근데 일단 문제가 너무 이해하기 어렵게 적어놨다...
 */
public class Main {
    static int N;
    static List<int[]> eggs;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        eggs = new ArrayList<>();
        answer = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int status = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            eggs.add(new int[]{status, weight});
        }

        dfs(0);

        System.out.println(answer);
    }


    private static void dfs(int curr) {
        // 마지막 계란까지 갔을 경우
        if (curr == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (eggs.get(i)[0] <= 0) {
                    cnt += 1;
                }
            }

            answer = Math.max(answer, cnt);
            return;
        }

        // 이미 깨져있는 계란일 경우
        if (eggs.get(curr)[0] <= 0) {
            dfs(curr + 1);
            return;
        }

        boolean canHit = false;

        for (int i = 0; i < N; i++) {
            int status = eggs.get(i)[0];

            if (status > 0 && i != curr) {
                canHit = true;
                break;
            }
        }

        if (!canHit) {
            dfs(curr + 1);
            return ;
        }

        for (int i = 0; i < N; i++) {
            if (i == curr || eggs.get(i)[0] <= 0) {
                continue;
            }

            crush(curr, i);
            dfs(curr + 1);
            recover(curr, i);
        }
    }

    private static void crush(int n, int m) {
        eggs.get(n)[0] -= eggs.get(m)[1];
        eggs.get(m)[0] -= eggs.get(n)[1];
    }

    private static void recover(int n, int m) {
        eggs.get(n)[0] += eggs.get(m)[1];
        eggs.get(m)[0] += eggs.get(n)[1];
    }
}
