import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;




public class BasicDoubleLinkedList<T> implements Iterable <T> {
	
	protected Node<T> head;
	protected Node<T> tail;
	protected int size;
	
	
	
	// Inner Node class
	
	protected class Node<T>{
		
		protected T data;
		protected Node<T> next;
		protected Node<T> prev;
		
		protected Node(Node<T> prev, T data, Node <T> next){
			this.data=data;
			this.next=next;
			this.prev=prev;
		}
	}
	
	// Inner DoubleLinkedListIterator class
	
	protected class DoubleLinkedListIterator<T> implements ListIterator<T>{
		
		protected Node current;
		protected Node rear;
		
		protected DoubleLinkedListIterator() {
			current=head;
			rear=null;
		}

		@Override
		public boolean hasNext() {
			
			return current!=null;
		}

		@Override
		public T next() throws NoSuchElementException {
			
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			T returnData= (T) current.data;
			rear=current;
			current=current.next;
			
			if(hasNext()) {
				current.prev=rear;
			}
			return returnData;
			
		}

		@Override
		public boolean hasPrevious() {
			return rear!=null;
		}

		@Override
		public T previous() throws NoSuchElementException{
			
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			current = rear;
			rear= current.prev;
			T returnData = (T)current.data;
			return returnData;
			
			
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	
	
	
	// Methods for BasicDoubleLinkedList class
	
	public BasicDoubleLinkedList() {
		this.head=null;
		this.tail=null;
		this.size=0;
		
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	
	public void addToEnd(T data) {
		if(head==null) {
			head= new Node<T>(null, data, null);
		}else {
			Node<T> current=head;
			
			while(current.next!=null) {
				current=current.next;
			}
			
			Node<T> new_node = new Node<T>(current,data,null);
			
			current.next=new_node;
			tail= new_node;
			
			
		}
		size++;
	}
	
	public void addToFront(T data) {
		if(head== null) {
			head= new Node<T>(null, data, null);
		}else {
			Node<T> new_node= new Node<T>(null, data, head);
			head.prev=new_node;
			head=new_node;
		}
		size++;
	}
	
	public T getFirst() {
		return head.data;
		
	}
	
	public T getLast() {
		return tail.data;
		
	}
	
	
	

public Node<T> remove(T targetData, Comparator<T> comparator) {
		

	Node <T>prev = null;
	Node <T>current = head;
	
	while (current != null) {
		if (comparator.compare(current.data, targetData) == 0) {
			if (current == head) {
				head = head.next;
				current = head;
			} else if (current == tail) {
				current = null;
				tail = prev;
				prev.next = null;
			} else {
				current.prev.next=current.next;
				current=current.next;
				current.next=current.next;
			}
			size--;
		} else {
			prev = current;
			current = current.next;
		}
	}
	return current;

}
	
	public T retrieveFirstElement() {
		if(head==null) {
			return null;
		}else {
			Node<T> first_element=new Node<T>(null,head.data,null);
			
			Node<T> new_head=head.next;
			head.next=null;
			new_head.prev=null;
			head=new_head;
			size--;
			
			return (T)first_element.data;
			
		}
		
		
	}

	public T retrieveLastElement() {
		if (head == null) {

			return null;
		}
		Node<T> current = head;
		Node<T> previous = null;

		while (current != null) {
			if (current==tail) {
				tail = previous;
				break;
			}
			previous = current;
			current = current.next;
		}
		size--;
		return (T)current.data;


	}
	
	public ArrayList<T> toArrayList(){
		
		ArrayList<T> list= new ArrayList<>();
		
		Node <T>current=head;
		while(current!=null) {
			Node <T>node= new Node<T>(null,current.data,null);
			list.add( node.data);
			current=current.next;
		}
		
		return list;
	}

	

	@Override
	public ListIterator<T> iterator() {
		
		
		return new DoubleLinkedListIterator<T>();
	}

}
