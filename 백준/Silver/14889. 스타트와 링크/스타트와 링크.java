
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] inputs;
	static boolean[] selected;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		inputs = new int[N][N];
		selected = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				inputs[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(min);
	}

	private static void dfs(int index, int count) {
		if (count == N / 2) {
			calcDiff();
			return;
		}

		for (int i = index; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				dfs(i + 1, count + 1);
				selected[i] = false;
			}
		}
	}

	private static void calcDiff() {
		int startSum = 0;
		int linkSum = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (selected[i] && selected[j]) {
					startSum += inputs[i][j] + inputs[j][i];
				} else if (!selected[i] && !selected[j]) {
					linkSum += inputs[i][j] + inputs[j][i];
				}
			}
		}

		int diff = Math.abs(startSum - linkSum);
		if (diff == 0) {
			System.out.println(0);
			System.exit(0);
		}

		min = Math.min(min, diff);
	}
}
