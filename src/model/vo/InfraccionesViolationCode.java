package model.vo;

import model.data_structures.ColaPrioridadHeap;
import model.data_structures.IQueue;

/**
 * Organiza las infracciones por el el código de la infracción y muestra las estadisticas
 * de las respectivas infracciones que poseen el código en mención.
 */

public class InfraccionesViolationCode extends EstadisticaInfracciones implements Comparable<InfraccionesViolationCode>{
	
	@Override
	public String toString() {
		return "InfraccionesViolationCode [violationCode=" + violationCode + ",\n totalInfracciones=" + totalInfracciones
				+ ",\n porcentajeAccidentes=" + porcentajeAccidentes + ",\n porcentajeNoAccidentes="
				+ porcentajeNoAccidentes + ",\n valorTotal=" + valorTotal + "]\n\n";
	}

	/**
	 * Codigo de la infracción por las que se van a agrupar las infracciones
	 */
	
	private String violationCode;	
		
	/**
	 * Instantiates a new infracciones violation code.
	 * @param lista Lista de infracciones que poseen el mismo ViolationCode
	 */
	
	public InfraccionesViolationCode(String violationCodeP, ColaPrioridadHeap<InfraccionesViolationCode> lista) {
		
		super(lista);
		this.violationCode = violationCodeP;
	}

	/**
	 * Gets the violation code.
	 *
	 * @return the violationCode
	 */
	
	public String getViolationCode() {
		return violationCode;
	}


	@Override
	public int compareTo(InfraccionesViolationCode o) {
		// TODO Auto-generated method stub
		return 0;
	}	
}
