import java.util.*;
import java.io.*;

/**
 * 1 2 3 4 5 6 7 8
 * <p>
 * 1 2 3 4 5 (2)
 * 2 3 4 5 (2)
 * 2 3 4 5 6 (3)
 * 2 3 4 5 6 7 (3)
 * <p>
 * 홀수 개수가 k개와 같다면 -> 왼쪽 포인터 이동 / 홀수 개수가 k개보다 적다면 -> 오른쪽 포인터 이동
 * 종료조건 : right가 맨 오른쪽까지 갈 경우
 */
public class Main {
    static int N, K;
    static int[] inputs;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        inputs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, oddCnt = 0, evenCnt = 0;

        for (int right = 0; right < N; right++) {
            if(inputs[right] % 2 == 1){
                oddCnt += 1;
            }

            while(oddCnt > K){
                if(inputs[left] % 2 == 1){
                    oddCnt -= 1;
                }
                left += 1;
            }

            evenCnt = (right - left) + 1 - oddCnt;
            answer = Math.max(answer, evenCnt);

        }

        System.out.println(answer);
    }
}
