package model.vo;

import java.time.LocalTime;
import java.util.Comparator;

import model.logic.ManejoFechaHora;
import model.vo.VOMovingViolations;

/**
 * Representation of a moving violation
 */
public class VOMovingViolations  implements Comparable<VOMovingViolations>{
	
	private int objectID;
	private String location;
	private String ticketIssueDate;
	private String totalPaid;
	private String accidentIndicator;
	private String violationDescription;
	private String streetSegId;
	private String addressID;
	private double xCoord;
	private double yCoord;
	private String violationCode;
	

	public VOMovingViolations(int pObjectID, String pLocation, String pTicketIssueDate, String pTotalPaid,
			String pAccidentIndicator, String pViolatinDescription, String pStreetSegId, String pAddressID
			, double pXCoord, double pYCoord, String pViolationCode) {
	
		objectID = pObjectID;
		location = pLocation;
		ticketIssueDate = pTicketIssueDate;
		totalPaid = pTotalPaid;
		accidentIndicator = pAccidentIndicator;
		violationDescription = pViolatinDescription;
		streetSegId = pStreetSegId;
		addressID = pAddressID;
		xCoord = pXCoord;
		yCoord = pYCoord;
		violationCode = pViolationCode;
		
	}


	@Override
	public String toString() {
		return "VOMovingViolations [objectId()=" + objectId() + ",\n getLocation()=" + getLocation()
				+ ",\n getTicketIssueDate()=" + getTicketIssueDate() + ",\n getTotalPaid()=" + getTotalPaid()
				+ ",\n getAccidentIndicator()=" + getAccidentIndicator() + ",\n getViolationDescription()="
				+ getViolationDescription() + ",\n getStreetSegId()=" + getStreetSegId() + ",\n getAddressId()="
				+ getAddressId()+ ",\n getXCoord()=" + getXCoord() + ",\n getYCoord()=" + getYCoord()+",\n getViolationCode()=" + getViolationCode()+ "]\n\n";
	}


	/**
	 * @return objectId
	 */
	public int objectId() {
		return objectID;
	}	
	
	
	/**
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return date
	 */
	public String getTicketIssueDate() {
		return ticketIssueDate;
	}
	
	/**
	 * @return totalPaid
	 */
	public String getTotalPaid() {
		return totalPaid;
	}
	
	/**
	 * @return accidentIndicator
	 */
	public String  getAccidentIndicator() {
		return accidentIndicator;
	}
		
	/**
	 * @return description
	 */
	public String  getViolationDescription() {
		return violationDescription;
	}
	/**
	 * @return streetSegId
	 */
	public String getStreetSegId() {
		return streetSegId;
	}
	/**
	 * @return addressID
	 */
	public String getAddressId() {
		return addressID;
	}
	public double getXCoord() {
		return xCoord;
	}
	public double getYCoord() {
		return yCoord;
	}
	public String getViolationCode() {
		return violationCode;
	}
	
	public static class TicketIssueDate implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object1.getTicketIssueDate().compareToIgnoreCase(object2.getTicketIssueDate());
		}
		
	}
	
	public static class TicketIssueDateHora implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			
			String fecha = object1.getTicketIssueDate();
			String[] parts = fecha.split("T");
			String[] hora = parts[1].split("Z");
			String[] parte = hora[0].split("\\.");
			
			String fecha2 = object2.getTicketIssueDate();
			String[] parts2 = fecha2.split("T");
			String[] hora2 = parts2[1].split("Z");
			String[] parte2 = hora2[0].split("\\.");
			
			return parte[0].compareToIgnoreCase(parte2[0]);
		}
		
	}
	
//	public static class ObjectID implements Comparator<VOMovingViolations>{
//
//		@Override
//		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
//			return object1.objectId().compareTo(object2.objectId());
//		}
//		
//	}
	
	public static class StreetSeg implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object2.getStreetSegId().compareToIgnoreCase(object1.getStreetSegId());
		}
		
	}
	
	public static class AddressID implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object1.getAddressId().compareToIgnoreCase(object2.getAddressId());
		}
		
	}
	
//	public static class TotalPaidAscendente implements Comparator<VOMovingViolations>{
//
//		@Override
//		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
//			return object1.getTotalPaid().compareToIgnoreCase(object2.getTotalPaid());
//		}
//		
//	}
	
//	public static class TotalPaidDescendente implements Comparator<VOMovingViolations>{
//
//		@Override
//		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
//			return object2.getTotalPaid().compareToIgnoreCase(object1.getTotalPaid());
//		}
//		
//	}
//	
	public static class ViolationDesc implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object1.getViolationDescription().compareToIgnoreCase(object2.getViolationDescription());
		}
		
	}
	
	public static class ViolationCode implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			
			 return object1.getViolationCode().compareToIgnoreCase(object2.getViolationCode());
			 
		
		}
		
	}

	@Override
	public int compareTo(VOMovingViolations arg0) {
		return this.getViolationCode().compareToIgnoreCase(arg0.getViolationCode());
	}
}
