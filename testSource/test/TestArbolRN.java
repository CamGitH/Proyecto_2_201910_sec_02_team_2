package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.data_structures.ArbolRojoN;
import model.data_structures.ColaPrioridadHeap;

public class TestArbolRN<V, K> {

	ArbolRojoN<Integer, Integer> arbol;
	
	public void setUp(){
		arbol = new ArbolRojoN<Integer, Integer>();
	}
	

	public void escenario1(){

		arbol.add(1, 1);
		arbol.add(2, 2);
		arbol.add(3, 3);
		arbol.add(4, 4);
		arbol.add(5, 5);
		arbol.add(6, 6);
	}
	
	@Test
	public void test() {
		escenario1();
		int t = arbol.sizeTotal();
		assertEquals(3, t);
		
	}

}
