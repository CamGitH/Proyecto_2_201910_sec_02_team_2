package controller;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.vo.*;
import model.data_structures.*;
import model.logic.ManejoFechaHora;
import model.logic.MovingViolationsManager;
import view.MovingViolationsManagerView;

public class Controller {

	// Componente vista (consola)
	private MovingViolationsManagerView view;
	// Componente modelo (logica de la aplicacion)
	private MovingViolationsManager model;
	/**
	 * Metodo constructor
	 */
	public Controller()
	{
		view = new MovingViolationsManagerView();
		model = new MovingViolationsManager();
	
	}

	/**
	 * Metodo encargado de ejecutar los  requerimientos segun la opcion indicada por el usuario
	 */
	public void run(){

		long startTime;
		long endTime;
		long duration;

		Scanner sc = new Scanner(System.in);
		boolean fin = false;

		while(!fin){
			view.printMenu();

			int option = sc.nextInt();

			switch(option){

			case 0:
				view.printMessage("Ingrese semestre a cargar (1 o 2)");
				int semestre = sc.nextInt();
				
				EstadisticasCargaInfracciones resumenCarga = model.loadMovingViolations(semestre);
				view.printResumenLoadMovingViolations(resumenCarga);
				break;

			case 1:
				view.printMessage("1A. Consultar las N franjas horarias con mas infracciones que desea ver. Ingresar valor de N: ");
				int numeroFranjas = sc.nextInt();

				Queue<InfraccionesFranjaHoraria> a = model.rankingNFranjas(numeroFranjas);

				view.printReq1A(a);
				break;

			case 2:
				view.printMessage("Ingrese la coordenada en X de la localizacion geografica (Ej. 1234,56): ");
				double xcoord = sc.nextDouble();
				view.printMessage("Ingrese la coordenada en Y de la localizacion geografica (Ej. 5678,23): ");
				double ycoord = sc.nextDouble();

				InfraccionesLocalizacion lc = model.consultarPorLocalizacionHash(xcoord, ycoord);
				view.printReq2B(lc);
				break;

			case 3:
				view.printMessage("Ingrese la fecha inicial del rango. Formato año-mes-dia (ej. 2008-06-21)");
				String fechaInicialStr = sc.next();
				LocalDate fechaInicial = ManejoFechaHora.convertirFecha_LD( fechaInicialStr );

				view.printMessage("Ingrese la fecha final del rango. Formato año-mes-dia (ej. 2008-06-30)");
				String fechaFinalStr = sc.next();
				LocalDate fechaFinal = ManejoFechaHora.convertirFecha_LD( fechaFinalStr );

				
				Queue<InfraccionesFecha> aaa = model.consultarInfraccionesPorRangoFechas(fechaInicial, fechaFinal);

				view.printReq3A(aaa);
				break;


			case 4:
				view.printMessage("1B. Consultar los N Tipos con mas infracciones. Ingrese el valor de N: ");
				int numeroTipos = sc.nextInt();
				
				Queue<InfraccionesViolationCode> cola = model.rankingNViolationCodes(numeroTipos);
				view.printReq1B(cola);
				break;

			case 5:						
				view.printMessage("Ingrese la coordenada en X de la localizacion geografica (Ej. 1234,56): ");
				String xcoord2 = sc.next();
				view.printMessage("Ingrese la coordenada en Y de la localizacion geografica (Ej. 5678,23): ");
				String ycoord2 = sc.next();
				InfraccionesLocalizacion loc = model.consultarPorLocalizacionArbol(xcoord2, ycoord2);
				view.printReq2B(loc);
				break;

			case 6:
				view.printMessage("Ingrese la cantidad minima de dinero que deben acumular las infracciones en sus rangos de fecha  (Ej. 1234,56)");
				double cantidadMinima = sc.nextDouble();

				view.printMessage("Ingrese la cantidad maxima de dinero que deben acumular las infracciones en sus rangos de fecha (Ej. 5678,23)");
				double cantidadMaxima = sc.nextDouble();

				Queue<InfraccionesFechaHora> cola2 = model.consultarFranjasAcumuladoEnRango(cantidadMinima, cantidadMaxima );
				view.printReq3B(cola2);
				break;

			case 7:
				view.printMessage("1C. Consultar las infracciones con Address_Id. Ingresar el valor de Address_Id: ");
				String addressID = sc.next();
				
				startTime = System.currentTimeMillis();
				InfraccionesLocalizacion2 infraccion = model.consultarPorAddressId(addressID);
				endTime = System.currentTimeMillis();
				
				duration = endTime - startTime;
				view.printReq1C(infraccion);
				view.printMessage("Tiempo requerimiento 1C: " + duration + " milisegundos");
				
				break;

			case 8:
				view.printMessage("Ingrese la hora inicial del rango. Formato HH:MM:SS (ej. 09:30:00)");
				String horaInicialStr = sc.next();
				LocalTime horaInicial = ManejoFechaHora.convertirHora_LT(horaInicialStr);

				view.printMessage("Ingrese la hora final del rango. Formato HH:MM:SS (ej. 16:00:00)");
				String horaFinalStr = sc.next();
				LocalTime horaFinal = ManejoFechaHora.convertirHora_LT(horaFinalStr);

				startTime = System.currentTimeMillis();

				InfraccionesFranjaHorariaViolationCode info = model.consultarPorRangoHoras(horaInicial, horaFinal);
				
				endTime = System.currentTimeMillis();

				duration = endTime - startTime;
				view.printReq2C(info);
				view.printMessage("Tiempo requerimiento 2C: " + duration + " milisegundos");
				
				break;

			case 9:
				view.printMessage("Consultar las N localizaciones geograficas con mas infracciones. Ingrese el valor de N: ");
				int numeroLocalizaciones = sc.nextInt();

				startTime = System.currentTimeMillis();
				
				Queue<InfraccionesLocalizacion> cola4 = model.rankingNLocalizaciones(numeroLocalizaciones);

				endTime = System.currentTimeMillis();

				duration = endTime - startTime;
				view.printReq3C(cola4);
				view.printMessage("Tiempo requerimiento 3C: " + duration + " milisegundos");
				break;

			case 10:

				System.out.println("Grafica ASCII con la informacion de las infracciones por ViolationCode");

				startTime = System.currentTimeMillis();
				Queue<InfraccionesViolationCode> cola5 = model.rankingNViolationCodes(20);
				String[] datos = model.escribirTabla(cola5);

				endTime = System.currentTimeMillis();
				view.printReq4C(cola5, datos);

				duration = endTime - startTime;
				view.printMessage("Tiempo requerimiento 4C: " + duration + " milisegundos");
				break;

			case 11:	
				fin = true;
				sc.close();
				break;
			}
		}
	}

}
