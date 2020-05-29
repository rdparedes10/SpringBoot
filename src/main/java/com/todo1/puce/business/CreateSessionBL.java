/**
 * 
 */
package com.todo1.puce.business;

import com.todo1.puce.constants.ErrorConstant;
import com.todo1.puce.constants.MessageConstant;
import com.todo1.puce.spring.info.RequestInfo;
import com.todo1.puce.spring.info.ResponseInfo;
import com.todo1.puce.spring.info.StatusInfo;
import com.todo1.puce.spring.jdbc.dao.SessionDao;
import com.todo1.puce.spring.jdbc.model.Session;
import com.todo1.puce.utils.Utils;

/**
 * @author rparedes
 *
 */
public class CreateSessionBL {

	/**
	 * CREATE SESSION EXECUTE
	 * 
	 * @return - Return Session ID
	 */
	public ResponseInfo execute() {
		ResponseInfo responseInfo = new ResponseInfo();
		SessionDao sessionDao = new SessionDao();
		Session sessionId = new Session();
		sessionId.setSessionId(Utils.createSessionId());
		sessionDao.insert(sessionId);
		responseInfo.setParams(sessionId);
		StatusInfo statusInfo = new StatusInfo();
		statusInfo.setCode(ErrorConstant.SUCCESS_CODE);
		statusInfo.setMessage(MessageConstant.MESSAGE_SUCCESS_IN_LOGIN);
		statusInfo.setResult(ErrorConstant.SUCCESS);
		responseInfo.setStatusInfo(statusInfo);
		return responseInfo;
	}

	/**
	 * VALIDATE SESSION
	 * 
	 * @param sessionId - Session Id
	 * @return - Return True or False
	 */
	public String validateSession(String sessionId) {

		SessionDao sessionDao = new SessionDao();
		Session session = sessionDao.find(sessionId);
		if (session != null && session.getSessionId().equals(sessionId)) {
			return session.getUserName();
		}
		return null;
	}

	/**
	 * VALIDATE SESSION
	 * 
	 * @param sessionId - Session Id
	 * @return - Return True or False
	 */
	public boolean validateSessionLogin(String sessionId, RequestInfo beanRq) {

		SessionDao sessionDao = new SessionDao();
		Session session = sessionDao.find(sessionId);
		String userName = beanRq.getUser().getUser();
		session.setUserName(userName);
		if (session != null && session.getSessionId().equals(sessionId)) {
			sessionDao.update(session);
			return true;
		}
		return false;
	}

	/**
	 * VALIDATE SESSION REGISTER USER
	 * 
	 * @param sessionId - Session Id
	 * @return - Return True or False
	 */
	public boolean validateSessionRegister(String sessionId) {
		SessionDao sessionDao = new SessionDao();
		Session session = sessionDao.find(sessionId);
		if (session != null && session.getSessionId().equals(sessionId)) {
			return true;
		}
		return false;
	}
}
