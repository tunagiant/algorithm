package other;

import java.util.EmptyStackException;

class Stack<T> {

	static class Node<T> {
		private T data;
		private Node<T> next = null;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<T> top; // Stack의 초기선언

	public void push(T data) {
		Node<T> node = new Node<>(data);
		node.next = top; // 기존에 있던 top을 새로생성된 node의 밑(next)로 깔음
		top = node; // top에 새로생성된 node값을 넣음
	}

	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		T data = top.data;
		top = top.next;
		return data;
	}

	public T peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	boolean isEmpty() {
		return top == null;
	}
}

public class stack01 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.peek()); // 2
		System.out.println(stack.pop()); // 2
		System.out.println(stack.peek()); // 1
		System.out.println(stack.isEmpty()); // false
		System.out.println(stack.pop()); // 1
		System.out.println(stack.isEmpty()); // true
	}
}
