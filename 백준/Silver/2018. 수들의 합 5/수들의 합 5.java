import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] sum, num;
	static int start, end;
	static int answer;
	static int tmpSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N + 1];

		start = 1;
		end = 1;
		answer = 0;
		tmpSum = 1;

		// 입력끝

		for (int i = 1; i <= N; i++) {
			num[i] = i;
		}

		

		while (end <= N) {
			if (tmpSum > N) {
				tmpSum -= start;
				start += 1;

			} else if (tmpSum < N) {
				end += 1;
				tmpSum += end;

			} else if (tmpSum == N) {
				answer += 1;
				tmpSum -= start;
				start += 1;
				
			}
		}

		System.out.println(answer);
	}

}
