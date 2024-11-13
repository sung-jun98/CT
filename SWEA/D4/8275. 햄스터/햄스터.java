/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////


/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */


import java.util.*;
import java.io.*;

/*
3
3 5 1
1 2 5
3 5 2
1 2 6
2 3 7
4 5 2
1 3 15
3 4 4
 */
public class Solution {
	static int T;
	static int N, X, M;
	static int[][] order;
	static int[] cage;
	static int[] answer;
	static int maxG;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			order = new int[M][3];
			cage = new int[N];
			answer = new int[N];
			maxG = Integer.MIN_VALUE;
			

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				order[i][0] = Integer.parseInt(st.nextToken());
				order[i][1] = Integer.parseInt(st.nextToken());
				order[i][2] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);
			if(maxG == Integer.MIN_VALUE) {
				System.out.println("#" + t + " " + "-1");
			}
			else {
				System.out.print("#" + t + " ");
				for(int i = 0; i < answer.length; i++) {
					System.out.print(answer[i] + " ");
				}
				System.out.println();
			}
		}
	}

	private static void dfs(int cnt, int maxL) {
		if (cnt == N) {
			if (maxG >= maxL) {
				return;
			}
			boolean flag = true;
			// System.out.println(Arrays.toString(cage));
			for (int i = 0; i < M; i++) {
				int start = order[i][0] - 1;
				int end = order[i][1] - 1;	
				int hamster = order[i][2];
				int hamsterCnt = 0;

				for (int j = start; j <= end; j++) {
					hamsterCnt += cage[j];
				}

				if (hamsterCnt != hamster) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				maxG = maxL;
				answer = cage.clone();
			}
			// System.out.println(Arrays.toString(answer));
			return;
		}

		for (int i = 0; i <= X; i++) {
			cage[cnt] = i;
			dfs(cnt + 1, maxL + i);
		}
	}

}
