

import java.util.*;
import java.io.*;

public class Main {
	static int TC;
	static int N, M, W;
	static int[] dist;
	static ArrayList<Edge> edges;
	static String answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			answer = "NO";
			edges = new ArrayList<>();
			dist = new int[N + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				Edge road = new Edge(start, end, weight);
				Edge road_reverse = new Edge(end, start, weight);

				edges.add(road);
				edges.add(road_reverse);
			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = -1 * Integer.parseInt(st.nextToken());

				Edge hole = new Edge(start, end, weight);

				edges.add(hole);
			}
			
			for (int i = 1; i <= N; i++) {
				edges.add(new Edge(0, i, 0));
			}
			
			dist[0] = 0;

			for (int i = 0; i < N; i++) {
				for (Edge edge : edges) {

					if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.weight) {
						dist[edge.end] = dist[edge.start] + edge.weight;
					}
				}
			}

			// 모든 간선 조회하며 음수 사이클 확인
			for (Edge edge : edges) {

				if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.weight) {
					answer = "YES";
				}
			}

			System.out.println(answer);
		}
	}

	static class Edge {
		int start = 0;
		int end = 0;
		int weight = 0;

		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
}
