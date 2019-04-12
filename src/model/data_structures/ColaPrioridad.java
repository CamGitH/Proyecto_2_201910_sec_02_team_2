package model.data_structures;
import java.io.Serializable;
//Universidad de los Andes. Cupi2 Estructuras de datos. Cola Prioridad.
/**
 * Implementación de una cola de prioridad
 * @param <T> Tipo de datos que contiene cada nodo de la cola.
 * @param <E> Tipo de datos que se utilizara para darle la prioridad a los objetos de la cola. Los objetos de tipo T deben implentar la interface <b>Comparable</b> para poder
 *        realizar la inserción en la cola de forma correcta
 */
public class ColaPrioridad<T extends Comparable<? super T>> implements Serializable
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante para la serialización
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Primer elemento de la cola encadenada
	 */
	protected NodoColaPrioridad<T> primero;

	/**
	 * Ultimo elemento de la cola encadenada
	 */
	protected NodoColaPrioridad<T> ultimo;

	/**
	 * Número de elementos de la cola
	 */
	protected int numElems;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Constructor de la cola encadenada vacía. <br>
	 * <b>post: </b> Se construyó una cola vacía. primero==null, ultimo==null, numElems = 0<br>
	 */
	public ColaPrioridad( )
	{
		primero = null;
		ultimo = null;
		numElems = 0;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
	/**
	 * Retorna la longitud de la cola (número de elementos). <br>
	 * <b>post: </b> Se retornó la longitud de la cola<br>.
	 * @return El número de elementos de la cola. Entero positivo o cero.<br>
	 */
	public int darLongitud( )
	{
		return numElems;
	}

	/**
	 * Retorna el primer elemento y lo elimina de la cola. <br>
	 * <b>post: </b> Se retornó y eliminó el primer elemento de la cola. Si es el único elemento, el primero y el ultimo son null. La cantidad de los elementos se reduce en 1<br>
	 * @return El primer elemento de la cola. Diferente de null<br>
	 * @throws ColaVaciaException Si la cola no tiene elementos<br>
	 */
	public T tomarElemento( ) throws Exception
	{
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

	/**
	 * Inserta un elemento en la cola de acuerdo a su prioridad. <br>
	 * <b>pre: </b> elem!=null. <br>
	 * <b>post: </b> Se insertó el elemento en la cola de acuerdo a su prioridad.
	 * @param prioridad Elemento con el que se va a tomar la prioridad de la cola
	 * @param elem El elemento a ser insertado
	 */
	public void insertar(T elem, C Comparator )
	{
		NodoColaPrioridad<T> nodo = new NodoColaPrioridad<T>( elem );
		if( primero == null )
		{
			primero = nodo;
			ultimo = nodo;
		}
		// Verifica si tiene mayor prioridad que el primer elemento de la cola
		else if( primero.darElemento().compareTo(elem) < 0 )
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
				if( p.darSiguiente( ).darElemento().compareTo( elem ) < 0 )
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

	/**
	 * Retorna el primer nodo de la cola. Sin eliminarlo<br>
	 * <b>post: </b> Se retornó el primer nodo de la cola.
	 * @return El primer nodo de la cola
	 */
	public NodoColaPrioridad<T> darPrimero( )
	{
		return primero;
	}

	/**
	 * Retorna el último nodo de la cola. Sin eliminarlo<br>
	 * <b>post: </b> Se retornó el último nodo de la cola.<br>
	 * @return El último nodo de la cola<br>
	 */
	public NodoColaPrioridad<T> darUltimo( )
	{
		return ultimo;
	}

	/**
	 * Indica si la cola se encuentra vacía (no tiene elementos). <br>
	 * <b>post: </b> Se retornó true si primero==null o false en caso contrario.<br>
	 * @return True si primero==null o false en caso contrario<br>
	 */
	public boolean estaVacia( )
	{
		return primero == null;
	}

	/**
	 * Convierte la cola a un String. <br>
	 * <b>post: </b> Se retornó la representación en String de la cola. El String tiene el formato "[numeroElementos]: e1->e2->e3..->en", donde e1, e2, ..., en son los los
	 * elementos de la cola y numeroElementos su tamaño. <br>
	 * @return La representación en String de la cola
	 */
	@Override
	public String toString( )
	{
		String resp = "[" + numElems + "]:";
		for( NodoColaPrioridad<T> p = primero; p != null; p = p.darSiguiente( ) )
		{
			resp += "->" + p.toString( );
		}
		return resp;
	}

}