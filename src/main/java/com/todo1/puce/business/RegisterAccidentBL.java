/**
 * 
 */
package com.todo1.puce.business;

import com.todo1.puce.constants.ErrorConstant;
import com.todo1.puce.constants.MessageConstant;
import com.todo1.puce.spring.info.RequestInfo;
import com.todo1.puce.spring.info.ResponseInfo;
import com.todo1.puce.spring.info.StatusInfo;
import com.todo1.puce.spring.jdbc.dao.ClientDao;
import com.todo1.puce.spring.jdbc.dao.UserDao;
import com.todo1.puce.spring.jdbc.model.Client;
import com.todo1.puce.spring.jdbc.model.User;

/**
 * @author rparedes
 *
 */
public class RegisterAccidentBL {
	
	public ResponseInfo execute(RequestInfo beanRq) {
		
		ResponseInfo responseInfo = new ResponseInfo();
		StatusInfo statusInfo = new StatusInfo();
		UserDao userDao = new UserDao();
		ClientDao clientDao = new ClientDao();
		String pass = ((User)beanRq.getObjct()).getPass();
		String userName = ((User)beanRq.getObjct()).getUser();
		User userD = userDao.find(userName, pass);
		String id = ((User)beanRq.getObjct()).getCedula();
		Client client = clientDao.find(id);
		if (userD == null && client != null) {
			userD = new User();
			userD.setUser(userName);
			userD.setPass(pass);
			userD.setEmail(((User)beanRq.getObjct()).getEmail());
			userD.setCedula(id);
			statusInfo.setCode(ErrorConstant.SUCCESS_CODE);
			statusInfo.setMessage(MessageConstant.MESSAGE_SUCCESS_IN_LOGIN);
			statusInfo.setResult(ErrorConstant.SUCCESS);
		} else {
			statusInfo.setCode(ErrorConstant.ERROR_CODE_REGISTER_USER);
			statusInfo.setMessage(MessageConstant.MESSAGE_ERROR_IN_REGISTER_USER);
			statusInfo.setResult(ErrorConstant.ERROR);
		}
		responseInfo.setStatusInfo(statusInfo);
		return responseInfo;
	}

}
