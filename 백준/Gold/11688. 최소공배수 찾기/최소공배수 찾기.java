
import java.util.*;
import java.io.*;

/*
 * 1. LCM(a, b, c) == LCM(LCM(a, b), c)이다.
 * 2. 따라서, LCM(a, b) -> ab
 * 3. L이 ab로 나누어 떨어지지 않으면, L은 a, b의 최소공배수가 아니기 때문에 -1을 출력한다.
 * 4. c를 찾기 위한 탐색범위(i의 범위)는 1부터 ab의 제곱근까지 -> 만들어질 수 있는 약수의 쌍중, 절반의 범위는 ab의 제곱근이기 때문
 * 5. (L / ab) => c가 될 수 있는 후보의 최솟값 => 여기에 i와 ab/i를 곱해주어 ab와 최소공배수가 L과 같은 c의 값을 하나씩 찾는다.
 */
public class Main {
	static long a, b, c, L;
	static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		L = Long.parseLong(st.nextToken());
		c = -1;
		answer = -1;

		long ab = lcm(a, b);
		if (L % ab != 0) {
			System.out.println(-1);
			return;
		}

		c = L / ab;

		for (long i = 1; i * i <= ab; i++) {
			long another = ab / i;

			if (ab % i != 0) {
				continue;
			}

			// 약수의 쌍중, 작은값
			if (lcm(ab, c * i) == L) {
				answer = c * i;
				break;
			}

			// 약수의 쌍중, 큰값
			if (lcm(ab, c * another) == L) {
				answer = c * another;
				
			}
		}

		System.out.println(answer);
	}

	static long gcd(long a, long b) {
		if (b == 0) {
			return a;

		} else {
			return gcd(b, a % b);
		}
	}

	static long lcm(long a, long b) {
		long gcd = a > b ? gcd(a, b) : gcd(b, a);
		return a / gcd * b;
	}
}
