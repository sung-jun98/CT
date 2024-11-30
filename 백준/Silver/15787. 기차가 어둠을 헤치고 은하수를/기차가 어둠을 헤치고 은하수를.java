
import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] trains;
	static Set<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		trains = new int[N + 1];
		set = new HashSet<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = 0;
			int seat = 0;

			int order = Integer.parseInt(st.nextToken());
			switch (order) {

			case 1:
				num = Integer.parseInt(st.nextToken());
				seat = Integer.parseInt(st.nextToken());

				trains[num] = (trains[num] | (1 << seat));
				break;

			case 2:
				num = Integer.parseInt(st.nextToken());
				seat = Integer.parseInt(st.nextToken());

				trains[num] = (trains[num] & ~(1 << seat));
				break;

			case 3:
				num = Integer.parseInt(st.nextToken());

				trains[num] = (trains[num] & ~(1 << 20));
				trains[num] = (trains[num] << 1);
				break;

			case 4:
				num = Integer.parseInt(st.nextToken());

				trains[num] = (trains[num] & ~(1 << 1));
				trains[num] = (trains[num] >> 1);
				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			set.add(trains[i]);
		}
		
		System.out.println(set.size());
	}
}
