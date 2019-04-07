package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArbolRojoN;


public class TestArbol {


	ArbolRojoN<String, Integer> arbol;
	
	@Before
	public void setUp(){
		arbol = new ArbolRojoN<String, Integer>();
		escenario1();
	}
	

	public void escenario1(){

		arbol.put("1", 1);
		arbol.put("2", 2);
		arbol.put("3", 3);
		arbol.put("4", 4);
		arbol.put("5", 5);
		arbol.put("6", 6);
	}
	
	@Test
	public void testSize() {
		int t = arbol.size();
		assertEquals(6, t);
		
	}
	@Test
	public void testMin(){
		String t = arbol.min();
		assertEquals("1", t);
	}
	@Test
	public void testMax(){
		String t = arbol.max();
		assertEquals("6", t);
	}
	@Test
	public void testSelect(){
		String t = arbol.select(5);
		assertEquals("6", t);
	}
	@Test
	public void testContains(){
		assertEquals(false, arbol.contains("7"));
		assertEquals(true, arbol.contains("2"));
	}
	@Test
	public void testGet(){
		int a = arbol.get("1");
		int b = arbol.get("3");
		int c = arbol.get("6");
		assertEquals(1, a);
		assertEquals(3, b);
		assertEquals(6, c);
		assertNull(null, arbol.get("20"));
	}
	@Test
	public void testSizeInRange(){
		
		int a = arbol.size("1", "6");
		assertEquals(6, a);
		
		int b = arbol.size("3", "3");
		assertEquals(1, b);
	}
	@Test
	public void testIsEmpty(){
		
		assertEquals(false, arbol.isEmpty());
		
		arbol.delete("1");
		arbol.delete("2");
		arbol.delete("3");
		arbol.delete("4");
		arbol.delete("5");
		arbol.delete("6");
		
		assertEquals(true, arbol.isEmpty());
		
		escenario1();
	}
	@Test
	public void testAllKeys(){
		Iterable<String> iter = arbol.keys();
		String text = iter.toString();
		assertEquals("[1, 2, 3, 4, 5, 6]", text);
	
	}
	@Test
	public void testRangeKeys(){
		Iterable<String> iter = arbol.keys("2", "5");
		String text = iter.toString();
		assertEquals("[2, 3, 4, 5]", text);
	
	}
	@Test
	public void testHeight(){
		int t = arbol.height();
		assertEquals(2, t);
	
	}
	@Test
	public void testDeleteMax(){
		arbol.deleteMax();;
		assertEquals(false, arbol.contains("6"));
	
	}
	@Test
	public void testDeleteMin(){
		arbol.deleteMin();;
		assertEquals(false, arbol.contains("1"));
	
	}
	
	
	
	
	

}
