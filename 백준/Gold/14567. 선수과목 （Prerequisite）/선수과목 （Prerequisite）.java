
import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<Integer>[] subjects;
	static int[] count;
	static Deque<Integer> deque;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		subjects = new ArrayList[N + 1];
		count = new int[N + 1];

		deque = new ArrayDeque<>();
		answer = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			subjects[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			subjects[start].add(end);
			count[end] += 1;

		}

		for (int i = 0; i <= N; i++) {
			if (count[i] == 0) {
				deque.offerLast(i);
			}
		}

		int time = 1;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				int current = deque.pollFirst();
				answer[current] = time;
				for(int next : subjects[current]) {
					count[next]--;
					if(count[next] == 0) {
						deque.offerLast(next);
						
					}
				}
			}
			
			time += 1;
		}
		
		for(int i= 1; i<= N; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
