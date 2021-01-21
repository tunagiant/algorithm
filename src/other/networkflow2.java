package other;

//포드 풀커슨 알고리즘
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

public class networkflow2 {

	static final int INF = 987654321;
	static int V;
	// capacity[u][v] : u 에서 v 로 보낼 수 있는 용량
	// flow[u][v] u에서 v로 흘러가는 유량 ( 반대방향일 경우 음수)

	int capacity[][] = new int[V][V], flow[][] = new int[V][V];
	// flow[][] 를 계싼하고 총 유량을 반환하다.

	// source 는 시작점 sink는 도착하는곳 이 두정점을 제외하고는 유량보존의 법칙이 적용된다.
	int networkFlow(int source, int sink) {

		// flow를 0으로 초기화 한다.
		for (int i = 0; i < V; i++)
			Arrays.fill(flow[i], 0);

		// answer 값
		int totalFlow = 0;

		while (true) {
			// 너비 우선탐색으로 증가 경로를 찾는다.
			int[] parent = new int[V];
			Arrays.fill(parent, -1);
			Queue<Integer> q = new LinkedList<Integer>();

			// 경로탐색의 끝지점 즉 시작지점.. source -> a -> b- > c -> ... -> sink 까지 간다면
			// parent[sink] = ? , parent [c] = b , parent[b] = a , parent[a] = source
			// parent[source] = source 를 해서
			// 자기 자신이 나오는 경로까지 찾아간다면 source -> sink의 경로를 알 수 있다.
			parent[source] = source;
			q.add(source);

			// 이 while문 자체는 어떻게서든지 하나의 경로를 찾는 while 문이다.
			while (!q.isEmpty() && parent[sink] == -1) {
				int here = q.poll();
				for (int there = 0; there < V; ++there) {
					// 잔여 용량이 남아 있는 간선을 따라 탐색한다.
					// 방문안한 곳에만 방문한다.
					if (capacity[here][there] - flow[here][there] > 0 && parent[there] == -1) {
						q.add(there);
						parent[there] = here;
					}

				}
			}

			// 증가 경로가 없으면 종료한다.
			// q를 돌리면서 너비우선탐색을 돌렷는데 sink가 가리키는게 -1이라는것은 연결된 간선 자체가 존재하지 않는다는 것.
			if (parent[sink] == -1)
				break;

			// 증가 경로를 통해 유량을 얼마나 보낼지 결정한다.
			// 출발지점에서 시작하여 가장 작은 유량을 결정하는 구분.
			// 이렇게 돌고나면 amount에는 처음 구했던 하나의 증가경로에서 가장작은 유량을 결정함.

			int amount = INF;
			for (int p = sink; p != source; p = parent[p]) {
				// 유량을 보낼수 있는 경우에만 간선을 이었으니 가능함.
				amount = Math.min(capacity[parent[p]][p] - flow[parent[p]][p], amount);
			}

			// 증가 경로를 통해 유량을 보낸다
			for (int p = sink; p != source; p = parent[p]) {
				flow[parent[p]][p] += amount;
				flow[p][parent[p]] -= amount;
			}

			totalFlow += amount;
		}
		return totalFlow;
	}

}
