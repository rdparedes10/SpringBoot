package com.todo1.puce.spring.jdbc.model;

/**
 * @author rparedes
 *
 */
public class Vehicle {
	
	private String licensePlate; 
	private String chassis;
	private String idBrand;
	private String manufacturingDate;
	/**
	 * @return the licensePlate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}
	/**
	 * @param licensePlate the licensePlate to set
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	/**
	 * @return the chassis
	 */
	public String getChassis() {
		return chassis;
	}
	/**
	 * @param chassis the chassis to set
	 */
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	/**
	 * @return the idBrand
	 */
	public String getIdBrand() {
		return idBrand;
	}
	/**
	 * @param idBrand the idBrand to set
	 */
	public void setIdBrand(String idBrand) {
		this.idBrand = idBrand;
	}
	/**
	 * @return the manufacturingDate
	 */
	public String getManufacturingDate() {
		return manufacturingDate;
	}
	/**
	 * @param manufacturingDate the manufacturingDate to set
	 */
	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	


}
