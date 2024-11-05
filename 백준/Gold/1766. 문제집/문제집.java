import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static List<Integer>[] quest;
	static int[] count;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		quest = new ArrayList[N + 1];
		count = new int[N + 1];
		pq = new PriorityQueue<>();
		
		for (int i = 0; i <= N; i++) {
			quest[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			quest[start].add(end);
			count[end] += 1;
		}
		
		
		for (int i = 1; i <= N; i++) {
			if(count[i] == 0) {
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int current = pq.poll();
			System.out.print(current + " ");
			
			for(int next: quest[current]) {
				count[next] -= 1;
				if(count[next] == 0) {
					pq.offer(next);
				}
			}
		}
	}
}
