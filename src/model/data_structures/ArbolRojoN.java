package model.data_structures;

public class ArbolRojoN<T> implements IArbolRN<T>{

	NodoRojoN raiz = null;
	
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRed(NodoRojoN nodo) {
		return nodo.isRed();
	}

	@Override
	public int size(NodoRojoN nodo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sizeTotal() {
		return raiz.size();
	}

	@Override
	public boolean isEmpty() {
		if(sizeTotal()==0){
			return true;
		}
		return false;
	}

	@Override
	public <K> void get(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K> boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NodoRojoN<Comparable<T>> put() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NodoRojoN rotateRight(NodoRojoN nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoRojoN rotateLeft(NodoRojoN nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flipCollors(NodoRojoN nodo) {
		if (nodo.isRed()){
			nodo.
		}
		
	}

	@Override
	public void moveRedLeft(NodoRojoN nodo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotateRedRight(NodoRojoN nodo) {
		// TODO Auto-generated method stub
	
	}

}
