

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static ArrayList<ArrayList<Road>> graph;
	static PriorityQueue<Road> pq;
	static long[] dist; // N개의 지역까지 가는데 걸린 시간

	static class Road implements Comparable<Road>{
		int dest; // 목적지
		long time; // 신호가 켜지는 시간
		long waitTime; // 누적 대기시간

		public Road(int dest, long time) {
			this.dest = dest;
			this.time = time;
		}

		public Road(int dest, long time, long waitTime) {
			this.dest = dest;
			this.time = time;
			this.waitTime = waitTime;
		}
		
		@Override
		public int compareTo(Road o) {
			return Long.compare(this.waitTime, o.waitTime);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;
		
		graph = new ArrayList<>();
		
		pq = new PriorityQueue<>();
		pq.offer(new Road(1, 0, 0));
		
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Road>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int time = i;
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new Road(end, time));
			graph.get(end).add(new Road(start, time));
			
		}
		
		
		
		
		// 다익스트라
		while(!pq.isEmpty()) {
			Road current = pq.poll();
			
			// 종료조건
			if(current.dest == N) {
				System.out.println(current.waitTime);
				
				return ;
			}
			
			// 현재 경로보다 더 빠른 경로 찾은 경우
			if(dist[current.dest] < current.waitTime) {
				continue;
			}
			
			// 현재 위치에서 갈 수 있는 모든 도로 확인
			for(Road next : graph.get(current.dest)) {
				long currentTime = current.waitTime;
				long cycle = currentTime / M;
				long phase = currentTime % M; 
				
				long waitingTime;
				if(phase <= next.time) {
					waitingTime = next.time - phase;
				} else {
					waitingTime = (M - phase) + next.time;
				}
				
				long nextTime = currentTime + waitingTime + 1; 
				
				if(dist[next.dest] > nextTime) {
					dist[next.dest] = nextTime;
					pq.offer(new Road(next.dest, next.time, nextTime));
				}
			}
		}
		
		System.out.println(dist[N]);
		
	}

}
