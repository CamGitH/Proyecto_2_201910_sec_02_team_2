package model.data_structures;

public class ArbolRojoN<V, K extends Comparable<K>> implements IArbolRN<K , V>{

	private NodoRojoN<V, K> raiz;

	@Override
	public boolean darColor(NodoRojoN<V, K> nodo) {
		return nodo.darColor();
	}

	@Override
	public int size(NodoRojoN<V, K> nodo) {
		int i=0,d=0;
		if(nodo.darDerecha()!=null){
			i=size(nodo.darIzq());
		}
		if(nodo.darDerecha()!=null){
			d=size(nodo.darDerecha());
		}
		return nodo.peso()+i+d;
	}

	@Override
	public int sizeTotal() {
		return size(raiz);
	}

	@Override
	public boolean isEmpty() {
		if(sizeTotal()==0){
			return true;
		}
		return false;
	}

	@Override
	public void delete(NodoRojoN<V, K> nodo) {
		NodoRojoN<V, K> b = buscar(nodo.darLlave());
		//
	}

	@Override
	public void rotateRight(NodoRojoN<V, K> nodo) {
		NodoRojoN<V, K> x = nodo.darIzq();
		nodo.asignarIzq(x.darDerecha());
		x.asignarDer(nodo);
		x.asignarColor(nodo.darColor());
		nodo.asignarColor(true);// true es rojo
	}

	@Override
	public void rotateLeft(NodoRojoN<V, K> nodo) {

		NodoRojoN<V, K> x = nodo.darDerecha();
		nodo.asignarDer(x.darIzq());
		x.asignarIzq(nodo);
		x.asignarColor(nodo.darColor());
		nodo.asignarColor(true);//true es rojo

	}

	@Override
	public void flipCollors(NodoRojoN<V, K> nodo) {
		{
			nodo.cambiarColor();
			nodo.darDerecha().cambiarColor();
			nodo.darIzq().cambiarColor();
		}

	}

	//	@Override
	//	public void moveRedLeft(NodoRojoN<V, K> nodo) {
	//		// TODO Auto-generated method stub
	//		
	//	}
	//
	//	@Override
	//	public void rotateRedRight(NodoRojoN<V, K> nodo) {
	//		// TODO Auto-generated method stub
	//	
	//	}


	@Override
	public void add(V valor, K llave) {

		if (buscar(llave)==null){ // Do standard insert, with red link to parent.

			if(buscar(llave)==null){
				NodoRojoN<V, K> h = new NodoRojoN<>(llave, valor);
				NodoRojoN<V, K> este = raiz;
				boolean done = false;
				while (!done){
					if (este.darDerecha()!=null){
						este=este.darDerecha();
					}
					if (este.darIzq()!=null){
						este=este.darIzq();
					}
					if (este.darDerecha()==null){
						este=este.darDerecha();
						done=true;
					}
				 if (este.darIzq()==null){
						este=este.darIzq();
						done=true;
					}
				}
			}
			//ESTO ES DEL LIBRO
			//			int cmp = llave.compareTo(h.key);
			//			
			//			if (cmp < 0) {
			//				h.left = put(h.left, key, val);
			//			}
			//			else if (cmp > 0) {
			//				h.right = put(h.right, key, val);
			//			}
			//			if (isRed(h.right) && !isRed(h.left)) {
			//				h = rotateLeft(h);
			//			}
			//			if (isRed(h.left) && isRed(h.left.left)) {
			//				h = rotateRight(h);
			//			}
			//			if (isRed(h.left) && isRed(h.right)){
			//				flipColors(h);
		}else{ 
			NodoRojoN<V, K> n=buscar(llave);
			n.asignarValor(valor);
		}

		//		NodoRojoN<V, K> nodo = new NodoRojoN<>(llave, valor);
		//		if (raiz!=null){
		//			if(llave.compareTo(raiz.darLlave())>0){
		//				
		//			}else if(llave.compareTo(raiz.darLlave())<0){
		//				
		//			}else{
		//				raiz.asignarDer(nodo);
		//			}
		//		}
		//		else{raiz = nodo;
		//		}
	}

	@Override
	public NodoRojoN<V, K> buscar(K key) {
		NodoRojoN<V, K> este = raiz;
		while(este!=null){
			if (key.compareTo(este.darLlave())>0){
				este=este.darDerecha();
			}
			else if (key.compareTo(este.darLlave())<0){
				este=este.darIzq();
			}
			else {
				return este;
			}
		}
		return este;
	}
}
