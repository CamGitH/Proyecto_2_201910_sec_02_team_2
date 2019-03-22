package model.data_structures;

public class NodoColaPrioridad <T extends Comparable<? super T>>{
	
	
	private T elemento;


	private NodoColaPrioridad<T> sigNodo;

	

	public NodoColaPrioridad(T pElemento )
	{
		elemento = pElemento;
		sigNodo = null;
	}

	
	public T darElemento( )
	{
		return elemento;
	}

	
	public NodoColaPrioridad<T> desconectarPrimero( )
	{
		NodoColaPrioridad<T> p = sigNodo;
		sigNodo = null;
		return p;
	}


	public NodoColaPrioridad<T> insertarDespues( NodoColaPrioridad<T> nodo )
	{
		sigNodo = nodo;
		return nodo;
	}


	public NodoColaPrioridad<T> darSiguiente( )
	{
		return sigNodo;
	}

	
	@Override
	public String toString( )
	{
		return "(" + elemento.toString( ) + ")";
}
	
}
