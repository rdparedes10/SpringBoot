/**
 * 
 */
package com.todo1.puce.spring.info;

import com.todo1.puce.spring.jdbc.model.User;

/**
 * @author rparedes
 *
 */
public class RequestInfo {
	private String sessionId;
	private User user;
	private RegisterAccidentRq accident;
	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the accident
	 */
	public RegisterAccidentRq getAccident() {
		return accident;
	}
	/**
	 * @param accident the accident to set
	 */
	public void setAccident(RegisterAccidentRq accident) {
		this.accident = accident;
	}
}
