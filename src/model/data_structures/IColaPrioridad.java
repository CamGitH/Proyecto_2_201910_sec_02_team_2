package model.data_structures;

public interface IColaPrioridad<T> {

int darNumElementos( );
	
	T tomarElemento( ) throws Exception;
	
	void agregar( T elemento );
	
	 boolean estaVacia( );
	 
	 T delMax ();
	
T max();

}
