package model.data_structures;

import java.util.Iterator;

public interface IArbolRN<V,K extends Comparable<K>>{

	int size ();
	
	boolean isEmpty();
	
	V get(K key);
	
	int getHeight(K key);
	
	boolean contains(K key);
	
	void put(K key,V val);
	
	int height();
	
	K min();
	
	K max();
	
	boolean check();
	
	Iterator <K> keys();
	
	Iterator<V>valuesInRange(K init, K end);
	
	
	Iterator<K>keysInRange(K init, K end);
}
