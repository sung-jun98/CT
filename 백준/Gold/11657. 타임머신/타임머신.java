

import java.util.*;
import java.io.*;

class Edge11657 {
	int source;
	int destination;
	int weight;

	Edge11657(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
}

public class Main {
	static int N, M;
	static ArrayList<Edge11657> edges;
	static long[] dist;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new ArrayList<>();
		dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int source = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			Edge11657 edge = new Edge11657(source, destination, weight);
			edges.add(edge);

		}

		// 벨만포드 실행
		boolean updated = false;

		for (int i = 1; i < N; i++) {
			updated = false;
			for (Edge11657 edge : edges) {
				if (dist[edge.source] != Long.MAX_VALUE) {
					if (dist[edge.source] + edge.weight < dist[edge.destination]) {
						dist[edge.destination] = dist[edge.source] + edge.weight;
						updated = true;
					}
				}
			}

			// 더이상 업데이트가 없다면 종료
			if (updated != true) {
				break;
			}
		}

		// 음수 사이클 조사
		boolean hasCycle = false;
		for (Edge11657 edge : edges) {
			if (dist[edge.source] != Long.MAX_VALUE) {
				if (dist[edge.source] + edge.weight < dist[edge.destination]) {
					dist[edge.destination] = dist[edge.source] + edge.weight;
					hasCycle = true;
				}

			}
		}

		if (hasCycle) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= N; i++) {
				if(dist[i] == Long.MAX_VALUE) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(dist[i]).append('\n');
				}
			}
			System.out.println(sb.toString());
		}

	}

}
