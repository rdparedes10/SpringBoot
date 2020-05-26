/**
 * 
 */
package com.todo1.puce.spring.info;

/**
 * @author rparedes
 *
 */
public class RequestInfo {
	String sessionId;
	Object objct;

	/**
	 * @return the objct
	 */
	public Object getObjct() {
		return objct;
	}
	/**
	 * @param objct the objct to set
	 */
	public void setObjct(Object objct) {
		this.objct = objct;
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

}
