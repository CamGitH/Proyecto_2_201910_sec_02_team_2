package model.logic;

import java.io.FileReader;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.data_structures.ArbolRojoN;
import model.data_structures.ColaPrioridadHeap;
import model.data_structures.HashTable;
import model.data_structures.IQueue;
import model.data_structures.LinkedList;
import model.data_structures.NodoLinkedList;
import model.vo.EstadisticaInfracciones;
import model.vo.EstadisticasCargaInfracciones;
import model.vo.InfraccionesFecha;
import model.vo.InfraccionesFechaHora;
import model.vo.InfraccionesFranjaHoraria;
import model.vo.InfraccionesFranjaHorariaViolationCode;
import model.vo.InfraccionesLocalizacion;
import model.vo.InfraccionesViolationCode;
import model.vo.VOMovingViolations;


public class MovingViolationsManager {

		//Lista Encadenada
		private LinkedList<VOMovingViolations> listaEncadenada;
		//Arbol Rojo Negro
		private ArbolRojoN<String, VOMovingViolations> arbolRojoNegroCoordenadas;
		//ColaPrioridad
		private ColaPrioridadHeap<VOMovingViolations> colaPrioridad;
		//HashTable
		private HashTable<Integer, VOMovingViolations> hashTable;
	
	/**
	 * Metodo constructor
	 */
	public MovingViolationsManager()
	{
		listaEncadenada = new LinkedList<>();
		arbolRojoNegroCoordenadas = new ArbolRojoN<>();
		colaPrioridad = new ColaPrioridadHeap<>();
		hashTable = new HashTable<>();
	}
	
	/**
	 * Cargar las infracciones de un semestre de 2018
	 * @param numeroSemestre numero del semestre a cargar (1 o 2)
	 * @return objeto con el resultado de la carga de las infracciones
	 */
	public EstadisticasCargaInfracciones loadMovingViolations(int numeroSemestre) {
		List<String[]> list = new ArrayList<String[]>();
		int uno=0,dos=0,tres=0,cuatro=0,s=0,ss=0;
		String u = null,d= null,t= null,c= null,i= null,e= null; 
		CSVReader reader =null;

		try{
			switch(numeroSemestre)
			{

			case 1:

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_January_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				uno=list.size();
				u="January";
				list.clear();

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_February_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				dos=list.size();
				d="February";
				list.clear();

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_March_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				tres=list.size();
				t="March";
				list.clear();

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_April_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				cuatro=list.size();
				c="April";
				list.clear();

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_May_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				s=list.size();
				i="May";
				list.clear();

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_June_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				ss=list.size();
				e="June";
				list.clear();



			case 2:

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_July_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				uno=list.size();
				u="July";
				list.clear();

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_August_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				dos=list.size();
				d="Agust";
				list.clear();

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_September_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				tres=list.size();
				t="September";
				list.clear();

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_October_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				cuatro=list.size();
				c="October";
				list.clear();

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_November_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				s=list.size();
				i="November";
				list.clear();

				reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_December_2018.csv")).withSkipLines(1).build();
				list = reader.readAll();
				readFiles(list);
				ss=list.size();
				e="December";
				list.clear();


			}
		}catch( Exception ee){

			ee.printStackTrace();

		}

		String[] infraccionesPorMes = {
		uno+" datos cargados en "+u+"."
		,dos+" datos cargados en "+d+"."
		,tres+" datos cargados en "+t+"."
		,cuatro+" datos cargados en "+c+"."
		,s+ " datos cargados en "+i+"."
		,ss+" datos cargados en "+e+"."};
		
		//TODO buscar min coord y max coord para X y Y. Y meterlo en las estadisticas como un arreglo de double[]
		double[] prueba = {1,2,3,4};	
		
		EstadisticasCargaInfracciones stat = 
				new EstadisticasCargaInfracciones(listaEncadenada.getSize(), 6, infraccionesPorMes, prueba);

		return stat;

	}

	public void readFiles(List<String[]> list){

		
		for(int i = 0;i<list.size()/10;i++){

			VOMovingViolations infraccion = new VOMovingViolations(
					Integer.parseInt(list.get(i)[0]),
					list.get(i)[2],
					list.get(i)[14],
					list.get(i)[9],
					list.get(i)[12],
					list.get(i)[16],
					list.get(i)[4],
					list.get(i)[3],
					Double.parseDouble(list.get(i)[5]),
					Double.parseDouble(list.get(i)[6]));  

		
			listaEncadenada.agregarIni(infraccion);
			arbolRojoNegroCoordenadas.put(infraccion.getXCoord()+"", infraccion);

		}
		System.out.println(listaEncadenada.darPrimero().darElemento().toString());

	}

	/**
	  * Requerimiento 1A: Obtener el ranking de las N franjas horarias
	  * que tengan más infracciones. 
	  * @param int N: Número de franjas horarias que tienen más infracciones
	  * @return Cola con objetos InfraccionesFranjaHoraria
	  */
	public IQueue<InfraccionesFranjaHoraria> rankingNFranjas(int N)
	{
		// TODO completar
		return null;		
	}
	
	/**
	  * Requerimiento 2A: Consultar  las  infracciones  por
	  * Localización  Geográfica  (Xcoord, Ycoord) en Tabla Hash.
	  * @param  double xCoord : Coordenada X de la localizacion de la infracción
	  *			double yCoord : Coordenada Y de la localizacion de la infracción
	  * @return Objeto InfraccionesLocalizacion
	  */
	public InfraccionesLocalizacion consultarPorLocalizacionHash(double xCoord, double yCoord)
	{
		// TODO completar
		return null;		
	}
	
	/**
	  * Requerimiento 3A: Buscar las infracciones por rango de fechas
	  * @param  LocalDate fechaInicial: Fecha inicial del rango de búsqueda
	  * 		LocalDate fechaFinal: Fecha final del rango de búsqueda
	  * @return Cola con objetos InfraccionesFecha
	  */
	public IQueue<InfraccionesFecha> consultarInfraccionesPorRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal)
	{
		// TODO completar
		return null;		
	}
	
	/**
	  * Requerimiento 1B: Obtener  el  ranking  de  las  N  tipos  de  infracción
	  * (ViolationCode)  que  tengan  más infracciones.
	  * @param  int N: Numero de los tipos de ViolationCode con más infracciones.
	  * @return Cola con objetos InfraccionesViolationCode con top N infracciones
	  */
	public IQueue<InfraccionesViolationCode> rankingNViolationCodes(int N)
	{
		// TODO completar
		return null;		
	}

	
	/**
	  * Requerimiento 2B: Consultar las  infracciones  por  
	  * Localización  Geográfica  (Xcoord, Ycoord) en Arbol.
	  * @param  double xCoord : Coordenada X de la localizacion de la infracción
	  *			double yCoord : Coordenada Y de la localizacion de la infracción
	  * @return Objeto InfraccionesLocalizacion
	  */
	public InfraccionesLocalizacion consultarPorLocalizacionArbol(String xCoord, String yCoord)
	{
		int i = 0;
		int j = 0;
		
		VOMovingViolations[] listaTodos = {VOMovingViolations v = new};
		VOMovingViolations[] listaBuscados = null;
		
		while(arbolRojoNegroCoordenadas.get(xCoord)!=null){
			
		VOMovingViolations infraccion = arbolRojoNegroCoordenadas.get(xCoord);
		arbolRojoNegroCoordenadas.delete(xCoord);
		listaTodos[i] = infraccion;
		i++;
		
		if((infraccion.getYCoord()+"").equals(yCoord)){
			listaBuscados[j] = infraccion;
			j++;
		}
		}
		for(int k = 0; k<listaTodos.length;k++){
			arbolRojoNegroCoordenadas.put(listaTodos[k].getXCoord()+"", listaTodos[k]);
		}

		InfraccionesLocalizacion info = new InfraccionesLocalizacion(xCoord, yCoord, listaBuscados[0].getLocation(), listaTodos[0].getAddressId(), listaBuscados[0].getStreetSegId(), listaBuscados);
		return null;		
	}
	
	/**
	  * Requerimiento 3B: Buscar las franjas de fecha-hora donde se tiene un valor acumulado
	  * de infracciones en un rango dado [US$ valor inicial, US$ valor final]. 
	  * @param  double valorInicial: Valor mínimo acumulado de las infracciones
	  * 		double valorFinal: Valor máximo acumulado de las infracciones.
	  * @return Cola con objetos InfraccionesFechaHora
	  */
	public IQueue<InfraccionesFechaHora> consultarFranjasAcumuladoEnRango(double valorInicial, double valorFinal)
	{
		// TODO completar
		return null;		
	}
	
	/**
	  * Requerimiento 1C: Obtener  la información de  una  addressId dada
	  * @param  int addressID: Localización de la consulta.
	  * @return Objeto InfraccionesLocalizacion
	  */
	public InfraccionesLocalizacion consultarPorAddressId(int addressID)
	{
		// TODO completar
		return null;		
	}
	
	/**
	  * Requerimiento 2C: Obtener  las infracciones  en  un  rango de
	  * horas  [HH:MM:SS  inicial,HH:MM:SS  final]
	  * @param  LocalTime horaInicial: Hora  inicial del rango de búsqueda
	  * 		LocalTime horaFinal: Hora final del rango de búsqueda
	  * @return Objeto InfraccionesFranjaHorariaViolationCode
	  */
	public InfraccionesFranjaHorariaViolationCode consultarPorRangoHoras(LocalTime horaInicial, LocalTime horaFinal)
	{
		// TODO completar
		return null;		
	}
	
	/**
	  * Requerimiento 3C: Obtener  el  ranking  de  las  N localizaciones geográficas
	  * (Xcoord,  Ycoord)  con  la mayor  cantidad  de  infracciones.
	  * @param  int N: Numero de las localizaciones con mayor número de infracciones
	  * @return Cola de objetos InfraccionesLocalizacion
	  */
	public IQueue<InfraccionesLocalizacion> rankingNLocalizaciones(int N)
	{
		// TODO completar
		return null;		
	}
	
	/**
	  * Requerimiento 4C: Obtener la  información  de  los códigos (ViolationCode) ordenados por su numero de infracciones.
	  * @return Contenedora de objetos InfraccionesViolationCode.
	  // TODO Definir la estructura Contenedora
	  */
//	public Contenedora<InfraccionesViolationCode> ordenarCodigosPorNumeroInfracciones()
//	{
//		// TODO completar
//		// TODO Definir la Estructura Contenedora
//		return null;		
//	}


}
