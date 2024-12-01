import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Math.abs(Long.parseLong(st.nextToken())); // 절대값 처리
        long M = Math.abs(Long.parseLong(st.nextToken())); // 절대값 처리

        // 특수 경우: 둘 중 하나가 0이면 최대 이동 횟수는 max(N, M)
        if (N == 0 || M == 0) {
            System.out.println(Math.max(N, M));
            return;
        }

        // GCD 계산
        long gcdValue = gcd(N, M);

        // 최소 순간이동 횟수는 2 또는 GCD 값 중 작은 값
        System.out.println(Math.min(2, gcdValue));
    }

    // 유클리드 호제법을 이용한 GCD 계산
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}