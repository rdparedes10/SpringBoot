/**
 * 
 */
package com.todo1.puce.business;

import java.util.ArrayList;
import java.util.List;

import com.todo1.puce.constants.ErrorConstant;
import com.todo1.puce.constants.MessageConstant;
import com.todo1.puce.spring.info.ResponseInfo;
import com.todo1.puce.spring.info.StatusInfo;
import com.todo1.puce.spring.jdbc.dao.ClientDao;
import com.todo1.puce.spring.jdbc.dao.InsuranceDao;
import com.todo1.puce.spring.jdbc.dao.SessionDao;
import com.todo1.puce.spring.jdbc.dao.UserDao;
import com.todo1.puce.spring.jdbc.dao.VehicleDao;
import com.todo1.puce.spring.jdbc.model.Client;
import com.todo1.puce.spring.jdbc.model.Session;
import com.todo1.puce.spring.jdbc.model.User;
import com.todo1.puce.spring.jdbc.model.Vehicle;

/**
 * @author rparedes
 *
 */
public class ConsultDataBL {
	
	
	/**
	 * GET TYPE INSURANCE
	 * @return - responseInfo
	 */
	public ResponseInfo getTypeInsurance() {
		ResponseInfo responseInfo = new ResponseInfo();
		StatusInfo statusInfo = new StatusInfo();
		InsuranceDao  insuranceDao  = new InsuranceDao ();
		responseInfo.setParams(insuranceDao.getListAll());
		
		statusInfo.setCode(ErrorConstant.SUCCESS_CODE);
		statusInfo.setMessage(MessageConstant.MESSAGE_SUCCESS_IN_LOGIN);
		statusInfo.setResult(ErrorConstant.SUCCESS);
		responseInfo.setStatusInfo(statusInfo);
		return  responseInfo ;
	}
	
	
	/**
	 * GET TYPE INSURANCE
	 * @return - responseInfo
	 */
	public ResponseInfo getUserData(String sessionId) {
		ResponseInfo responseInfo = new ResponseInfo();
		StatusInfo statusInfo = new StatusInfo();
		
		SessionDao sessionDao = new SessionDao();
		Session session = sessionDao.find(sessionId);
		UserDao userDao = new UserDao();
		User userD = userDao.find(session.getUserName());
		ClientDao clientDao = new ClientDao();
		Client client = clientDao.find(userD.getCi());
		
		VehicleDao vehicleDao = new VehicleDao();
		Vehicle vehicle = vehicleDao.findWithUser(client.getId());
		List<Object> list = new ArrayList<Object>();
		list.add(vehicle);
		list.add(client);
		responseInfo.setEmail(userD.getEmail());
		responseInfo.setParams(list);
		statusInfo.setCode(ErrorConstant.SUCCESS_CODE);
		statusInfo.setMessage(MessageConstant.MESSAGE_SUCCESS_IN_LOGIN);
		statusInfo.setResult(ErrorConstant.SUCCESS);
		responseInfo.setStatusInfo(statusInfo);
		return  responseInfo ;
	}
	
}