package model.data_structures;

public class NodoRojoN <T extends Comparable<T>> {

	private T elemento;
	private boolean rojo;
	private boolean negro;
	private NodoRojoN<T> derecha;
	private NodoRojoN<T> izq;
	
	public NodoRojoN(T elemen){
		
		elemento=elemen;
		izq=null;
		derecha=null;
		rojo = true;
		rojo=false;
	}
	
	
	public void asignarIzq(NodoRojoN nodo){
		izq=nodo;
	}
	
	public void asignarDer(NodoRojoN nodo){
		derecha=nodo;
	}
	
	public NodoRojoN<T> darDerecha(){
		return derecha;
	}
	public NodoRojoN<T> darIzq(){
		return izq;
	}
	
	public boolean isRed(){
		boolean r = false;
		if (this.rojo){
			r=true;
		}
		return r;
	}
	
	public int size(){
		int tam = 1;
		return tam;
	}
	
}
