/**
 * 
 */
package com.todo1.puce.business;

import com.todo1.puce.constants.ErrorConstant;
import com.todo1.puce.constants.MessageConstant;
import com.todo1.puce.spring.info.ResponseInfo;
import com.todo1.puce.spring.info.StatusInfo;
import com.todo1.puce.spring.jdbc.dao.InsuranceDao;

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
	
}