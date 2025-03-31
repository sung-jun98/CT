

import java.util.*;
import java.io.*;

public class Main {
	static long T, n;
	static PriorityQueue<Process> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int order = Integer.parseInt(st.nextToken());

			Process pc = new Process(id, time, order);
			pq.add(pc);
		}

		for (int i = 1; i <= T; i++) {
			Process pc = pq.poll();

			pc.order -= 1;
			pc.time -= 1;

			//System.out.println(pc.id);
			sb.append(pc.id).append('\n');

			if (pc.time != 0) {
				pq.add(pc);
			}

			List<Process> tmpList = new ArrayList<>();
			
//			while (!pq.isEmpty()) {
//				Process tmp = pq.poll();
//				tmp.order += 1;
//				tmpList.add(tmp);
//			}
//
//			for(Process next : tmpList) {
//				pq.offer(next);
//			}
		}
		
		System.out.println(sb);
	}

	static class Process implements Comparable<Process> {
		int id;
		int time;
		int order;

		public Process(int id, int time, int order) {
			this.id = id;
			this.time = time;
			this.order = order;
		}

		@Override
		public int compareTo(Process other) {
			if(this.order == other.order) {
				return Integer.compare(this.id, other.id);
			}
			return Integer.compare(other.order, this.order);
		}
	}
}
