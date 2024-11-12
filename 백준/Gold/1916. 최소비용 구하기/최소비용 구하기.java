import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static int start, end;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		graph = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(startNode).add(new Edge(endNode, cost));

		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dist[start] = 0;
		search(start, end);
		//printVal();
	}

	private static void search(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int currentCost = node.cost;
			int currentVertex = node.vertex;
			
			if(currentCost > dist[currentVertex]) {
				continue;
			}
			
			for (Edge edge : graph.get(node.vertex)) {
				int nextNode = edge.to;
				int nextCost = currentCost + edge.cost;
				
				if (nextCost < dist[nextNode]) {
					dist[nextNode] = nextCost;
                    pq.offer(new Node(nextNode, nextCost));
				}
			}
		}
		
		System.out.println(dist[end]);

	}

	
	static class Edge {
		int to;
		int cost;

		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	static class Node implements Comparable<Node> {
		int vertex;
		int cost;

		Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}
}
