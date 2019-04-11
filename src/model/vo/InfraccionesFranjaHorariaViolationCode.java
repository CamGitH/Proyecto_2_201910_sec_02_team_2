package model.vo;

import java.time.LocalTime;

import model.data_structures.IQueue;
import model.data_structures.Queue;

/**
 * Brinda la información del requerimiento 2C
 */

public class InfraccionesFranjaHorariaViolationCode extends InfraccionesFranjaHoraria {
	
	@Override
	public String toString() {
		return "InfraccionesFranjaHorariaViolationCode [totalInfracciones="
				+ totalInfracciones + ",\n porcentajeAccidentes=" + porcentajeAccidentes + ",\n porcentajeNoAccidentes="
				+ porcentajeNoAccidentes + ",\n valorTotal=" + valorTotal + "]\n";
	}

	/**
	 * Agrupa las infracciones del rango de hora por ViolationCode y muestra sus estadisticas
	 */
	
	private Queue<InfraccionesViolationCode> infViolationCode;

	/**
	 * Instantiates a new object.
	 *
	 */
	public InfraccionesFranjaHorariaViolationCode(LocalTime hInicial, LocalTime hFinal, Queue<VOMovingViolations> lista, Queue<InfraccionesViolationCode> pInfViolationCode) {		
		super(hInicial, hFinal, lista);
		this.infViolationCode = pInfViolationCode;
	}

	/**
	 * @return the infViolationCode
	 */
	public Queue<InfraccionesViolationCode> getInfViolationCode() {
		return infViolationCode;
	}

	/**
	 * @param infViolationCode the infViolationCode to set
	 */
	public void setInfViolationCode(Queue<InfraccionesViolationCode> infViolationCode) {
		this.infViolationCode = infViolationCode;
	}
}
