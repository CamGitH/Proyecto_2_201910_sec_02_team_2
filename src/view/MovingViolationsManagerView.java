package view;

import model.data_structures.IQueue;
import model.data_structures.Queue;
import model.vo.*;

public class MovingViolationsManagerView {

	/**
	 * Constante con el numero maximo de datos maximo que se deben imprimir en consola
	 */
	public static final int N = 20;
	
	public void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Proyecto 2----------------------");

		System.out.println("0. Cargar datos del semestre");
		System.out.println("1. Obtener el ranking de las N franjas horarias que tengan mas infracciones. (REQ 1A)");
		System.out.println("2. Realizar  el  ordenamiento  de  las  infracciones  por  Localizacion  Geografica. (REQ 2A)");
		System.out.println("3. Buscar las infracciones por rango de fechas (REQ 3A)");
		
		System.out.println("4. Obtener  el  ranking  de  las  N  tipos  de  infraccion  (ViolationCode)  que  tengan  mas infracciones. (REQ 1B)");		
		System.out.println("5. Realizar  el  ordenamiento  de  las  infracciones  por  Localizacion  Geografica. (REQ 2B)");
		System.out.println("6. Buscar las franjas de fecha-hora donde se tiene un valor acumulado de infracciones en un rango dado. (REQ 3B)");
		
		System.out.println("7. Obtener  la informacion de  una  localizacion dada. (REQ 1C)");
		System.out.println("8. Obtener  las infracciones  en  un  rango de  horas. (REQ 2C)");
		System.out.println("9. Obtener  el  ranking  de  las  N localizaciones geograficas con la mayor cantidad de infracciones. (REQ 3C)");
		System.out.println("10. Mostrar  una  grafica ASCII con los codigos (ViolationCode) ordenados por numero de infracciones. (REQ 4C)");
		
		System.out.println("11. Salir");
		System.out.println("Digite el numero de opcion para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
		System.out.println("0. Cree una nueva coleccion de infracciones en movimiento");
		System.out.println("1. exit"); 
		System.out.println("Digite el numero para ejecutar la tarea:"); 

	}

	public void printMessage(String string) {
		System.out.println(string);
		
	}

	
	public void printResumenLoadMovingViolations(EstadisticasCargaInfracciones resultados) {
		System.out.println("Total de Infracciones :" + resultados.darTotalInfracciones());
		for(int i = 0; i<resultados.darNumeroDeMesesCargados();i++){
		System.out.println(resultados.darNumeroDeInfraccionesXMes()[i]);
		}
		double [] minimax = resultados.darMinimax();
		System.out.println("Min and Max, X and Y coords: [" + minimax[0] + ", " + minimax[1] + "], [" + minimax[2] + ", " + minimax[3] + "]");
	}
	
	public void printReq1A(Queue<InfraccionesFranjaHoraria> resultados) {
		for(int i = 0; i<resultados.size();i++) {
			InfraccionesFranjaHoraria aaa = resultados.dequeue();
			System.out.println("\n");
			System.out.println(aaa.toString());
			
			/* Detalle de las infracciones (Se requiere SOLO en caso de validacion)*/
			/*
			for(VOMovingViolations vo: vinfraFranjas.getListaInfracciones()) {
				System.out.println(vo.toString());
			}
			*/
		}
	}
	
	public void printReq2A(InfraccionesLocalizacion resultado) {
		System.out.println(resultado.toString());
		
		/* Detalle de las infracciones (Se requiere SOLO en caso de validacion)*/
		/*
		for(VOMovingViolations v: resultado.getListaInfracciones()) {
			System.out.println(v.toString());
		}
		*/
	}
	
	public void printReq3A(Queue<InfraccionesFecha> resultados) {
		for(int i = 0; i<resultados.size();i++) {
			InfraccionesFecha aaa = resultados.dequeue();
			System.out.println("\n");
			System.out.println(aaa.toString());
			/* Detalle de las infracciones (Se requiere SOLO en caso de validacion)*/
			/*
			for(VOMovingViolations vo: infraFechas.getListaInfracciones()) {
				System.out.println(vo.toString());
			}
			*/
		}
	}
	
	public void printReq1B(Queue<InfraccionesViolationCode> cola) {
		for(int i = 0; i<cola.size();i++) {
			InfraccionesViolationCode vio = cola.dequeue();
			int y = i+1;
			System.out.println("Violation code #"+y+":\n");
			System.out.println(vio.toString());
			/* Detalle de las infracciones (Se requiere SOLO en caso de validacion)*/
			/*
			for(VOMovingViolations vo: infraVioCode.getListaInfracciones()) {
				System.out.println(vo.toString());
			}
			*/
		}
	}
	
	public void printReq2B(InfraccionesLocalizacion resultado) {
		System.out.println(resultado.toString());
		/* Detalle de las infracciones (Se requiere SOLO en caso de validacion)*/
		/*
		for(VOMovingViolations v: resultado.getListaInfracciones()) {
			System.out.println(v.toString());
		}
		*/
	}
	
	
	public void printReq3B(Queue<InfraccionesFechaHora> resultados) {
		for(int i = 0; i<resultados.size();i++) {
			System.out.println(resultados.dequeue().toString());
			/* Detalle de las infracciones (Se requiere SOLO en caso de validacion)*/
			/*
			for(VOMovingViolations vo: infraFechas.getListaInfracciones()) {
				System.out.println(vo.toString());
			}
			*/
		}
	}
	
	public void printReq1C(InfraccionesLocalizacion2 infraccion) {
		System.out.println(infraccion.toString());
		/* Detalle de las infracciones (Se requiere SOLO en caso de validacion)*/
		/*		
		for(VOMovingViolations v: resultado.getListaInfracciones()) {
			System.out.println(v.toString());
		}
		*/
	}
	
	public void printReq2C(InfraccionesFranjaHorariaViolationCode resultado) {
		
			for(int i = 0; i<resultado.getInfViolationCode().size();i++) {
				InfraccionesViolationCode infraccionCode = resultado.getInfViolationCode().dequeue();
System.out.println("Infraccion: "+infraccionCode.getViolationCode());
System.out.println("\nNumero de infracciones:\n");
				System.out.println(infraccionCode.getTotalInfracciones());
				
			}
			System.out.println("______________________");
			System.out.println(resultado.toString());

			/* Detalle de las infracciones (Se requiere SOLO en caso de validacion)*/
			/*
			for(VOMovingViolations vv: v.getListaInfracciones()) {
				System.out.println(vv.toString());
			*/
	//	}

		/* Detalle de las infracciones (Se requiere SOLO en caso de validacion)*/
		/*
		for(VOMovingViolations v: resultado.getListaInfracciones()) {
			System.out.println(v.toString());
		}
		*/
	}
	
	
	public void printReq3C(Queue<InfraccionesLocalizacion> resultados) {
		for(int i = 0; i<resultados.size();i++) {
			System.out.println(resultados.dequeue().toString());
			/* Detalle de las infracciones (Se requiere SOLO en caso de validacion)*/
			/*		
			for(VOMovingViolations vo: infraLoc.getListaInfracciones()) {
				System.out.println(vo.toString());
			}
			*/
		}
	}
	
	
	public void printReq4C(Queue<InfraccionesViolationCode> resultados, String[] strings) {
		
		System.out.println("Porcentaje de infracciones por Violation code");
		System.out.println("ViolationCode| % de accidentes");
		for(int i = 0; i<resultados.size();i++){
			InfraccionesViolationCode infraccion = resultados.dequeue();
			System.out.println(infraccion.getViolationCode()+"| "+strings[i].toString());
		}
		System.out.println("-------------------------");
		System.out.println("Cada * representa 0,7%");
		
	}
	

}
	
