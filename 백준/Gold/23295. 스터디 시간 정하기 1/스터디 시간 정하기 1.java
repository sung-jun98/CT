

import java.io.*;
import java.util.*;

public class Main {
	static int N, T;
	static int K;
	static int[] time;
	static long[] record;
	static long timeSum;
	static long max;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		time = new int[100001];
		record = new long[100001];
		timeSum = 0;
		max = Long.MIN_VALUE;
		answer = 0;

		for (int i = 0; i < N; i++) {
			K = Integer.parseInt(br.readLine());

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				for (int k = start; k < end; k++) {
					time[k] += 1;
				}
			}
		}

		// 입력끝

		// 시간이 0일 경우 채워주기
		for (int i = 0; i < T; i++) {

			timeSum += time[i];
		}

		record[0] = timeSum;

		if (timeSum > max) {
			max = timeSum;
			answer = 0;
		}

		// 나머지
		for (int i = T; i < 100001; i++) {
			timeSum += time[i];
			timeSum -= time[i - T];
			record[i - T + 1] = timeSum;

		}

		for (int i = 0; i < 100001; i++) {
			if (record[i] > max) {
				max = record[i];
				answer = i;
			}
		}

//		for(int i=0; i<15; i++) {
//			System.out.print(time[i] + " ");
//		}
//		
//		System.out.println();
//		
//		for(int i=0; i<15; i++) {
//			System.out.print(record[i] + " ");
//		}
//		System.out.println();
		System.out.println(answer + " " + (answer + T));

	}

}
