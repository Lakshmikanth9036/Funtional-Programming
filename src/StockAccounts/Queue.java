package StockAccounts;

import java.util.function.Consumer;

import StockAccounts.LinkedList.Node;

public class Queue<T> {
	class Node{
		T item;
		Node next;
		Node(T item){
			this.item = item;
		}
	}
	
	Node front;
	Node rear;

	public void enqueue(T item){
		Node node = new Node(item);
		
		if(front == null && rear == null ){
			front = node;
			rear = node;
		}
		
		else{
			rear.next = node;
			rear = node;	
		}
	}
	
	public T dequeue(){
		if(front == rear){
			T item = front.item;
			front = front.next;
			rear = rear.next;
			return item;
		}
		T item = front.item;
		front = front.next;
		return item;
	}
	
	public boolean isEmpty(){
		if(front == null && rear == null)
			return true;
		return false;
	}
	
	public int size(){
		int i = 0;
		Node n = front;
		while(n != null){
			i++;
			n = n.next;
		}
		return i;
	}
	
	public void forEach(Consumer<T> data){
		Node n = front;
		while(n!=null){
			data.accept(n.item);
			n=n.next;
		}
	}
	
	public String toString(){
		String s = "[";
		Node n = front;
		while(n != null){
			s = s+n.item;
			if(n.next != null)
				s = s+" "; 
			n = n.next;
		}
		return s+"]";
	}
}
