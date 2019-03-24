package model.data_structures;

public interface IArbolRN<T> extends Comparable<T>{
	
	boolean isRed(NodoRojoN nodo);
	
	int size (NodoRojoN nodo);
	
	int sizeTotal();
	
	boolean isEmpty();
	
	<K> void get(K key);
	
	<K> boolean contains(K key);
	
	NodoRojoN<Comparable<T>> put ();
	
	void deleteMin();
	
	void deleteMax();
	
	void delete();
	
	NodoRojoN rotateRight(NodoRojoN nodo);
	
	NodoRojoN rotateLeft(NodoRojoN nodo);
	
	void flipCollors(NodoRojoN nodo);
	
	void moveRedLeft(NodoRojoN nodo);
	
	void rotateRedRight(NodoRojoN nodo);
}
