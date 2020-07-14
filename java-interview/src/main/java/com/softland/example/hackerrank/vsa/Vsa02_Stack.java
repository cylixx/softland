package com.softland.example.hackerrank.vsa;

//stack
class Node<T> {
	T value;
	Node<?> next;
	Node<?> before;

	public Node(T value) {
		this.value = value;
	}
}

public class Vsa02_Stack<T> {
	public Node top;

	public Node push(T data) {

		Node peek = peek();
		if (peek == null) {
			top = new Node(data);
			top.next = null;
			top.before = null;

		} else {
			Node n = new Node(data);
			n.before = top;
			n.next = null;
			top = n;
		}
		return top;
	}

	public Node peek() {
		return top;
	}

	public Node pop() {

		if (top == null)
			return null;

		Node n = top;
		top = n.before;
		top.next = null;

		return n;
	}

	public static void print(Node n) {
		while (n != null) {
			System.out.println(n.value);
			n = n.before;
		}
	}

	public static void main(String[] args) {
		Vsa02_Stack<Integer> s = new Vsa02_Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		print(s.top);

		System.out.println("peek:" + s.peek().value);
		System.out.println("pop: " + s.pop().value);
		System.out.println("pop: " + s.pop().value);
		print(s.top);
		
	}

}
