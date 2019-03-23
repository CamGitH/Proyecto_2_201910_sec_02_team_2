/**
 * 
 */
package test;

import static org.junit.Assert.*;
import org.junit.Test;
import model.data_structures.ColaPrioridadHeap;
import model.violations.VOMovingViolation;

/**
 * @author Tomás Langebaek
 */
public class TestColaPrioridad<T extends Comparable<T>> {

	ColaPrioridadHeap<T> cola;

	private ColaPrioridadHeap<Integer> colaheap;

	public void setUp(){

		colaheap = new ColaPrioridadHeap<Integer>();

	}

	//		colaheap.insert(new VOMovingViolation("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1") );
	//		colaheap.insert(new VOMovingViolation("2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2") );
	//		colaheap.insert(new VOMovingViolation("3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3") );
	//		colaheap.insert(new VOMovingViolation("4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4") );


	public void escenario1(){

		colaheap.insert(3);
		colaheap.insert(1);
		colaheap.insert(2);
		colaheap.insert(4);

	}
	public void escenario2(){

		colaheap.insert(1);
		colaheap.insert(2);
		colaheap.insert(3);
		colaheap.insert(4);


	}
	@Test
	public void testAgregar() {
		setUp();
		
		try {
			
			escenario1();
			
			int num1 = colaheap.delMax();
			assertEquals(4, num1);

			int num2 = colaheap.delMax();
			assertEquals(3, num2);

			int num3 = colaheap.delMax();
			assertEquals(2, num3);

			int num4 = colaheap.delMax();
			assertEquals(1, num4);

			escenario2();

			int num5 = colaheap.delMax();
			assertEquals(4, num5);

			int num6 = colaheap.delMax();
			assertEquals(3, num6);

			int num7 = colaheap.delMax();
			assertEquals(2, num7);

			int num8 = colaheap.delMax();
			assertEquals(1, num8);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelMax() {
		setUp();
		escenario2();

		try {

			colaheap.delMax();
			colaheap.delMax();
			colaheap.delMax();
			colaheap.delMax();
			
			assertNull(colaheap.delMax());
			
			escenario2();
			
			colaheap.delMax();
			int num1 = colaheap.delMax();
			assertEquals(3, num1);

			colaheap.delMax();
			int num2 = colaheap.delMax();
			assertEquals(1, num2);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}




}
