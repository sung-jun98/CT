

import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] inputs;
	static int[] count; // 현재 보고 있는 구간 내에 등장한 숫자들의 개수를 저장하는 배열
	static int start, end;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		inputs = new int[N];
		count = new int[100001];
		start = 0;
		end = 0;
		answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}

		count[start] += 1;
		count[end] += 1;

		while (end < N) {
			if (count[inputs[end]] < K) {
				count[inputs[end]] += 1;
				end += 1;
			} else {
				count[inputs[start]] -= 1;
				start += 1;
			}

			int len = end - start;
			if (len > answer) {
				answer = len;
			}
		}

		System.out.println(answer);
	}

}
