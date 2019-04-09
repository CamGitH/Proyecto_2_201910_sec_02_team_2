package model.vo;

import java.util.Queue;

/**  
 * Agrupa las infracciones por (Xcoord, Ycoord) 
 */

public class InfraccionesLocalizacion extends EstadisticaInfracciones {	

	@Override
	public String toString() {
		return "InfraccionesLocalizacion [xcoord=" + xcoord + ", ycoord=" + ycoord + ",\n location=" + location
				+ ",\n addressID=" + addressID + ",\n streetID=" + streetID + ",\n totalInfracciones=" + totalInfracciones
				+ ",\n porcentajeAccidentes=" + porcentajeAccidentes + ",\n porcentajeNoAccidentes="
				+ porcentajeNoAccidentes + ",\n valorTotal=" + valorTotal + "]\n\n";
	}

	private String xcoord;
	
	private String ycoord;
	
	private String location;
	
	private String addressID;
	
	private String streetID;
	
	
	/**
	 * Instantiates a new infracciones localizacion.
	 * @param listaBuscados the lista
	 */
	
	public InfraccionesLocalizacion(String xcoor, String ycoor, String locat, String address, String street, VOMovingViolations[] listaBuscados) {
		super(listaBuscados);
		xcoord = xcoor;
		ycoord = ycoor;
		location = locat;
		addressID = address;
		streetID = street;

	}


	/**
	 * Gets the xcoord.
	 *
	 * @return the xcoord
	 */
	public String getXcoord() {
		return xcoord;
	}


	/**
	 * Sets the xcoord.
	 *
	 * @param xcoord the xcoord to set
	 */
	public void setXcoord(String xcoord) {
		this.xcoord = xcoord;
	}


	/**
	 * Gets the ycoord.
	 *
	 * @return the ycoord
	 */
	public String getYcoord() {
		return ycoord;
	}


	/**
	 * Sets the ycoord.
	 *
	 * @param ycoord the ycoord to set
	 */
	public void setYcoord(String ycoord) {
		this.ycoord = ycoord;
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
