

import java.util.*;
import java.io.*;
/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7

[]
[2, 5]
[1, 3, 5]
[2]
[7]
[1, 2, 6]
[5]
[4]

 */
public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> computers;
	static boolean[] visited;
	static Deque<Integer> deque;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		computers = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			computers.add(new ArrayList<>());
		}

		visited = new boolean[N + 1];
		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());

			computers.get(first).add(last);
			computers.get(last).add(first);
		}

		bfs();
		int answer = getAnswer();
		System.out.println(answer - 1);
		
	}
	
	static private void bfs() {
		deque = new ArrayDeque<>();
		visited[1] = true;
		for(int num : computers.get(1)) {
			visited[num] = true;
			deque.offerLast(num);
		}
		
		while(!deque.isEmpty()) {
			int next = deque.pollFirst();
			
			for(int num : computers.get(next)) {
				if(!visited[num]) {
					visited[num] = true;
					deque.offerLast(num);
				}
				
			}
		}
	}
	
	static private int getAnswer() {
		int answer = 0;
		for(boolean next : visited) {
			if(next) {
				answer += 1;
			}
		}
		
		return answer;
	}

}
