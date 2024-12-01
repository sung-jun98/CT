

import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int N;
	static int[] count;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		count = new int[1001];

		getGcdList();

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			System.out.println(count[N]);
		}
	}

	static void getGcdList() {
		count[1] = 3;
		
		for (int i = 2; i < 1001; i++) {
			int gcdCnt = 0;
			for (int j = 1; j < i; j++) {
				if (gcd(i, j) == 1) {
					gcdCnt += 1;
				}
			}

			// 2차원 그래프는 대칭이기 떄문에 *2를 하고, x와 y의 좌표가 같으면 중복계산되기 떄문에 1을 더해준다.
			count[i] = count[i - 1] + 2 * gcdCnt;
			
			if(i == 1) {
				count[i] += 1;
			}
		}
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
			
		} else {
			return gcd(b, a % b);
		}
	}
}
