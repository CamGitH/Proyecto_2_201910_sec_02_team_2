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
	 * que tengan más infracciones. 
	 * @param int N: Número de franjas horarias que tienen más infracciones
	 * @return Cola con objetos InfraccionesFranjaHoraria
	 */
	public IQueue<InfraccionesFranjaHoraria> rankingNFranjas(int N)
	{
		String ini;
		String fin;
		String n = Integer.toString(s);
		String[]nn=n.split("-");

		ini=nn[1];
		fin=nn[2];

		if(fin=="24:00:00") {
			fin ="00:00:00";
		}
		if(ini=="24:00:00") {
			ini ="00:00:00";
		}		
		int intervalo = 0;
		int totalDeInf=0;
		int postgSinAccidentes =0;
		int postgConAccidentes =0;
		int valortotal =0;

		intervalo = Integer.parseInt(fin)-Integer.parseInt(ini);

		Queue<VOMovingViolations> lista = new Queue<>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String c: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(c)+"");
			if((infraccion.getTicketIssueDate()+"").compareTo(fin)<0 && (infraccion.getTicketIssueDate()+"").compareTo(ini)>0){
				totalDeInf++;
				//Si la fecha tiene año esto no va a funcionar
				if(infraccion.getAccidentIndicator()=="No") {
					// como es el texto de "getAccidentIndicator()" cambiarlo por [No]
					postgSinAccidentes++;
				}else {
					postgConAccidentes++;
				}
				valortotal = valortotal+ Integer.parseInt(infraccion.getTotalPaid());

				lista.enqueue(infraccion);
			}
		}


		postgConAccidentes= (postgConAccidentes*100)/totalDeInf;
		postgSinAccidentes= (postgSinAccidentes*100)/totalDeInf;
		//		return "El intervalo recorre una cantidad total de:  "+intervalo+" horas. Con un total de: "+ totalDeInf +" de "
		//				+ "infracciones. El porcentage de infracciones sin accidentes es del "+ postgSinAccidentes+"% mientas que "
		//				+ "el porcentage de infracciones sin accidentes es de "+ postgSinAccidentes+"%. Y el valot total a pagar "
		//				+ "por las infracciones es de "+ valortotal ;
		return lista;

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
		String location = "";
		String address = "";
		String street = "";

		Queue<VOMovingViolations> listaBuscados = new Queue<>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String s: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(s)+"");
			if((infraccion.getXCoord()+"").equals(xCoord) && (infraccion.getYCoord()+"").equals(yCoord)){

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
	 * @param  LocalDate fechaInicial: Fecha inicial del rango de búsqueda
	 * 		LocalDate fechaFinal: Fecha final del rango de búsqueda
	 * @return Cola con objetos InfraccionesFecha
	 */
	public Queue<InfraccionesFecha> consultarInfraccionesPorRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal)
	{
		ManejoFechaHora conv= new ManejoFechaHora();
		Queue<VOMovingViolations> listaBuscados = new Queue<>();

		Iterable<String> iterable = arbolRojoNegro.keys();
		for(String s: iterable){
			VOMovingViolations infraccion = arbolRojoNegro.get(Integer.parseInt(s)+"");
			String fecha = infraccion.getTicketIssueDate();
			String[] parts = fecha.split("T");
			LocalDate ff = conv.convertirFecha_LD(parts[0]);
			if(ff.isAfter(fechaInicial) && ff.isBefore(fechaFinal)){	
				listaBuscados.enqueue(infraccion);
			}		
		}
		InfraccionesFecha r = new InfraccionesFecha(listaBuscados, fechaInicial);
		return r;

	}

	/**
	 * Requerimiento 1B: Obtener  el  ranking  de  las  N  tipos  de  infracción
	 * (ViolationCode)  que  tengan  más infracciones.
	 * @param  int N: Numero de los tipos de ViolationCode con más infracciones.
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
	 * Localización  Geográfica  (Xcoord, Ycoord) en Arbol.
	 * @param  double xCoord : Coordenada X de la localizacion de la infracción
	 *			double yCoord : Coordenada Y de la localizacion de la infracción
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
	 * @param  double valorInicial: Valor mínimo acumulado de las infracciones
	 * 		double valorFinal: Valor máximo acumulado de las infracciones.
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
