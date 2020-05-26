/**
 * 
 */
package com.todo1.puce.spring.jdbc.model;

/**
 * @author rparedes
 *
 */
public class Accident {
	
	private String cod;
	private String description;
	private String codAd;
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	/**
	 * @param cod the cod to set
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the codAd
	 */
	public String getCodAd() {
		return codAd;
	}
	/**
	 * @param codAd the codAd to set
	 */
	public void setCodAd(String codAd) {
		this.codAd = codAd;
	}
}
