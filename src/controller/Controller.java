package controller;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.data_structures.LinkedList;
import model.data_structures.NodoLinkedList;
import model.violations.VOMovingViolation;
import view.MovingViolationsManagerView;

public class Controller {

	private MovingViolationsManagerView view;
	private LinkedList<VOMovingViolation> listaEncadenda;

	public Controller() {
		view = new MovingViolationsManagerView();
		listaEncadenda = new LinkedList<>();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		Controller controller = new Controller();

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();

			switch(option)
			{
			case 0:
				view.printMessage("Ingrese el semestre (1, 2)");
				int numeroSemestre = sc.nextInt();
				controller.loadMovingViolations(numeroSemestre);
				break;
			case 1:	
				fin=true;
				sc.close();
				break;
			}
		}

	}

	public void loadMovingViolations(int numeroCuatrimestre) {

		List<String[]> list = new ArrayList<String[]>();
		int uno=0,dos=0,tres=0,cuatro=0,s=0,ss=0;
		String u = null,d= null,t= null,c= null,i= null,e= null; 
		CSVReader reader =null;

		try{
			switch(numeroCuatrimestre)
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
		
		System.out.println("\nSe cargaron "+ listaEncadenda.getSize() +" infracciones\n");
		System.out.println("Estas son las primeras 10 infracciones cargadas:\n");
		NodoLinkedList<VOMovingViolation> elem = listaEncadenda.darPrimero();
		for(int ii = 0; ii<10;ii++){
			System.out.println(elem.darElemento().toString());
			elem = elem.darSiguiente();
		
		}
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(uno+" datos cargados en "+u+".");
		System.out.println(dos+" datos cargados en "+d+".");
		System.out.println(tres+" datos cargados en "+t+".");
		System.out.println(cuatro+" datos cargados en "+c+".");
		System.out.println(s+ " datos cargados en "+i+".");
		System.out.println(ss+" datos cargados en "+e+".");
		


	}

	public void readFiles(List<String[]> list){


		for(int i = 0;i<list.size()/10;i++){

			listaEncadenda.agregarIni(new VOMovingViolation(
					list.get(i)[0], 
					list.get(i)[1], 
					list.get(i)[2], 
					list.get(i)[3], 
					list.get(i)[4], 
					list.get(i)[5], 
					list.get(i)[6], 
					list.get(i)[7],
					list.get(i)[8], 
					list.get(i)[9],
					list.get(i)[10], 
					list.get(i)[11], 
					list.get(i)[12], 
					list.get(i)[13], 
					list.get(i)[14], 
					list.get(i)[15],
					list.get(i)[16]));

		}
	
	}
	
	


}
