package other;
//최소 스패닝트리	따라서 최단거리가 아닐 수도 있음
//정점 선택 기반, 간선 많을때 유리, 인접행렬 or PQ로 풀이가능 (인접행렬이 효율good)
//모든정점 선택까지 반복, 사이클X

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class prim {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1[] = br.readLine().split(" ");
		int V = Integer.parseInt(input1[0]);
		int E = Integer.parseInt(input1[1]);
		// 인접행렬
		int adj[][] = new int[V][V];
		int result = 0;
		
		for (int i = 0; i < E; i++) {
			String input2[] = br.readLine().split(" ");
			int a = Integer.parseInt(input2[0]) - 1;
			int b = Integer.parseInt(input2[1]) - 1;
			int c = Integer.parseInt(input2[2]);
			adj[a][b] = c;
			adj[b][a] = c;
		}
		
		// visited : 정점 방문여부		distance : 트리(방문 시 정점이 저장됨)
		boolean visited[] = new boolean[V];
		int distance[] = new int[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		// 처음선택 정점
		distance[0] = 0;
		int cnt = 0;
		
		while (true) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int i = 0; i < V; i++) {
				if (!visited[i] && distance[i] < min) {
					idx = i;
					min = distance[i];
				}
			}
			
			visited[idx] = true;
			result += min;
			cnt++;
			
			if (cnt == V) break;
			
			// 새로 추가한 정점으로부터 연결되어있는 다른 정점 정보 업데이트
			for (int i = 0; i < V; i++) {
				if (!visited[i] && adj[idx][i] > 0 && distance[i] > adj[idx][i]) {
					distance[i] = adj[idx][i];
				}
			}
		}
		
	}

}
