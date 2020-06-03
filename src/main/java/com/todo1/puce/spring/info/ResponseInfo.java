/**
 * 
 */
package com.todo1.puce.spring.info;

/**
 * @author rparedes
 *
 */
public class ResponseInfo {

	private Object params;

	private StatusInfo statusInfo;
	
	private String email;
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	

	/**
	 * @return the statusInfo
	 */
	public StatusInfo getStatusInfo() {
		return statusInfo;
	}

	/**
	 * @param statusInfo the statusInfo to set
	 */
	public void setStatusInfo(StatusInfo statusInfo) {
		this.statusInfo = statusInfo;
	}

	/**
	 * @return the returnType
	 */
	public Object getParams() {
		return params;
	}

	/**
	 * @param returnType the returnType to set
	 */
	public void setParams(Object params) {
		this.params = params;
	}
}
