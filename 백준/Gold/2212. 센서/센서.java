
import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] censor;
	static int[] diff;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		censor = new int[N];
		diff = new int[N - 1];
		answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			censor[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(censor);

		for (int i = 0; i < N - 1; i++) {
			diff[i] = censor[i + 1] - censor[i];
		}

		Arrays.sort(diff);

		for (int i = 0; i < N - K; i++) {
			answer += diff[i];
		}
		
		System.out.println(answer);
	}
}
