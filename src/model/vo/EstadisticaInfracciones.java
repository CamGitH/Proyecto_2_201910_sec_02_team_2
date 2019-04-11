package model.vo;

import model.data_structures.IQueue;
import model.data_structures.Queue;

/**
 * Agrupa las infracciones mostrando estadísticas sobre los datos 
 * como el total de infracciones que se presentan en ese conjunto,
 * el porcentaje de infracciones con y sin accidentes con respecto al total,
 * el valor total de las infracciones que se deben pagar y una lista con 
 * las infracciones. 
 */

public class EstadisticaInfracciones {
	
	@Override
	public String toString() {
		return "EstadisticaInfracciones [totalInfracciones=" + totalInfracciones + ",\n porcentajeAccidentes="
				+ porcentajeAccidentes + ",\n porcentajeNoAccidentes=" + porcentajeNoAccidentes + ",\n valorTotal="
				+ valorTotal + "]\n\n";
	}

	/**	
	 * Numero total de infraciones del conjunto
	 */
	
	protected int totalInfracciones;
	
	/**
	 * Porcentaje de las infracciones con accidentes con respecto al total
	 */
	
	protected double porcentajeAccidentes;
	
	/**
	 * Porcentaje de las infracciones sin accidentes con respecto al total
	 */
	
	protected double porcentajeNoAccidentes; 
	
	/**
	 * Valor total de las infracciones que se debe pagar.
	 */
	
	protected double valorTotal;	
	
	/**
	 * Lista con las infracciones que agrupa el conjunto
	 */
	
	protected Queue<VOMovingViolations> listaInfracciones;
	
	private int accidente = 0;
	
	private int noAccidente = 0;
	
	
	/**
	 * Crea un nuevo conjunto con las infracciones
	 * @param listaInfracciones - Lista con las infracciones que cumplen el criterio de agrupamiento
	 */
	
	public EstadisticaInfracciones(Queue<VOMovingViolations> listaBuscados) {
		listaInfracciones = listaBuscados;
		totalInfracciones = listaBuscados.size();
		porcentajeAccidentes = getPorcentajeAccidentes(listaInfracciones);   
		porcentajeNoAccidentes = getPorcentajeNoAccidentes(listaInfracciones); 
		valorTotal = this.getValorTotal(listaInfracciones);
	}
	
	//=========================================================
	//Metodos Getters and Setters
	//=========================================================
	

	/**
	 * Gets the total infracciones.
	 * @param lista 
	 * @return the total infracciones
	 */
	
	public int getTotalInfracciones() {
		return totalInfracciones;
	}	
	
	
	/**
	 * Gets the porcentaje accidentes.	 
	 * @param listaBuscados *
	 * @return the porcentaje accidentes
	 */
	
	public double getPorcentajeAccidentes(Queue<VOMovingViolations> listaBuscados) {
		for(int i = 0; i<listaBuscados.size();i++){
			VOMovingViolations infraccion = listaBuscados.dequeue();
			if(infraccion.getAccidentIndicator().equals("Yes")){
				accidente++;
			}
			listaBuscados.enqueue(infraccion);
		}
		porcentajeAccidentes = ((accidente*100)/listaBuscados.size());
		accidente=0;
		return porcentajeAccidentes;
	}	


	/**
	 * Gets the porcentaje no accidentes.
	 * @param listaBuscados 
	 *
	 * @return the porcentaje no accidentes
	 */
	public double getPorcentajeNoAccidentes(Queue<VOMovingViolations> listaBuscados) {

		return 100-getPorcentajeAccidentes(listaBuscados);
	}

	/**
	 * Gets the valor total.
	 * @param listaBuscados 
	 *
	 * @return the valor total
	 */
	
	public double getValorTotal(Queue<VOMovingViolations> listaBuscados) {
		for(int i = 0; i<listaBuscados.size();i++){
			VOMovingViolations infraccion = listaBuscados.dequeue();
			valorTotal+=Double.parseDouble(infraccion.getTotalPaid());
			listaBuscados.enqueue(infraccion);
			
		}
		return valorTotal;
	}	
	
	public double darTotalValor(){
		return valorTotal;
	}

	/**
	 * Gets the lista infracciones.
	 *
	 * @return the lista infracciones
	 */
	public Queue<VOMovingViolations> getListaInfracciones() {
		return listaInfracciones;
	}

	/**
	 * Sets the lista infracciones.
	 *
	 * @param listaInfracciones the new lista infracciones
	 */
	
	public void setListaInfracciones(Queue<VOMovingViolations> pListaInfracciones) {
		listaInfracciones = pListaInfracciones;
	}
}
