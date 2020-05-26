/**
 * 
 */
package com.todo1.puce.spring.jdbc.model;

/**
 * @author rparedes
 *
 */
public class Insurance {
	
	private String idInsurance;
	private String type;
	private String state;
	private String coverageType;
	/**
	 * @return the idInsurance
	 */
	public String getIdInsurance() {
		return idInsurance;
	}
	/**
	 * @param idInsurance the idInsurance to set
	 */
	public void setIdInsurance(String idInsurance) {
		this.idInsurance = idInsurance;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the coverageType
	 */
	public String getCoverageType() {
		return coverageType;
	}
	/**
	 * @param coverageType the coverageType to set
	 */
	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}

}
