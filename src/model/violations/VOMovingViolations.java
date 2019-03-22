package model.violations;


import java.util.Comparator;

/**
 * Representation of a Trip object
 */
public class VOMovingViolations implements Comparable<VOMovingViolations>{

	//	OBJECTID,ROW_,LOCATION,ADDRESS_ID,STREETSEGID,XCOORD,YCOORD,TICKETTYPE,FINEAMT,TOTALPAID,PENALTY1,PENALTY2,ACCIDENTINDICATOR,TICKETISSUEDATE,VIOLATIONCODE,VIOLATIONDESC,ROW_ID


	private String objectID;
	private String row;
	private String location;
	private String addressID;
	private String streetSeg;
	private String xCoor;
	private String yCoor;
	private String ticketType;
	private String fineAtm;
	private String totalPaid;
	private String penalty1;
	private String penalty2;
	private String accidentIndicator;
	private String ticketIssueDate;
	private String violationCode;
	private String violationDescription;
	private String rowID;

	public VOMovingViolations(String pObjectID, String pRow, String pLocation, String pAddressID, String pStreetSeg, String pXCoor,
			String pYCoor, String pTicketType, String pFineAtm, String tOTALPAID, String pPenalty1, String pPenalty2,
			String pAccidentIndicator, String pTicketIssueDate, String pViolationCode, String pViolationDescription, String pRowID) {
		super();
		objectID = pObjectID;
		row = pRow;
		location = pLocation;
		addressID = pAddressID;
		streetSeg = pStreetSeg;
		xCoor = pXCoor;
		yCoor = pYCoor;
		ticketType = pTicketType;
		fineAtm = pFineAtm;
		totalPaid = tOTALPAID;
		penalty1 = pPenalty1;
		penalty2 = pPenalty2;
		accidentIndicator = pAccidentIndicator;
		ticketIssueDate = pTicketIssueDate;
		violationCode = pViolationCode;
		violationDescription = pViolationDescription;
		rowID = pRowID;
	}

	/**
	 * @return the objectID
	 */
	public String getObjectID() {
		return objectID;
	}

	/**
	 * @param objectID the objectID to set
	 */
	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}

	/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * @return the addressID
	 */
	public String getAddressID() {
		return addressID;
	}

	/**
	 * @param addressID the addressID to set
	 */
	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	/**
	 * @return the streetSeg
	 */
	public String getStreetSeg() {
		return streetSeg;
	}

	/**
	 * @param streetSeg the streetSeg to set
	 */
	public void setStreetSeg(String streetSeg) {
		this.streetSeg = streetSeg;
	}

	/**
	 * @return the xCoor
	 */
	public String getxCoor() {
		return xCoor;
	}

	/**
	 * @param xCoor the xCoor to set
	 */
	public void setxCoor(String xCoor) {
		this.xCoor = xCoor;
	}

	/**
	 * @return the yCoor
	 */
	public String getyCoor() {
		return yCoor;
	}

	/**
	 * @param yCoor the yCoor to set
	 */
	public void setyCoor(String yCoor) {
		this.yCoor = yCoor;
	}

	/**
	 * @return the ticketType
	 */
	public String getTicketType() {
		return ticketType;
	}

	/**
	 * @param ticketType the ticketType to set
	 */
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	/**
	 * @return the fineAtm
	 */
	public String getFineAtm() {
		return fineAtm;
	}

	/**
	 * @param fineAtm the fineAtm to set
	 */
	public void setFineAtm(String fineAtm) {
		this.fineAtm = fineAtm;
	}

	/**
	 * @return the totalPaid
	 */
	public String getTotalPaid() {
		return totalPaid;
	}

	/**
	 * @param totalPaid the totalPaid to set
	 */
	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}

	/**
	 * @return the penalty1
	 */
	public String getPenalty1() {
		return penalty1;
	}

	/**
	 * @param penalty1 the penalty1 to set
	 */
	public void setPenalty1(String penalty1) {
		this.penalty1 = penalty1;
	}

	/**
	 * @return the penalty2
	 */
	public String getPenalty2() {
		return penalty2;
	}

	/**
	 * @param penalty2 the penalty2 to set
	 */
	public void setPenalty2(String penalty2) {
		this.penalty2 = penalty2;
	}

	/**
	 * @return the accidentIndicator
	 */
	public String getAccidentIndicator() {
		return accidentIndicator;
	}

	/**
	 * @param accidentIndicator the accidentIndicator to set
	 */
	public void setAccidentIndicator(String accidentIndicator) {
		this.accidentIndicator = accidentIndicator;
	}

	/**
	 * @return the ticketIssueDate
	 */
	public String getTicketIssueDate() {
		return ticketIssueDate;
	}

	/**
	 * @param ticketIssueDate the ticketIssueDate to set
	 */
	public void setTicketIssueDate(String ticketIssueDate) {
		this.ticketIssueDate = ticketIssueDate;
	}

	/**
	 * @return the violationCode
	 */
	public String getViolationCode() {
		return violationCode;
	}

	/**
	 * @param violationCode the violationCode to set
	 */
	public void setViolationCode(String violationCode) {
		this.violationCode = violationCode;
	}

	/**
	 * @return the violationDescription
	 */
	public String getViolationDescription() {
		return violationDescription;
	}

	/**
	 * @param violationDescription the violationDescription to set
	 */
	public void setViolationDescription(String violationDescription) {
		this.violationDescription = violationDescription;
	}

	/**
	 * @return the rowID
	 */
	public String getRowID() {
		return rowID;
	}
	
	/**
	 * @param rowID the rowID to set
	 */
	public void setRowID(String rowID) {
		this.rowID = rowID;
	}

	public static class TicketIssueDate implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object1.getTicketIssueDate().compareToIgnoreCase(object2.getTicketIssueDate());
		}
		
	}
	
	public static class ObjectID implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object1.getObjectID().compareToIgnoreCase(object2.getObjectID());
		}
		
	}
	
	public static class StreetSeg implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object2.getStreetSeg().compareToIgnoreCase(object1.getStreetSeg());
		}
		
	}
	
	public static class AddressID implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object1.getAddressID().compareToIgnoreCase(object2.getAddressID());
		}
		
	}
	
	public static class TotalPaidAscendente implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object1.getTotalPaid().compareToIgnoreCase(object2.getTotalPaid());
		}
		
	}
	
	public static class TotalPaidDescendente implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object2.getTotalPaid().compareToIgnoreCase(object1.getTotalPaid());
		}
		
	}
	
	public static class ViolationDesc implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object1.getViolationDescription().compareToIgnoreCase(object2.getViolationDescription());
		}
		
	}
	
	public static class ViolationCode implements Comparator<VOMovingViolations>{

		@Override
		public int compare(VOMovingViolations object1, VOMovingViolations object2) {
			return object2.getViolationCode().compareToIgnoreCase(object1.getViolationCode());
		}
		
	}

	@Override
	public int compareTo(VOMovingViolations o) {
		// TODO Auto-generated method stub
		return 0;
	}

}