package StockAccounts;

import java.util.function.Consumer;

public class LinkedList<T> {
	class Node {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
		}
	}

	Node head;

	public void add(T item) {
		Node node = new Node(item);
		if (head == null)
			head = node;
		else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}

	public void remove(T item) {
		Node current = head;
		Node previous = null;

		if (head.data.equals(item)) {
			head = head.next;
		} else {
			while (!current.data.equals(item)) {
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
		}
	}

	public boolean search(T item) {
		Node n = head;
		while (n != null) {
			if (n.data.equals(item))
				return true;
			n = n.next;
		}
		return false;
	}

	public int index(T item) {
		int i = 0;
		Node n = head;
		while (n != null) {
			if (n.data.equals(item))
				return i;
			i++;
			n = n.next;
		}
		return -1;
	}

	public void insert(int pos, T item) {
		Node node = new Node(item);
		Node n = head;
		if (pos == 0) {
			node.next = head;
			head = node;
		} else {
			for (int i = 0; i < pos - 1; i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
	}

	public T pop() {
		Node c = head;
		Node p = null;
		if (head.next == null) {
			T item = head.data;
			head = head.next;
			return item;
		}
		while (c.next != null) {
			p = c;
			c = c.next;
		}
		T item = c.data;
		p.next = null;
		return item;
	}

	public T pop(int pos) {
		Node n = head;
		if (pos == 0) {
			T data = head.data;
			head = head.next;
			return data;
		} else {
			for (int i = 0; i < pos - 1; i++) {
				n = n.next;
			}
			T item = n.next.data;
			n.next = n.next.next;
			return item;
		}
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public int size() {
		Node n = head;
		int size = 0;
		while (n != null) {
			n = n.next;
			size++;
		}
		return size;
	}

	
	public void forEach(Consumer<T> data){
		Node n = head;
		while(n!=null){
			data.accept(n.data);
			n=n.next;
		}
	}

	public String toString() {
		String s = "[";
		Node n = head;
		while (n != null) {
			s = s + n.data;
			if (n.next != null)
				s = s + " ";
			n = n.next;
		}
		return s + "]";
	}
}
