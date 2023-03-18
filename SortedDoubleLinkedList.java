import java.util.Comparator;
import java.util.ListIterator;



public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	
	private Comparator<T> c;

	public SortedDoubleLinkedList(Comparator<T> c) {
		this.c= c;
	}
	
	public void add(T data) {
		
		if(data!=null) {
			Node<T> new_node= new Node<T>(null, data, null);
			
			if( head == null) {
				head=new_node;
				tail= new_node;
			}else if( c.compare(data, head.data)<=0){
				new_node.next=head;
				head=new_node;
			}else if(c.compare(data, tail.data)>=0){
				tail.next=new_node;
				tail=new_node;
			}else {
				Node <T>current = head.next;
				Node <T> prev = head;
				while (c.compare(data, current.data) > 0) {
				prev = current;
				current = current.next;
				}
				prev.next = new_node;
				new_node.next = current;
			}
			size++;
				
			}
				
				
			
		
	
		
	}
	
   @Override
 	
	public void addToEnd(T data)  {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	@Override
	public void addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
		
	
	@Override
	public ListIterator<T> iterator(){
		
		return new DoubleLinkedListIterator<T>();
		
	}
		
	
	@Override
	public Node remove(T data,Comparator<T> comparator) {

		Node<T> next = head;
		Node prev = null;
		while (next != null) {
			if (comparator.compare(next.data, data) == 0) {
				size--;
				if (prev != null) {
					prev.next = next.next;
				} else {
					head = next.next;
				}
				if (next == tail) {
					tail = prev;
				}
			}
			prev = next;
			next = next.next;
		}

		return next;


	
	

}
	}
