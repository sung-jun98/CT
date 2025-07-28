import java.util.*;
import java.io.*;

/**
 * 처음에는 dfs로 풀었는데 시간초과로 안된다고 하고, 3중 for문으로 풀었는데도 시간초과가 나와서 연속된 3개의 수만 비교하는 방법으로 바꾸라고
 * 해서 바꿨는데 왜 연속된 3개만 봐도 문제가 풀리는지는 아직도 모르겠다.
 * 시간복잡도 계산하는건 일단 영원히 이해 못할거같다 ㅋ
 */
public class Main {
    static int N;
    static List<Integer> inputs;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inputs = new ArrayList<>();
        answer = -1;

        for (int i = 0; i < N; i++) {
            inputs.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(inputs, Collections.reverseOrder());

        for (int i = 0; i < N - 2; i++) {

            int a = inputs.get(i);
            int b = inputs.get(i + 1);
            int c = inputs.get(i + 2);

            if (a < (b + c)) {
                answer = a + b + c;
                System.out.println(answer);
                return;
            }
        }

        System.out.println(answer);
    }
}