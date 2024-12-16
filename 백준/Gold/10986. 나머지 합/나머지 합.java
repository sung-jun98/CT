

import java.util.*;
import java.io.*;
/*
 * 문제에서 요구하는것은, 구간의 합이 M으로 나누어떨어지는 경우를 세는 것이다. 
 * 
 * 1. 따라서 구간합 sum[]을 채워나감과 동시에, M을 나눈 결과가 같은 것들끼리 따로 배열 mod 에 모아놓는다.
 * 2. mod배열의 각각의 값으로 nC2 연산을 한다. -> i, j가 될 수 있는 쌍의 경우의 수를 구하는 것. 
 * 3. (A-B) mod C = (A mod C - B mod C) 의 모듈러 성질을 이용한 것.
 * 
 */
public class Main {
	static int N, M;
	static long[] sum;
	static long[] mod;
	static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sum = new long[N + 1];
		sum[0] = 0;
		mod = new long[M];
		answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());
			mod[(int) (sum[i] % M)] += 1;
		}
		
		answer += mod[0]; 
		
		for (int i = 0; i < M; i++) {
			long n = mod[i];
			long pair = 0;
			if(n > 1) {
				pair = (n * (n - 1)) / 2;
				answer += pair;
			}
			
		}
		
		System.out.println(answer);
	}
}
