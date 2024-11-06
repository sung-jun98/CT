
import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] parents;
	static List<Edge> edges;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N];
		edges = new ArrayList<>();
		answer = 0;

		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			edges.add(new Edge(start, end));
		}

		for (int i = 0; i < M; i++) {
			Edge edge = edges.get(i);
			int start = edge.start;
			int end = edge.end;

			if (find(start) != find(end)) {
				union(start, end);
			} else {
				System.out.println(i + 1);
				return ;
			}
		}
		
		System.out.println(0);

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a > b) {
			parents[a] = parents[b];
		} else {
			parents[b] = parents[a];
		}
	}

	private static int find(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			return find(parents[x]);
		}
	}
}

class Edge {
	int start;
	int end;

	public Edge(int start, int end) {
		this.start = start;
		this.end = end;
	}

//	@Override
//	public int compareTo(Edge o) {
//		return Integer.compare(edge, end)
//	}
}
