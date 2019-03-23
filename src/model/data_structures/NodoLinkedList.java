package model.data_structures;

/*
 *Clase del nodo
 */
public class NodoLinkedList<T> {

	private T elemento;

	private NodoLinkedList<T> anterior;

	private NodoLinkedList<T> siguiente;

	public NodoLinkedList( T pElemento )
	{
		elemento = pElemento;
		anterior = null;
		siguiente = null;

	}

	public T darElemento( )
	{
		return elemento;
	}
	
	public NodoLinkedList<T> darAnterior(){
		return anterior;
	}
	
	public NodoLinkedList<T> darSiguiente(){
		return siguiente;
	}
	
	public void cambiarAnterior(NodoLinkedList<T> ultimo){
		anterior =  ultimo;
	}
	
	public void cambiarSiguiente(NodoLinkedList<T> n){
		siguiente =  n;
	}
	
}