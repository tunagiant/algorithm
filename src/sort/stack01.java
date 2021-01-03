package sort;

import java.util.EmptyStackException;

public class stack01 {
    static class Stack<T> {
        static class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
            }
        }

        private Node<T> top;

        public void push(T data) {
            Node<T> node = new Node<>(data);
            node.next = top;
            top = node;
        }

        public T pop() {
            if (top == null) {
                throw new EmptyStackException();
            }
            T data = top.data;
            top = top.next;
            return data;
        }

        public T peek(){
            if (top == null) {
                throw new EmptyStackException();
            }
            return top.data;
        }

        boolean isEmpty(){
            return top == null;
        }
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek()); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.peek()); // 1
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop()); // 1
        System.out.println(stack.isEmpty()); // true
    }
}
