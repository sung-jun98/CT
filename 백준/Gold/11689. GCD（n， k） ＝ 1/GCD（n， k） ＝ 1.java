

import java.util.*;
import java.io.*;

public class Main {
	static long n;
	static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Long.parseLong(br.readLine());

		answer = phi(n);
		System.out.println(answer);

	}

	public static long phi(long n) {
		long result = n;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			// n이 소인수인 경우
			if (n % i == 0) {
				while (n % i == 0) {
					n /= i;
				}

				result = result - result / i;
			}

		}
		// n이 소수인 경우에는 위의 if 문에서 걸러지지 않기 때문에 오일러의 피 공식을 다시 한번 적용시켜야 한다.
		if (n > 1) {
			result = result - result / n;
		}
		
		return result;
	}

}
