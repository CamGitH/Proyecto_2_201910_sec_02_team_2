/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ColaPrioridadHeap;
import model.violations.VOMovingViolations;

/**
 * @author Tomás Langebaek
 */
public class TestColaPrioridad<T extends Comparable<T>> {
	
	ColaPrioridadHeap<T> cola;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cola = new ColaPrioridadHeap<>();
	}
	
	/**
	 * Test method for {@link model.data_structures.ColaPrioridadHeap#estaVacia()}.
	 */
	@Test
	public void testEstaVacia() {
		assertEquals(true, cola.estaVacia());
	}
	
	/**
	 * Test method for {@link model.data_structures.ColaPrioridadHeap#agregar(java.lang.Comparable)}.
	 */
	@Test
	public void testAgregar() {
		for(int i = 0; i<10;i++){
			VOMovingViolations infraccion = new VOMovingViolations("pObjectID"+i, "pRow", "pLocation", "pAddressID", "pStreetSeg", "pXCoor", "pYCoor", "pTicketType", "pFineAtm", "tOTALPAID", "pPenalty1", "pPenalty2", "pAccidentIndicator", "pTicketIssueDate", "pViolationCode", "pViolationDescription", "pRowID");
		cola.agregar(infraccion);
		}
	}

	/**
	 * Test method for {@link model.data_structures.ColaPrioridadHeap#tomarElemento()}.
	 */
	@Test
	public void testTomarElemento() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.data_structures.ColaPrioridadHeap#delMax()}.
	 */
	@Test
	public void testDelMax() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.data_structures.ColaPrioridadHeap#max()}.
	 */
	@Test
	public void testMax() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link model.data_structures.ColaPrioridadHeap#darNumElementos()}.
	 */
	@Test
	public void testDarNumElementos() {
		assertEquals(3, cola.darNumElementos());
	}

}
