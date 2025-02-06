
import java.util.*;
import java.io.*;

public class Main {
	// 전역변수 선언
	static int N, M;
	static int[] lanes;
	static long[] diff;
	static long[] traffic;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lanes = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			lanes[i] = Integer.parseInt(st.nextToken());
		}

		// diff 배열 초기화 (인덱스를 1부터 사용하기 위해 N+2 크기로 선언)
		diff = new long[N + 2];
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long x = Long.parseLong(st.nextToken());
			diff[u] += x;
			diff[v] -= x;
		}

		// 누적 합을 위한 traffic 배열 계산 (1번부터 N번 도시까지, 도로는 1~(N-1))
		traffic = new long[N + 1];
		for (int i = 1; i <= N - 1; i++) {
			traffic[i] = traffic[i - 1] + diff[i];
		}

		StringBuilder sb = new StringBuilder();
		// 각 도로별 부담 계산 및 출력 문자열 구성
		for (int i = 0; i < N - 1; i++) {
			long c = traffic[i + 1]; // i번째 도로: 도시 i와 i+1 사이
			int w = lanes[i];
			long q = c / w;
			long r = c % w;
			long burden = r * (q + 1) * (q + 1) + (w - r) * q * q;
			sb.append(burden).append("\n");
		}
		System.out.print(sb);
	}

}
