/**
 * 
 */
package com.todo1.puce.spring.info;

import com.todo1.puce.spring.jdbc.model.Client;
import com.todo1.puce.spring.jdbc.model.User;
import com.todo1.puce.spring.jdbc.model.Vehicle;

/**
 * @author rparedes
 *
 */
public class RequestInfo {
	private String sessionId;
	private User user;
	private RegisterAccidentRq accident;
	private Client client;
	private Vehicle vehicle;
	private boolean validateCl;

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the isClient
	 */
	public boolean validateCl() {
		return validateCl;
	}

	/**
	 * @param isClient the isClient to set
	 */
	public void setValidateCl(boolean validateCl) {
		this.validateCl = validateCl;
	}

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
