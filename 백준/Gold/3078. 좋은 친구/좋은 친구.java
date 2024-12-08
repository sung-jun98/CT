
import java.util.*;
import java.io.*;

public class Main{
	static int N, K;
	static String[] names;
	static int[] nameLen;
	static long answer;
	static int count[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		names = new String[N];
		answer = 0;
		count = new int[21];
		nameLen = new int[N];

		for (int i = 0; i < N; i++) {
			names[i] = br.readLine();
			nameLen[i] = names[i].length();
		}

		for (int i = 0; i < N; i++) {
			int l = nameLen[i];
			answer += count[l];
			count[l] += 1;
			// 윈도우가 K를 초과한다면, 가장 오래된 학생을 윈도우에서 제거
			if (i >= K) {
				int l_remove = nameLen[i - K];
				count[l_remove] -= 1;
			}
		}

		System.out.println(answer);
	}

}
