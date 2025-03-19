

import java.util.*;
import java.io.*;

public class Main {
	static long x, y;
	static long result;
	static long currentWinRate, targetWinRate;
	static long answer = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());

		currentWinRate = (y * 100) / x;
		targetWinRate = currentWinRate + 1;

		if (currentWinRate >= 99 && y == x) {
			answer = -1;
		}

		long left = 1;
		long right = 1000000000; // 충분히 큰 값

		while (left <= right) {
			long mid = left + (right - left) / 2;

			// mid번 더 이겼을 때의 승률 계산
			long newWinRate = ((y + mid) * 100) / (x + mid);

			if (newWinRate >= targetWinRate) {
				// 조건을 만족하면 더 작은 값 탐색
				answer = mid;
				right = mid - 1;
			} else {
				// 조건을 만족하지 않으면 더 큰 값 탐색
				left = mid + 1;
			}
		}

		System.out.println(answer);
	}

}
