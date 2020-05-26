/**
 * 
 */
package com.todo1.puce.business;

import com.todo1.puce.constants.ErrorConstant;
import com.todo1.puce.constants.MessageConstant;
import com.todo1.puce.spring.info.RequestInfo;
import com.todo1.puce.spring.info.ResponseInfo;
import com.todo1.puce.spring.info.StatusInfo;
import com.todo1.puce.spring.jdbc.dao.UserDao;
import com.todo1.puce.spring.jdbc.model.User;

/**
 * @author rparedes
 *
 */
public class LoginBL {

	public ResponseInfo execute(RequestInfo beanRq) {
		ResponseInfo responseInfo = new ResponseInfo();
		StatusInfo statusInfo = new StatusInfo();
		UserDao userDao = new UserDao();

		String pass = ((User)beanRq.getObjct()).getPass();
		String userName = ((User)beanRq.getObjct()).getUser();
		User userD = userDao.find(userName, pass);

		if (userD != null) {
			
			User userInsert = (User)beanRq.getObjct();
			userDao.insert(userInsert);
			statusInfo.setCode(ErrorConstant.SUCCESS_CODE);
			statusInfo.setMessage(MessageConstant.MESSAGE_SUCCESS_IN_LOGIN);
			statusInfo.setResult(ErrorConstant.SUCCESS);
		}else {
			responseInfo.setParams("");
			statusInfo.setCode(ErrorConstant.ERROR_CODE_LOGIN);
			statusInfo.setMessage(MessageConstant.MESSAGE_ERROR_IN_LOGIN);
			statusInfo.setResult(ErrorConstant.ERROR);
		}
		responseInfo.setStatusInfo(statusInfo);
		return responseInfo;
	}
}
