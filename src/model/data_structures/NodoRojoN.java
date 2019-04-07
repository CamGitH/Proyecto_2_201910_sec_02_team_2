package model.data_structures;


public class NodoRojoN <V, K> {

	public static final boolean RED = true;
	public static final boolean BLACK = false;
	
	private boolean color;
	private NodoRojoN<V, K>  derecha, izq;
	private K key;
	private V value;
	 private int size; 
	
	public NodoRojoN(K k, V valor){
		
		key=k;
		value=valor;
		izq=null;
		derecha=null;
		color = RED;
	}
	
	
	
	public void asignarIzq(NodoRojoN<V, K>  nodo){
		izq=nodo;
	}
	
	public void asignarDer(NodoRojoN<V, K>  nodo){
		derecha=nodo;
	}
	
	public NodoRojoN<V, K>  darDerecha(){
		return derecha;
	}
	public NodoRojoN<V, K>  darIzq(){
		return izq;
	}
	
	public int peso(){	
		return 1;
	}
	
	
	public boolean darColor(){
		return color;
	}
	
	public void cambiarColor(){
		if (color==RED){
			color=BLACK;
		}else{color = RED;}
	}
	
	public void asignarColor(boolean col){
		color = col;
	}
	public K darLlave(){
		return key;
	}
	public V darValor(){
		return value;
	}
	
	public void asignarValor(V valor){
		value=valor;
	}
}
