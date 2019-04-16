package model.logic;

import java.io.FileReader;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.data_structures.ArbolRojoN;
import model.data_structures.ArregloDinamico;
import model.data_structures.ColaPrioridad;
import model.data_structures.ColaPrioridadHeap;
import model.data_structures.HashTable;
import model.data_structures.IQueue;
import model.data_structures.LinkedList;
import model.data_structures.Nodo;
import model.data_structures.NodoLinkedList;
import model.data_structures.Queue;
import model.sort.Sort;
import model.vo.EstadisticaInfracciones;
import model.vo.EstadisticasCargaInfracciones;
import model.vo.InfraccionesFecha;
import model.vo.InfraccionesFechaHora;
import model.vo.InfraccionesFranjaHoraria;
import model.vo.InfraccionesFranjaHorariaViolationCode;
import model.vo.InfraccionesLocalizacion;
import model.vo.InfraccionesLocalizacion2;
import model.vo.InfraccionesViolationCode;
import model.vo.VOMovingViolations;


public class MovingViolationsManager {

	//Lista Encadenada
	private LinkedList<VOMovingViolations> listaEncadenada;
	//Arbol Rojo Negro
	private ArbolRojoN<String, VOMovingViolations> arbolRojoNegro;
	//ColaPrioridad
	private ColaPrioridadHeap<VOMovingViolations> colaPrioridad;
	//HashTable
	private HashTable<Integer, VOMovingViolations> hashTable;

	private Sort sort;

	private Comparable<VOMovingViolations> [ ] comparables;

	/**
	 * Metodo constructor
	 */
	public MovingViolationsManager()
	{
		listaEncadenada = new LinkedList<>();
		arbolRojoNegro = new ArbolRojoN<>();
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
					Double.parseDouble(list.get(i)[6]),
					list.get(i)[14]);  



			listaEncadenada.agregarIni(infraccion);
			arbolRojoNegro.put(infraccion.objectId()+"", infraccion);

		}

	}

	/**
	 * Requerimiento 1A: Obtener el ranking de las N franjas horarias
	 * que tengan m�s infracciones. 
	 * @param int N: N�mero de franjas horarias que tienen m�s infracciones
	 * @return Cola con objetos InfraccionesFranjaHoraria
	 */
	public Queue<InfraccionesFranjaHoraria> rankingNFranjas(int n)
	{		
		if(n==24) {
			n =0;
		}
		String s = Integer.toString(n);
		n++;String ss = Integer.toString(n);

		Queue lista = new Queue<>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String c: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(c)+"");
			String nv = (infraccion.getTicketIssueDate());
			String[]nnv=nv.split(":");

			String ii=nnv[0];
			System.out.println(nnv[0]);

			if((s).compareTo(ii)<=0 && (ss).compareTo(ii)>0){
				lista.enqueue(infraccion);
			}
		}
		return lista;
	}

	/**
	 * Requerimiento 2A: Consultar  las  infracciones  por
	 * Localizaci�n  Geogr�fica  (Xcoord, Ycoord) en Tabla Hash.
	 * @param  double xCoord : Coordenada X de la localizacion de la infracci�n
	 *			double yCoord : Coordenada Y de la localizacion de la infracci�n
	 * @return Objeto InfraccionesLocalizacion
	 */
	public InfraccionesLocalizacion consultarPorLocalizacionHash(double xCoord, double yCoord)
	{
		String location = "";
		String address = "";
		String street = "";

		Queue<VOMovingViolations> listaBuscados = new Queue<>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String s: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(s)+"");
			if((infraccion.getXCoord()+"").equals(Double.toString(xCoord)) && (infraccion.getYCoord()+"").equals(Double.toString(yCoord))){

				location = infraccion.getLocation();
				address = infraccion.getAddressId();
				street = infraccion.getStreetSegId();
				listaBuscados.enqueue(infraccion);
			}
		}
		InfraccionesLocalizacion info = new InfraccionesLocalizacion(xCoord+"", yCoord+"", location, address, street, listaBuscados);
		return info;	
	}

	/**
	 * Requerimiento 3A: Buscar las infracciones por rango de fechas
	 * @param  LocalDate fechaInicial: Fecha inicial del rango de b�squeda
	 * 		LocalDate fechaFinal: Fecha final del rango de b�squeda
	 * @return Cola con objetos InfraccionesFecha
	 */
	public Queue<InfraccionesFecha> consultarInfraccionesPorRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal)
	{
		ManejoFechaHora conv= new ManejoFechaHora();
		Queue listaBuscados = new Queue<>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String s: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(s)+"");
			String fecha = infraccion.getTicketIssueDate();
			String[] parts = fecha.split("T");
			//System.out.println(parts[0]);
			if(parts[0]!=null){
				LocalDate ff = conv.convertirFecha_LD(parts[0]);
				if(ff.isAfter(fechaInicial) && ff.isBefore(fechaFinal)){	
					listaBuscados.enqueue(infraccion);
				}
			}		
		}
		return listaBuscados;
	}

	/**
	 * Requerimiento 1B: Obtener  el  ranking  de  las  N  tipos  de  infracci�n
	 * (ViolationCode)  que  tengan  m�s infracciones.
	 * @param  int N: Numero de los tipos de ViolationCode con m�s infracciones.
	 * @return Cola con objetos InfraccionesViolationCode con top N infracciones
	 */
	public Queue<InfraccionesViolationCode> rankingNViolationCodes(int N)
	{
		Queue<InfraccionesViolationCode> listaFinal = new Queue<InfraccionesViolationCode>();
		Queue<VOMovingViolations> cola = new Queue<VOMovingViolations>();

		ColaPrioridadHeap<VOMovingViolations> colaOrdenamiento = new ColaPrioridadHeap<VOMovingViolations>();
		ColaPrioridadHeap<InfraccionesViolationCode> colaPrioridad = new ColaPrioridadHeap<InfraccionesViolationCode>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String s: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(s)+"");
			colaOrdenamiento.insert(infraccion);
		}


		while(colaOrdenamiento.size()!=0){

			VOMovingViolations infraccion = colaOrdenamiento.delMax();
			String code = infraccion.getViolationCode();
			cola.enqueue(infraccion);

			VOMovingViolations infraccion2 = colaOrdenamiento.delMax();
			String code2 = infraccion2.getViolationCode();

			while(code.equals(code2)&&colaOrdenamiento.size()!=0){
				cola.enqueue(infraccion2);
				infraccion2 = colaOrdenamiento.delMax();
				code = code2;
				code2 = infraccion2.getViolationCode();
			}

			InfraccionesViolationCode infracciones = new InfraccionesViolationCode(code, cola);
			colaPrioridad.insert(infracciones);

			while(cola.size()!=0){
				cola.dequeue();
			}

		}

		N*=2;
		while(N!=0){
			listaFinal.enqueue(colaPrioridad.delMax());
			N--;
		}

		return listaFinal;		
	}	



	/**
	 * Requerimiento 2B: Consultar las  infracciones  por  
	 * Localizaci�n  Geogr�fica  (Xcoord, Ycoord) en Arbol.
	 * @param  double xCoord : Coordenada X de la localizacion de la infracci�n
	 *			double yCoord : Coordenada Y de la localizacion de la infracci�n
	 * @return Objeto InfraccionesLocalizacion
	 */
	public InfraccionesLocalizacion consultarPorLocalizacionArbol(String xCoord, String yCoord)
	{

		String location = "";
		String address = "";
		String streetSeg = "";

		Queue<VOMovingViolations> listaBuscados = new Queue<>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String s: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(s)+"");
			if((infraccion.getYCoord()+"").equals(yCoord) && (infraccion.getXCoord()+"").equals(xCoord)){
				listaBuscados.enqueue(infraccion);
				location = infraccion.getLocation();
				address = infraccion.getAddressId();
				streetSeg = infraccion.getStreetSegId();

			}
		}
		InfraccionesLocalizacion info = new InfraccionesLocalizacion(xCoord, yCoord, location, address, streetSeg, listaBuscados);
		return info;		
	}


	/**
	 * Requerimiento 3B: Buscar las franjas de fecha-hora donde se tiene un valor acumulado
	 * de infracciones en un rango dado [US$ valor inicial, US$ valor final]. 
	 * @param  double valorInicial: Valor m�nimo acumulado de las infracciones
	 * 		double valorFinal: Valor m�ximo acumulado de las infracciones.
	 * @return Cola con objetos InfraccionesFechaHora
	 */
	public Queue<InfraccionesFechaHora> consultarFranjasAcumuladoEnRango(double valorInicial, double valorFinal)
	{
		Queue<InfraccionesFechaHora> colaFinal = new Queue<InfraccionesFechaHora>();
		ArbolRojoN<Double, InfraccionesFechaHora> arbol = new ArbolRojoN<Double, InfraccionesFechaHora>();
		Queue<VOMovingViolations> cola = new Queue<>();

		generarComparables();
		Sort.ordenarShellSort(comparables, new VOMovingViolations.TicketIssueDateHora());

		int count = 0;

		LocalTime horas = ManejoFechaHora.convertirHora_LT("00:00:00");
		LocalTime horaMas = horas.plusMinutes(60);

		while(count<comparables.length){

			VOMovingViolations infraccion = (VOMovingViolations) comparables[count];
			LocalTime fecha1 = darHora(infraccion);
			cola.enqueue(infraccion);

			count++;


			while(fecha1==null&&count<comparables.length-2){
				infraccion = (VOMovingViolations) comparables[count];
				fecha1 = darHora(infraccion);
				count++;
			}
			if(fecha1==null){
				continue;
			}
			else{
				while((fecha1.isAfter(horas)&&fecha1.isBefore(horaMas))&&count<comparables.length){

					cola.enqueue(infraccion);
					infraccion = (VOMovingViolations) comparables[count];
					fecha1 = darHora(infraccion);

					if(fecha1==null){
						while(fecha1==null&&count<comparables.length-2){
							infraccion = (VOMovingViolations) comparables[count];
							fecha1 = darHora(infraccion);
							count++;
						}
						continue;
					}
					else{
						count++;	
					}

				}

				horas = horas.plusHours(1);
				horaMas=horas.plusHours(1);

			}
			if(!cola.isEmpty()){
				InfraccionesFechaHora infracciones = new InfraccionesFechaHora(horas, horaMas, cola);
				double valor = infracciones.darTotalValor();
				arbol.put(valor, infracciones);

				while(cola.size()!=0){
					cola.dequeue();
				}
			}
		}

		Iterable<Double> llavesBuscadas = arbol.keys(valorInicial, valorFinal);

		for(Double s: llavesBuscadas){
			colaFinal.enqueue(arbol.get(s));
		}
		System.out.println(colaFinal.size());
		return colaFinal;		
	}

	public LocalTime darHora(VOMovingViolations infraccion){
		String fecha = infraccion.getTicketIssueDate();
		String[] parts = fecha.split("T");
		String[] hora = parts[1].split("Z");
		String[] parte = hora[0].split("\\.");
		if(!parte[0].contains(":")){
			return null;
		}
		LocalTime fechaHora = ManejoFechaHora.convertirHora_LT(parte[0]);
		return fechaHora;
	}

	/**
	 * Requerimiento 1C: Obtener  la informaci�n de  una  addressId dada
	 * @param  int addressID: Localizaci�n de la consulta.
	 * @return Objeto InfraccionesLocalizacion
	 */
	public InfraccionesLocalizacion2 consultarPorAddressId(String addressID)
	{
		String location = "";
		String address = "";
		String streetSeg = "";

		Queue<VOMovingViolations> listaBuscados = new Queue<>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String s: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(s)+"");
			if((infraccion.getAddressId().equals(addressID))){
				listaBuscados.enqueue(infraccion);
				location = infraccion.getLocation();
				address = infraccion.getAddressId();
				streetSeg = infraccion.getStreetSegId();

			}
		}
		InfraccionesLocalizacion2 info = new InfraccionesLocalizacion2(location, address, streetSeg, listaBuscados);
		return info;				
	}

	/**
	 * Requerimiento 2C: Obtener  las infracciones  en  un  rango de
	 * horas  [HH:MM:SS  inicial,HH:MM:SS  final]
	 * @param  LocalTime horaInicial: Hora  inicial del rango de b�squeda
	 * 		LocalTime horaFinal: Hora final del rango de b�squeda
	 * @return Objeto InfraccionesFranjaHorariaViolationCode
	 */
	public InfraccionesFranjaHorariaViolationCode consultarPorRangoHoras(LocalTime horaInicial, LocalTime horaFinal)
	{
	
		Queue<VOMovingViolations> listaBuscados = new Queue<>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String s: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(s)+"");
			LocalTime horaInfraccion = darHora(infraccion);
			
			if(horaInfraccion!=null){
				if(horaInfraccion.isAfter(horaInicial) && horaInfraccion.isBefore(horaFinal)){	
					listaBuscados.enqueue(infraccion);
				}
			}			
		}
		
		
		Queue<InfraccionesViolationCode> listaFinal = new Queue<InfraccionesViolationCode>();
		Queue<VOMovingViolations> cola = new Queue<VOMovingViolations>();

		ColaPrioridadHeap<VOMovingViolations> colaOrdenamiento = new ColaPrioridadHeap<VOMovingViolations>();
		

		
		while(listaBuscados.size()>0){
			colaOrdenamiento.insert(listaBuscados.dequeue());
		}


		while(colaOrdenamiento.size()!=0){

			VOMovingViolations infraccion = colaOrdenamiento.delMax();
			String code = infraccion.getViolationCode();
			cola.enqueue(infraccion);

			if(colaOrdenamiento.size()==0){
				break;
			}
			VOMovingViolations infraccion2 = colaOrdenamiento.delMax();
			String code2 = infraccion2.getViolationCode();

			while(code.equals(code2)&&colaOrdenamiento.size()!=0){
				cola.enqueue(infraccion2);
				infraccion2 = colaOrdenamiento.delMax();
				code = code2;
				code2 = infraccion2.getViolationCode();
			}

			InfraccionesViolationCode infracciones = new InfraccionesViolationCode(code, cola);
			
			listaFinal.enqueue(infracciones);
			while(cola.size()!=0){
				cola.dequeue();
			}

		}
		
		InfraccionesFranjaHorariaViolationCode ret = new InfraccionesFranjaHorariaViolationCode(horaInicial, horaFinal, listaBuscados, listaFinal);
		return ret;
	}

	/**
	 * Requerimiento 3C: Obtener  el  ranking  de  las  N localizaciones geogr�ficas
	 * (Xcoord,  Ycoord)  con  la mayor  cantidad  de  infracciones.
	 * @param  int N: Numero de las localizaciones con mayor n�mero de infracciones
	 * @return Cola de objetos InfraccionesLocalizacion
	 */
	public Queue<InfraccionesLocalizacion> rankingNLocalizaciones(int N)
	{
		Queue<InfraccionesLocalizacion> listaFinal = new Queue<InfraccionesLocalizacion>();
		Queue<VOMovingViolations> cola = new Queue<VOMovingViolations>();
		ColaPrioridadHeap<InfraccionesLocalizacion> colaPrioridad = new ColaPrioridadHeap<InfraccionesLocalizacion>();

		generarComparables();
		Sort.ordenarShellSort(comparables, new VOMovingViolations.Coordenadas());

		int count = 0;
		while(count<comparables.length){

			VOMovingViolations infraccion = (VOMovingViolations) comparables[count];
			count+=1;
			if(!(count<comparables.length)){
				break;
			}
			VOMovingViolations infraccion2 = (VOMovingViolations) comparables[count];

			Double coordenadas1 = infraccion.getCoordenadas();
			Double coordenadas2 = infraccion2.getCoordenadas();

			cola.enqueue(infraccion);

			while(coordenadas2.equals(coordenadas1)){
				if(count>=comparables.length){
					break;
				}
				cola.enqueue(infraccion2);
				infraccion = infraccion2;
				if(count>=comparables.length){
					break;
				}
				infraccion2 = (VOMovingViolations) comparables[count];
				count+=1;
				coordenadas1=coordenadas2;
				coordenadas2=infraccion2.getCoordenadas();

			}

			InfraccionesLocalizacion infracciones = new InfraccionesLocalizacion(coordenadas1+"", coordenadas2+"", infraccion.getLocation(), infraccion.getAddressId(), infraccion.getStreetSegId(), cola);
			colaPrioridad.insert(infracciones);

			while(cola.size()!=0){
				cola.dequeue();
			}

		}

		N*=2;
		while(N>0){
			listaFinal.enqueue(colaPrioridad.delMax());
			N-=1;
		}

		return listaFinal;		


	}

	/**
	 * Requerimiento 4C: Obtener la  informaci�n  de  los c�digos (ViolationCode) ordenados por su numero de infracciones.
	 * @return Contenedora de objetos InfraccionesViolationCode.
	 */
	public Queue<InfraccionesViolationCode> ordenarCodigosPorNumeroInfracciones(int N)
	{

		Queue<InfraccionesViolationCode> listaFinal = new Queue<InfraccionesViolationCode>();
		Queue<VOMovingViolations> cola = new Queue<VOMovingViolations>();

		ColaPrioridadHeap<VOMovingViolations> colaOrdenamiento = new ColaPrioridadHeap<VOMovingViolations>();
		ColaPrioridadHeap<InfraccionesViolationCode> colaPrioridad = new ColaPrioridadHeap<InfraccionesViolationCode>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String s: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(s)+"");
			colaOrdenamiento.insert(infraccion);
		}


		while(colaOrdenamiento.size()!=0){

			VOMovingViolations infraccion = colaOrdenamiento.delMax();
			String code = infraccion.getViolationCode();
			cola.enqueue(infraccion);

			VOMovingViolations infraccion2 = colaOrdenamiento.delMax();
			String code2 = infraccion2.getViolationCode();

			while(code.equals(code2)&&colaOrdenamiento.size()!=0){
				cola.enqueue(infraccion2);
				infraccion2 = colaOrdenamiento.delMax();
				code = code2;
				code2 = infraccion2.getViolationCode();
			}

			InfraccionesViolationCode infracciones = new InfraccionesViolationCode(code, cola);
			colaPrioridad.insert(infracciones);

			while(cola.size()!=0){
				cola.dequeue();
			}
			if(colaPrioridad.size()>N){
				break;
			}

		}

		N*=2;
		while(N!=0){
			listaFinal.enqueue(colaPrioridad.delMax());
			N--;
		}

		return listaFinal;			
	}

	public String[] escribirTabla(Queue<InfraccionesViolationCode> cola){
		String[] valores = new String[cola.size()];

		int total = 0;
		for(int i = 0; i<cola.size();i++){
			InfraccionesViolationCode in = cola.dequeue();
			int numero = in.getTotalInfracciones();
			total+=numero;
			cola.enqueue(in);
		}

		for(int i = 0; i<cola.size();i++){

			int numero = cola.dequeue().getTotalInfracciones();
			numero = (numero*100)/total;
			int porcientos = (int) (numero/0.7);
			valores[i]=">";

			for(int j = 0; j<porcientos;j++){
				valores[i] = valores[i]+"*";
			}
		}

		return valores;
	}


	public void generarComparables(){
		comparables = new Comparable[listaEncadenada.getSize()];
		NodoLinkedList<VOMovingViolations> objeto = listaEncadenada.darPrimero();;

		int i=0;
		while(objeto!=null){

			comparables[i] = objeto.darElemento();
			i++;
			objeto=objeto.darSiguiente();
		}
	}


}
