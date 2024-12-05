
import java.util.*;
import java.io.*;
/*
 * # N을 이진화한 후의 1의 개수가 물병을 최대로 합칠 떄, 물이 채워져 있는 물병의 개수이다.
 * # 우리가 원하는 것은 물병의 개수를 K개 이하로 줄이는 것.
 * 1. N의 가장 낮은 비트 찾기
 * 2. 해당 비트 N에 더해주기 -> 1의 개수 하나씩 줄어듦
 * 3. 갱신된 N의 1의 개수가 K개보다 작아지면 종료
 */

public class Main {
	static int N, K;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		
		if(Integer.bitCount(N) <= K) {
			System.out.println(0);
			return ;
		}
		
		while(Integer.bitCount(N) > K) {
			int lowestBit = N & -N; //가장 낮은 1인 비트
			answer += lowestBit;
			N += lowestBit;
			
		}
		System.out.println(answer);
	}
}
