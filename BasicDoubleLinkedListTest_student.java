import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




class BasicDoubleLinkedListTest_student {
	
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Car> linkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public Car a=new Car("Volvo", "F150", 2002);
	public Car b=new Car("Mercedes-Benz", "Renegade", 2006);
	public Car c=new Car("Audi", "Civic", 2003);
	public Car d=new Car("Toyota", "Outback", 2007);
	
	public ArrayList<Car> fill = new ArrayList<Car>();
	
	@BeforeEach
	void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Dog");
		linkedString.addToEnd("Cat");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(20.0);
		linkedDouble.addToEnd(30.0);
		comparatorD = new DoubleComparator();
		
		linkedCar= new BasicDoubleLinkedList<Car>();
		linkedCar.addToEnd(b);
		linkedCar.addToEnd(c);
		comparatorCar = new CarComparator();
	
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedCar = null;
		comparatorD = null;
		comparator = null;
	}


	@Test
	void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
		assertEquals(2,linkedCar.getSize());
	}

	@Test
	void testAddToEnd() {
		
		assertEquals("Cat", linkedString.getLast());
		linkedString.addToEnd("Snake");
		assertEquals("Snake", linkedString.getLast());
		
		assertEquals(c,linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d,linkedCar.getLast());
	}

	@Test
	void testAddToFront() {
		assertEquals("Dog", linkedString.getFirst());
		linkedString.addToFront("Horse");
		assertEquals("Horse", linkedString.getFirst());
		
		assertEquals(b,linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a,linkedCar.getFirst());
	
	}

	@Test
	void testGetFirst() {
		assertEquals("Dog", linkedString.getFirst());
		linkedString.addToFront("Rat");
		assertEquals("Rat", linkedString.getFirst());
		
		assertEquals(b,linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a,linkedCar.getFirst());
	}

	@Test
	void testGetLast() {
		assertEquals("Cat", linkedString.getLast());
		linkedString.addToEnd("Rat");
		assertEquals("Rat", linkedString.getLast());
		
		assertEquals(c,linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d,linkedCar.getLast());
	}

	@Test
	void testRemove() {
		// remove the first
				assertEquals(b, linkedCar.getFirst());
				assertEquals(c, linkedCar.getLast());
				linkedCar.addToFront(a);
				assertEquals(a, linkedCar.getFirst());
				linkedCar.remove(a, comparatorCar);
				assertEquals(b, linkedCar.getFirst());
				//remove from the end of the list
				linkedCar.addToEnd(d);
				assertEquals(d, linkedCar.getLast());
				linkedCar.remove(d, comparatorCar);
				assertEquals(c, linkedCar.getLast());
				//remove from middle of list
				linkedCar.addToFront(a);
				assertEquals(a, linkedCar.getFirst());
				assertEquals(c, linkedCar.getLast());
				linkedCar.remove(b, comparatorCar);
				assertEquals(a, linkedCar.getFirst());
				assertEquals(c, linkedCar.getLast());
	}

	@Test
	void testRetrieveFirstElement() {
		assertEquals(b, linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(a, linkedCar.retrieveFirstElement());
		assertEquals(b,linkedCar.getFirst());
		assertEquals(b, linkedCar.retrieveFirstElement());
		assertEquals(c,linkedCar.getFirst());
		
		assertEquals("Dog", linkedString.getFirst());
		linkedString.addToFront("Rat");
		assertEquals("Rat", linkedString.getFirst());
		assertEquals("Rat", linkedString.retrieveFirstElement());
		assertEquals("Dog",linkedString.getFirst());
		assertEquals("Dog", linkedString.retrieveFirstElement());
		assertEquals("Cat",linkedString.getFirst());
	}

	@Test
	void testRetrieveLastElement() {
		assertEquals(c, linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d, linkedCar.getLast());
		assertEquals(d, linkedCar.retrieveLastElement());
		assertEquals(c,linkedCar.getLast());
		
		assertEquals("Cat", linkedString.getLast());
		linkedString.addToEnd("Rat");
		assertEquals("Rat", linkedString.getLast());
		assertEquals("Rat", linkedString.retrieveLastElement());
		assertEquals("Cat",linkedString.getLast());
	}

	@Test
	void testToArrayList() {
		ArrayList<Car> list;
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		list = linkedCar.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(d,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Snake");
		linkedString.addToEnd("Rat");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Snake", iterator.next());
		assertEquals("Dog", iterator.next());
		assertEquals("Cat", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Rat", iterator.next());
		
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
	}

	
	

	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//no more elements in list
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		
		try{
			//no more elements in list
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		
		{
			
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}

}
