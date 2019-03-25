package view;

import java.time.LocalDate;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controller.Controller;

public class MovingViolationsManagerView 
{
	/**
	 * Constante con el número maximo de datos maximo que se deben imprimir en consola
	 */
	public static final int N = 20;
	
	public void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Proyecto 2----------------------");
		System.out.println("0. Cree una nueva coleccion de infracciones en movimiento");
		System.out.println("1. exit"); 
		System.out.println("Digite el numero para ejecutar la tarea:"); 
	}

	public void printMessage(String string) {
		System.out.println(string);
		
	}


}
	
