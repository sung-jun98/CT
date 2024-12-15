import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int start, end;
	static int answer;
	static int tmpSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		start = 1;
		end = 1;
		answer = 0;
		tmpSum = 1;
		// 입력끝
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
