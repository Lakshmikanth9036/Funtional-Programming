package StockAccounts;

import java.util.function.Consumer;

import StockAccounts.LinkedList.Node;

public class Stack<T>{
	
	public class Node{
		T data;
		Node next;
		public Node(T data){
			this.data = data;
		}
	}
	
	Node top;

	public void push(T item){
		Node node = new Node(item);
		if(top == null){
			top = node;
		}
		else{
			node.next = top;
			top = node;
		}
	}
	
	public T pop(){
		if(top == null){
			throw new IndexOutOfBoundsException("Stack Underflow");
		}
		
		T item = top.data;
		top = top.next;
		return item;
	}
	
	public T peek(){
		if(top == null){
			throw new IndexOutOfBoundsException("Stack Empty");
		}
		T item = top.data;
		return item;
	}
	
	public boolean isEmpty(){
		if(top == null)
			return true;
		return false;
	}
	
	public int size(){
		Node n = top;
		int i = 0;
		while(n!=null){
			i++;
			n = n.next;
		}
		return i;
	}
	
	public void forEach(Consumer<T> data){
		Node n = top;
		while(n!=null){
			data.accept(n.data);
			n=n.next;
		}
	}
	
	public String toString() {
		String s = "[";
		Node n = top;
		while (n != null) {
			s = s + n.data;
			if (n.next != null)
				s = s + " ";
			n = n.next;
		}
		return s + "]";
	}
}
