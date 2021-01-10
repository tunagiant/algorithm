package other;
// 최단경로트리		따라서 최소비용이 아닐수도 있음

// 프림과 달리 다익스트라는 두 노드사이의 최단거리 보장
// 프림은 무향, 다익스트라는 무향,유향
// 음의 간선 존재X 가중치의 합이 음수인 사이클이 존재하게 되면 최단 경로가 음의 무한대로 발산하게 됨
// 우선순위큐 이용(시간효율성이 훨씬 뛰어남)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
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

public class dijkstra2 {
	
	static class Edge implements Comparable<Edge> {
		int v, weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		// v, weight 중 weight를 우선순위의 기준으로설정(우선순위큐  특성)
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return weight + "";
		}

	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		List<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			// 첫번째(i)가 출발지, 두번째(v)가 도착지, 세번째(weight)가 가중치
			adj[sc.nextInt() - 1].add(new Edge(sc.nextInt() - 1, sc.nextInt()));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		Edge[] D = new Edge[V];
		// 0번에서 출발하는걸로	초기화작업
		for (int i = 0; i < V; i++) {
			// 원하는 출발지
			if (i == 0) {
				D[i] = new Edge(i, 0);
			} else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		while (!pq.isEmpty()) {
			// 0 -> edge.v
			Edge edge = pq.poll();

			// 0 -> edge.v	이제 밑의 향상된 for문에서 edge.v에서 다른 모든정점으로의 거리 계산 (리스트)
			// 0 -> edge.v(현재정점) -> next(다음정점)
			for (Edge next : adj[edge.v]) {
				// check되지 않았으면서, D[next.v](0에서 (현재정점(edge.v) 안거치고) next로 다이렉트)가 
				// D[edge.v](0 -> edge.v) + next.weight(edge.v -> next의 가중치) 보다 더 크다면 후자값으로 갱신
				if (!check[next.v] && D[next.v].weight > D[edge.v].weight + next.weight) {
					D[next.v].weight = D[edge.v].weight + next.weight;
					// decrease key
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			check[edge.v] = true;
		}
		System.out.println(Arrays.toString(D));
	}
}