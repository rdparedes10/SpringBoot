/**
 * 
 */
package com.todo1.puce.spring.jdbc.model;

/**
 * @author rparedes
 *
 */
public class Location {
	
	private String id;
	private String log;
	private String lat;
	private String codS;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the log
	 */
	public String getLog() {
		return log;
	}
	/**
	 * @param log the log to set
	 */
	public void setLog(String log) {
		this.log = log;
	}
	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	/**
	 * @return the codS
	 */
	public String getCodS() {
		return codS;
	}
	/**
	 * @param codS the codS to set
	 */
	public void setCodS(String codS) {
		this.codS = codS;
	}
	

}
