package other;
// 최단경로트리		따라서 최소비용이 아닐수도 있음

// 프림과 달리 다익스트라는 두 노드사이의 최단거리 보장
// 프림은 무향, 다익스트라는 무향,유향
// 음의 간선 존재X 가중치의 합이 음수인 사이클이 존재하게 되면 최단 경로가 음의 무한대로 발산하게 됨
// 한 정점으로부터 다른 정점까지의 최단경로를 구함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*case
  5 6
1 2 10
1 3 15
3 4 20
4 5 10
2 4 30
3 5 5
 *  */

public class dijkstra {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1[] = br.readLine().split(" ");
		int V = Integer.parseInt(input1[0]);
		int E = Integer.parseInt(input1[1]);
		int end = V - 1;

		int adj[][] = new int[V][V];

		// 입력받은 데이터로 인접행렬을 만드는 과정
		for (int i = 0; i < E; i++) {
			String input2[] = br.readLine().split(" ");
			// index는 0부터 시작하기 때문에 입력한 값에서 1뺌
			int a = Integer.parseInt(input2[0]) - 1;
			int b = Integer.parseInt(input2[1]) - 1;
			int c = Integer.parseInt(input2[2]);
			adj[a][b] = c;
			adj[b][a] = c;
		}

		boolean visited[] = new boolean[V];
		int d[] = new int[V];

		Arrays.fill(d, Integer.MAX_VALUE);

		// 시작정점 : 0
		d[0] = 0;

		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int cur = 0;

			for (int j = 0; j < V; j++) {
				if (!visited[j] && d[j] < min) {
					cur = j;
					min = d[j];
				}
			}

			if (visited[cur])
				continue;
			visited[cur] = true;
			if (cur == end)
				break;

			// 새로 추가한 정점으로부터 연결되어있는 다른 정점 정보 업데이트
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adj[cur][j] != 0 && d[j] > min + adj[cur][j]) {
					d[j] = min + adj[cur][j];
				}
			}

		}

		for (int i = 0; i < d.length; i++)
			System.out.println(d[i] + " ");
	}

}
