package model.data_structures;

import java.util.ArrayList;

/**
 * 
 * @author  ishaan007. Taken from https://github.com/ishaan007/Data-Structures/blob/master/HashMaps/Map.java
 *
 * @param <K> llave
 * @param <V> valor
 */
public class HashTable<K,V> {

	//Lista de valores que tienen la misma llave, salen del mismo lugar de la tabla hash

	ArrayList<NodoHash<K, V>> listaValores = new ArrayList<>();

	//Tamaño inicial de la tabla
	int M=10;
	//Tamaño ocupado de la tabla
	int size;

	//contructor
	public HashTable()
	{
		for(int i=0; i<M; i++)
		{
			listaValores.add(null);
		}
	}
	public int getSize()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	private int getHash(K key)
	{
		return (key.hashCode() & 0x7fffffff) % M;

	}
	public V get(K key)
	{
		int valorLlave = getHash(key);
		NodoHash<K, V> buscado = listaValores.get(valorLlave);
		while(buscado != null)
		{
			if(buscado.getKey().equals(key))
			{
				return buscado.getValue();
			}
			buscado=buscado.darSiguiente();
		}
		return null;	
	}
	public V remove(K key)
	{
		int valorLlave = getHash(key);
		NodoHash<K, V> buscado = listaValores.get(valorLlave);
		if(buscado == null)
		{
			return null;
		}
		if(buscado.getKey().equals(key))
		{
			V valor = buscado.getValue();
			buscado = buscado.darSiguiente();
			listaValores.set(valorLlave, buscado);
			size--;
			return valor;
		}
		else
		{
			NodoHash<K, V> prev = null;
			while(buscado != null)
			{

				if(buscado.getKey().equals(key))
				{
					prev.setSiguiente(buscado.darSiguiente());
					size--;
					return buscado.getValue();
				}
				prev = buscado;
				buscado = buscado.darSiguiente();
			}
			size--;
			return null;
		}
	}
	public void add(K key,V value)
	{

		int valorLlave = getHash(key);
		NodoHash<K, V> buscado = listaValores.get(valorLlave);
		NodoHash<K, V> nuevoElemento = new NodoHash<K, V>(key, value);
		if(buscado==null)
		{
			listaValores.set(valorLlave, nuevoElemento);
			size++;

		}
		else
		{
			while(buscado!=null)
			{
				if(buscado.getKey().equals(key))
				{
					buscado.setValue(value);
					size++;
					break;
				}
				buscado=buscado.darSiguiente();
			}
			if(buscado==null)
			{
				buscado=listaValores.get(valorLlave);
				nuevoElemento.setSiguiente(buscado);
				listaValores.set(valorLlave, nuevoElemento);
				size++;
			}
		}
		if((1.0*size)/M>0.7)
		{
			ArrayList<NodoHash<K, V>>tmp=listaValores;
			listaValores=new ArrayList<>();
			M=2*M;
			for(int i=0;i<M;i++)
			{
				listaValores.add(null);
			}
			for(NodoHash<K, V> headNode:tmp)
			{
				while(headNode!=null)
				{
					add(headNode.getKey(), headNode.getValue());
					headNode=headNode.darSiguiente();
				}

			}

		}

	}

}
