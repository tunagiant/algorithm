package other;
// 최단경로트리		따라서 최소비용이 아닐수도 있음
// 프림과 달리 다익스트라는 두 노드사이의 최단거리 보장
// 프림은 무향, 다익스트라는 무향,유향
// 음의 간선 존재X

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dijkstra {
	
	public static class Vertex implements Comparable<Vertex> {
		int v, weight;
		
		public Vertex(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int end = V - 1;
		int adj[][] = new int[V][V];
		int d[] = new int[V];
		
		for (int i = 0; i < V; i++) {
			String input2[] = br.readLine().split(" ");
			for (int j = 0; j < V; j++) {
				adj[i][j] = Integer.parseInt(input2[j]);
			}
		}
		
		
		
		
	}

}
