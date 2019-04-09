package model.vo;



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
	
	protected VOMovingViolations[] listaInfracciones;
	
	private int accidente;
	
	private int noAccidente;
	
	
	/**
	 * Crea un nuevo conjunto con las infracciones
	 * @param listaInfracciones - Lista con las infracciones que cumplen el criterio de agrupamiento
	 */
	
	public EstadisticaInfracciones(VOMovingViolations[] listaBuscados) {
		listaInfracciones = listaBuscados;
		totalInfracciones = listaBuscados.length;
		porcentajeAccidentes = getPorcentajeAccidentes(listaBuscados);   
		porcentajeNoAccidentes = getPorcentajeNoAccidentes(listaBuscados); 
		valorTotal = this.getValorTotal(listaBuscados);
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
	 * @param pLista *
	 * @return the porcentaje accidentes
	 */
	
	public double getPorcentajeAccidentes(VOMovingViolations[] pLista) {
		for(int i = 0; i<pLista.length;i++){
			VOMovingViolations infraccion = pLista[i];
			if(infraccion.getAccidentIndicator().equals("Yes")){
				accidente++;
			}
		}
		porcentajeAccidentes = (accidente*100)/pLista.length;
		accidente=0;
		return porcentajeAccidentes;
	}	


	/**
	 * Gets the porcentaje no accidentes.
	 * @param pLista 
	 *
	 * @return the porcentaje no accidentes
	 */
	public double getPorcentajeNoAccidentes(VOMovingViolations[] pLista) {
		for(int i = 0; i<pLista.length;i++){
			VOMovingViolations infraccion = pLista[i];
			if(infraccion.getAccidentIndicator().equals("NO")){
				noAccidente++;
			}
		}
		porcentajeNoAccidentes = (noAccidente*100)/pLista.length;
		noAccidente=0;
		return porcentajeNoAccidentes;
	}

	/**
	 * Gets the valor total.
	 * @param pLista 
	 *
	 * @return the valor total
	 */
	
	public double getValorTotal(VOMovingViolations[] pLista) {
		for(int i = 0; i<pLista.length;i++){
			VOMovingViolations infraccion = pLista[i];
			valorTotal+=Double.parseDouble(infraccion.getTotalPaid());
			
		}
		return valorTotal;
	}	

	/**
	 * Gets the lista infracciones.
	 *
	 * @return the lista infracciones
	 */
	public VOMovingViolations[] getListaInfracciones() {
		return listaInfracciones;
	}

	/**
	 * Sets the lista infracciones.
	 *
	 * @param listaInfracciones the new lista infracciones
	 */
	
	public void setListaInfracciones(VOMovingViolations[] pListaInfracciones) {
		listaInfracciones = pListaInfracciones;
	}
}
