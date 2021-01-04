package other;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.DFS(2); /* �־��� ��带 ���� ���� DFS Ž�� */
		g.DFS(); /* �񿬰��� �׷����� ��� */
	}
}

class Graph {
	private int V; // ����� ����
	private LinkedList<Integer> adj[]; // ���� ����Ʈ

	/** ������ */
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) // ���� ����Ʈ �ʱ�ȭ
			adj[i] = new LinkedList();
	}

	/** ��带 ���� v->w */
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	/** DFS�� ���� ���Ǵ� �Լ� */
	void DFSUtil(int v, boolean visited[]) {
		// ���� ��带 �湮�� ������ ǥ���ϰ� ���� ���
		visited[v] = true;
		System.out.print(v + " ");

		// �湮�� ���� ������ ��� ��带 �����´�.
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			// �湮���� ���� ���� �ش� ��带 ���� ���� �ٽ� DFSUtil ȣ��
			if (!visited[n])
				DFSUtil(n, visited); // ��ȯ ȣ��
		}
	}

	/** �־��� ��带 ���� ���� DFS Ž�� */
	void DFS(int v) {
		// ����� �湮 ���� �Ǵ� (�ʱ갪: false)
		boolean visited[] = new boolean[V];

		// v�� ���� ���� DFSUtil ��ȯ ȣ��
		DFSUtil(v, visited);
	}

	/** DFS Ž�� */
	void DFS() {
		// ����� �湮 ���� �Ǵ� (�ʱ갪: false)
		boolean visited[] = new boolean[V];

		// �񿬰��� �׷����� ���, ��� ������ �ϳ��� �湮
		for (int i = 0; i < V; ++i) {
			if (visited[i] == false)
				DFSUtil(i, visited);
		}
	}
}

