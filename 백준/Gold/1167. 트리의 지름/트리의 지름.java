

import java.util.*;
import java.io.*;

public class Main {
	static int V;
	static List<TreeNode> nodes;
	static int answer;
	static int[] dist;
	static int maxNode;
	static int maxCost;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		nodes = new ArrayList<>();
		answer = Integer.MIN_VALUE;
		maxNode = 0;

		for (int i = 0; i <= V; i++) {
			nodes.add(new TreeNode(i));
		}

		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			TreeNode node = nodes.get(index);

			while (true) {
				int nextNode = Integer.parseInt(st.nextToken());

				if (nextNode == -1) {
					break;
				}

				int cost = Integer.parseInt(st.nextToken());
				node.addEdge(nextNode, cost);

			}
		}

		bfs(1);
		bfs(maxNode);

		System.out.println(maxCost);
	}

	private static class TreeNode {
		int nodeNum;
		List<Edge> edges;

		TreeNode(int nodeNum) {
			this.nodeNum = nodeNum;
			this.edges = new ArrayList<>();
		}

		public void addEdge(int nextNode, int cost) {
			TreeNode node = nodes.get(nextNode);
			Edge edge = new Edge(node, cost);
			edges.add(edge);
		}
	}

	private static class Edge {
		TreeNode next;
		int cost;

		public Edge(TreeNode next, int cost) {
			this.next = next;
			this.cost = cost;
		}
	}

	private static void bfs(int startNode) {
		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V + 1];
		dist = new int[V + 1];
		maxCost = Integer.MIN_VALUE;

		visited[startNode] = true;
		queue.offerLast(startNode);

		while (!queue.isEmpty()) {
			int currNode = queue.pollFirst();

			TreeNode node = nodes.get(currNode);
			int currCost = dist[node.nodeNum];
			for (Edge edge : node.edges) {
				TreeNode nextNode = edge.next;
				int nextCost = edge.cost;

				dist[nextNode.nodeNum] = currCost + nextCost;
				int changeCost = dist[nextNode.nodeNum];

				if (!visited[nextNode.nodeNum]) {

					if (changeCost > maxCost) {
						maxCost = changeCost;
						maxNode = nextNode.nodeNum;
					}

					visited[nextNode.nodeNum] = true;
					queue.offerLast(nextNode.nodeNum);
				}
			}
		}
	}
}
