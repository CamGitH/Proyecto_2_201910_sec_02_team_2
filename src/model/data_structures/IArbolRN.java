package model.data_structures;

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
}
