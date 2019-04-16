package model.vo;

/**  
 * Agrupa las infracciones por (Xcoord, Ycoord) 
 */

public class InfraccionesLocalizacion2 extends EstadisticaInfracciones {	

	@Override
	public String toString() {
		return "InfraccionesLocalizacion: " + "\n location=" + location
				+ ",\n addressID=" + addressID + ",\n streetID=" + streetID + ",\n totalInfracciones=" + totalInfracciones
				+ ",\n porcentajeAccidentes=" + porcentajeAccidentes + ",\n porcentajeNoAccidentes="
				+ porcentajeNoAccidentes + ",\n valorTotal=" + valorTotal + "]\n\n";
	}
	
	private String location;
	
	private String addressID;
	
	private String streetID;
	
	
	/**
	 * Instantiates a new infracciones localizacion.
	 * @param listaBuscados the lista
	 */
	
	public InfraccionesLocalizacion2(String locat, String address, String street, model.data_structures.Queue<VOMovingViolations> listaBuscados) {
		super(listaBuscados);
		location = locat;
		addressID = address;
		streetID = street;

	}

	/**
	 * Gets the adress ID.
	 *
	 * @return the adressID
	 */
	public String getAdressID() {
		return addressID;
	}


	/**
	 * Sets the adress ID.
	 *
	 * @param adressID the adressID to set
	 */
	public void setAdressID(String adressID) {
		this.addressID = adressID;
	}


	/**
	 * Gets the street ID.
	 *
	 * @return the streetID
	 */
	public String getStreetID() {
		return streetID;
	}


	/**
	 * Sets the street ID.
	 *
	 * @param streetID the streetID to set
	 */
	public void setStreetID(String pStreetID) {
		this.streetID = pStreetID;
	}
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

}
