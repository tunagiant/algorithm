package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/* case
7 9 1 7
1 2 2
1 3 7
2 4 3
3 4 5
3 5 5
4 6 4
5 6 1
5 7 2
6 7 6
 */

public class networkflow {

	public static int INF = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int src = Integer.parseInt(st.nextToken());
		int sink = Integer.parseInt(st.nextToken());

		int[][] flow = new int[V + 1][V + 1];
		int[][] capacity = new int[V + 1][V + 1];
		boolean[][] adj = new boolean[V + 1][V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			capacity[a][b] = c;
			adj[a][b] = adj[b][a] = true;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		int ans = 0;

		while (true) {
			int[] prev = new int[V + 1];

			q.clear();
			q.add(src);
			prev[src] = src;

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (int there = 1; there <= V; there++) {
					if (!adj[cur][there])
						continue;
					if (prev[there] != 0)
						continue;

					if (capacity[cur][there] - flow[cur][there] > 0) {
						q.add(there);
						prev[there] = cur;
						if (there == sink)
							break;
					}
				}
			}

			if (prev[sink] == 0)
				break;

			int minFlow = INF;
			for (int v = sink; prev[v] != v; v = prev[v]) {
				minFlow = Math.min(minFlow, capacity[prev[v]][v] += minFlow);
				flow[v][prev[v]] -= minFlow;
			}

			ans += minFlow;
		}

		System.out.println(ans);

	}

}
