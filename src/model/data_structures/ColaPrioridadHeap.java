package model.data_structures;

public class ColaPrioridadHeap <T extends Comparable<T>> implements IColaPrioridad<T>{

	protected NodoColaPrioridad<T> primero;

	protected NodoColaPrioridad<T> ultimo;
	
	protected int numElems;
	
	public int darNumElementos() {
		return numElems;
	}

	@Override
	public T tomarElemento() throws Exception {
		if( primero == null )
			throw new Exception( "No hay elementos en la cola" );
		else
		{
			NodoColaPrioridad<T> p = primero;
			primero = primero.desconectarPrimero( );
			if( primero == null )
				ultimo = null;
			numElems--;
			return p.darElemento( );
		}
	}

	@Override
	public void agregar(T elemento) {
		NodoColaPrioridad<T> nodo = new NodoColaPrioridad<T>( elemento );
		if( primero == null )
		{
			primero = nodo;
			ultimo = nodo;
		}
		// Verifica si tiene mayor prioridad que el primer elemento de la cola
		else if( primero.darElemento().compareTo(elemento) < 0 )
		{
			nodo.insertarDespues( primero );
			primero = nodo;
		}
		else
		{
			// Recorre la cola hasta encontrar un nodo de menor prioridad
			boolean inserto = false;
			for( NodoColaPrioridad<T> p = primero; !inserto && p.darSiguiente( ) != null; p = p.darSiguiente( ) )
			{
				if( p.darSiguiente( ).darElemento().compareTo( elemento ) < 0 )
				{
					nodo.insertarDespues( p.darSiguiente( ) );
					p.insertarDespues( nodo );
					inserto = true;
				}
			}
			if( !inserto )
			{
				// No lo ha insertado porque tiene la menor prioridad de toda la cola
				ultimo = ultimo.insertarDespues( nodo );
			}
		}
		numElems++;
		
	}

	@Override
	public boolean estaVacia() {
		return primero == null;
	}

	@Override
	public T delMax() {
		primero=primero.darSiguiente();
		return null;
	}

	@Override
	public T max() {
		return primero.darElemento();
}
	
}
