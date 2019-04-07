package model.data_structures;

<<<<<<< HEAD
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
=======
public interface IArbolRN<K, V>{
	
	boolean darColor(NodoRojoN<V, K> nodo);
	
	int size (NodoRojoN<V, K> nodo);
	
	int sizeTotal();
	
	boolean isEmpty();
	
	NodoRojoN<V, K> buscar(K key);
	
	//boolean contains(K key);
	
	void add (V valor, K llave);
	
	//void deleteMin();
	
	//void deleteMax();
	
	void delete(NodoRojoN<V, K> nodo);
	
	void rotateRight(NodoRojoN<V, K> nodo);
	
	void rotateLeft(NodoRojoN<V, K> nodo);
	
	void flipCollors(NodoRojoN<V, K> nodo);
	
//	void moveRedLeft(NodoRojoN<V, K> nodo);
//	
//	void rotateRedRight(NodoRojoN<V, K> nodo);
>>>>>>> 1d4c3924e3d35b0c8a81bc2e3158dc552e4e2e6c
}
