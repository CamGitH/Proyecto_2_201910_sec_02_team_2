package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.HashTable;

public class TestHashTable<K,V> {

	private HashTable<Integer, String> tablaHash;


	public void setUp() throws Exception {
		tablaHash = new HashTable<Integer,String>();
	}

	public void escenario1(){
		try {
			setUp();
			for(int i = 0; i<20; i++){
				tablaHash.add(i, "valor"+i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	@Test
	public void testIsEmpty() {
		try {
			setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(true, tablaHash.isEmpty());
	}

	@Test
	public void testAdd() {
		//49 es el espacio esperado para el tamaño despues de insertar 20 elementos
		escenario1();
		assertEquals(49, tablaHash.getSize());
		
	}
	
	@Test
	public void testGet() {
		
		escenario1();
		
		assertEquals("valor1", tablaHash.get(1));
		assertEquals("valor5", tablaHash.get(5));
		assertEquals("valor8", tablaHash.get(8));
		assertEquals("valor15", tablaHash.get(15));
		
		tablaHash.add(1, "valor1dos");
		assertEquals("valor1dos", tablaHash.get(1));
		
	}

	@Test
	public void testRemove() {
		escenario1();
		
		tablaHash.remove(1);
		assertNull(tablaHash.get(1));
		
		tablaHash.remove(5);
		assertNull(tablaHash.get(5));
		
		tablaHash.remove(10);
		assertNull(tablaHash.get(10));
	}

	

}
