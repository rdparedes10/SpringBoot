package com.todo1.puce.spring.jdbc.model;

/**
 * @author rparedes
 *
 */
public class Vehicle {
	
	private String licensePlate; 
	private String chassis;
	private String manufacturingDate;
	private String idBrand;
	private String photo;
	private String idClient;
	private String model;
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * @return the idClient
	 */
	public String getIdClient() {
		return idClient;
	}
	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
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
