package model.data_structures;

public class NodoHash<K,V> {

		private K key;
		private V value;
		private NodoHash<K, V> siguiente;
		
		public NodoHash(K pKey, V pValue)
		{
			key=pKey;
			value=pValue;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public NodoHash<K, V> darSiguiente() {
			return siguiente;
		}

		public void setSiguiente(NodoHash<K, V> siguiente) {
			this.siguiente = siguiente;
		}

}
