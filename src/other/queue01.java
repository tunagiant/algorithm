package other;

import java.util.NoSuchElementException;

class queue<T> {
	
	static class Node<T> {
		private T data;
		private Node<T> next = null;

		public Node(T data) {
			this.data = data;
		}
	}

	/* 큐는 앞 뒤 주소 있어야함 */
	// first는 먼저나감, last는 나중에나감
	private Node<T> first;
	private Node<T> last;

	public void add(T item) {
		Node<T> t = new Node<T>(item);

		if (last != null) {
			last.next = t;
		}
		last = t;
		if (first == null) {
			first = last;	// 데이터가 없다면(first = null) 같은값을 할당해줌
		}
	}

	public T remove() {		// 앞에있는 것부터 제거됨(first)
		if (first == null) {	// 큐가 비어있을 때
			throw new NoSuchElementException();
		}
		T data = first.data;	// first를 제거하기 전 데이터를 백업해줌
		first = first.next;		// 다음 노드를 first로 만듬

		if (first == null) {	// 큐가 비어있을 때(큐에 데이터가 한개였어서 앞선 과정에서 제거 후, 큐가 빔)
			last = null;
		}
		return data;
	}

	public T peek() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}
}

public class queue01 {
	public static void main(String[] args) {
		queue<Integer> q = new queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());

	}
}
