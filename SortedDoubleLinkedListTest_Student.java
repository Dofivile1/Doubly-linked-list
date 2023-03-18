import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;







class SortedDoubleLinkedListTest_Student {
	
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Car> sortedLinkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	
	public Car a=new Car("AC", "Seres", 1949);
	public Car b=new Car("Acura", "Renegade", 2005);
	public Car c=new Car("Abarth", "Civic", 2005);
	
	


	@BeforeEach
	void setUp() throws Exception {
		
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorCar = new CarComparator();
		sortedLinkedCar = new SortedDoubleLinkedList<Car>(comparatorCar);
	}

	@AfterEach
	void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorCar = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedCar = null;
	}

	@Test
	void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Dog");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Cat");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedCar.add​(a);
		sortedLinkedCar.add​(b);
		sortedLinkedCar.add​(c);
	
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(false, iterator.hasNext());
	}


	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add​("Begin");
		sortedLinkedString.add​("World");
		sortedLinkedString.add​("Hello");
		sortedLinkedString.add​("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulCarPrevious() {
		
		sortedLinkedCar.add​(c);
		sortedLinkedCar.add​(b);
	
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
		
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());

		assertEquals(true, iterator.hasPrevious());

		assertEquals(b, iterator.previous());
		assertEquals(c, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add​((Double)8.0);
		sortedLinkedDouble.add​((Double)6.0);
		sortedLinkedDouble.add​((Double)1.0);
		sortedLinkedDouble.add​((Double)2.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)1.0, iterator.next());
		assertEquals((Double)2.0, iterator.next());
		assertEquals((Double)6.0, iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add​((Double)5.0);
		sortedLinkedDouble.add​((Double)10.0);
		sortedLinkedDouble.add​((Double)8.0);
		sortedLinkedDouble.add​((Double)2.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals((Double)2.0, iterator.next());
		assertEquals((Double)5.0, iterator.next());
		assertEquals((Double)8.0, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals((Double)8.0, iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		
		sortedLinkedCar.add​(c);
		sortedLinkedCar.add​(b);
	
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		
		assertEquals(true, iterator.hasNext());
		
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(false, iterator.hasNext());

		try{
			//no more elements in list
			iterator.next();
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
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedCar.add​(c);
		sortedLinkedCar.add​(b);
		
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
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
	@Test
	public void testAddCar() {
		//alphabetic order: e f a c b d
				sortedLinkedCar.add​(a);
				sortedLinkedCar.add​(b);
				sortedLinkedCar.add​(c);
				assertEquals(a, sortedLinkedCar.getFirst());
				assertEquals(b, sortedLinkedCar.getLast());
				
				
				//deletes Elephant from linked list
				
				assertEquals(b, sortedLinkedCar.getLast());
	}


	@Test
	public void testRemoveFirstCar() {
		
		sortedLinkedCar.add​(b);
		sortedLinkedCar.add​(c);
		assertEquals(c, sortedLinkedCar.getFirst());
		assertEquals(b, sortedLinkedCar.getLast());
		sortedLinkedCar.add​(a);
		assertEquals(a, sortedLinkedCar.getFirst());

		sortedLinkedCar.remove(a, comparatorCar);
		assertEquals(c, sortedLinkedCar.getFirst());
	}
	
	@Test
	public void testRemoveEndCar() {
		//alphabetic order: e f a c b d
		sortedLinkedCar.add​(b);
		

		assertEquals(b, sortedLinkedCar.getLast());
		
	
		//remove from the end of the list

		assertEquals(b, sortedLinkedCar.getLast());
	}

	@Test
	public void testRemoveMiddleCar() {
		//alphabetic order: e f a c b d
		sortedLinkedCar.add​(a);
		sortedLinkedCar.add​(b);
		assertEquals(a, sortedLinkedCar.getFirst());
		assertEquals(b, sortedLinkedCar.getLast());

	
		assertEquals(b, sortedLinkedCar.getLast());
		
		//remove from middle of list
		sortedLinkedCar.remove(a, comparatorCar);
		assertEquals(b, sortedLinkedCar.getLast());
		assertEquals(1,sortedLinkedCar.getSize());
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
			return arg0.getMake().compareTo(arg1.getMake());
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
