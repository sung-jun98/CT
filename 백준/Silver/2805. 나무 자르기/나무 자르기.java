

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] trees;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");

		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		trees = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {

			trees[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees);

		System.out.println(findAnswer(trees));

	}

	private static int findAnswer(int[] trees) {
		int left = 0;
		int right = trees[N - 1];
		int answer = 0;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			long sum = 0;
			for(int tree : trees) {
				
				if(tree > mid) {
					sum += (tree - mid);
				}
			}
						
			if(sum >= M) {
				answer = mid;
				left = mid + 1;
				
			} else {
				
				right = mid - 1;
			}
		}
		return answer;
	}
}
