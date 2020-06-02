/**
 * 
 */
package com.todo1.puce.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.puce.business.ConsultDataBL;
import com.todo1.puce.business.CreateSessionBL;
import com.todo1.puce.business.LoginBL;
import com.todo1.puce.business.RegisterAccidentBL;
import com.todo1.puce.business.RegisterUserBL;
import com.todo1.puce.constants.ErrorConstant;
import com.todo1.puce.constants.MessageConstant;
import com.todo1.puce.constants.PathConstant;
import com.todo1.puce.spring.info.RequestInfo;
import com.todo1.puce.spring.info.ResponseInfo;
import com.todo1.puce.spring.info.StatusInfo;

/**
 * @author rparedes
 *
 */
@RestController
@RequestMapping(path = "/vehicle")
public class JsonController {

	private static final Logger logger = LoggerFactory.getLogger("");
	
	/**
	 * GET ERROR GENERAL
	 * 
	 * @return - Return Response Error
	 */
	public ResponseInfo getErrorGeneral() {
		ResponseInfo res = new ResponseInfo();
		StatusInfo status = new StatusInfo();
		res.setStatusInfo(status);
		status.setCode(ErrorConstant.ERROR_CODE_GENERAL);
		status.setMessage(ErrorConstant.ERROR_GENERAL);
		status.setResult(ErrorConstant.ERROR);
		return res;
	}
	/**
	 * VALIDATE SESSION LOGIN
	 * 
	 * @param request   - request
	 * @param sessionId - sessionId
	 * @return - Return True or False
	 */
	public boolean validateSessionLogin(String sessionId, RequestInfo beanRq) {
		CreateSessionBL session = new CreateSessionBL();
		return session.validateSessionLogin(sessionId, beanRq);
	}

	/**
	 * VALIDATE SESSION
	 * 
	 * @param request   - request
	 * @param sessionId - sessionId
	 * @return - Return True or False
	 */
	public boolean validateSessionRegister(String sessionId) {
		CreateSessionBL session = new CreateSessionBL();
		return session.validateSessionRegister(sessionId);
	}
	
	/**
	 * VALIDATE SESSION
	 * 
	 * @param request   - request
	 * @param sessionId - sessionId
	 * @return - Return True or False
	 */
	public String validateSession(String sessionId) {
		CreateSessionBL session = new CreateSessionBL();
		return session.validateSession(sessionId);
	}

	/**
	 * Validate login
	 * 
	 * @param beanRq  - request Json
	 * @param headers - headers request
	 * @return - response Login
	 */
	@PostMapping(path = PathConstant.LOGIN, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseInfo login(@RequestBody RequestInfo beanRq, HttpServletRequest request) {

		if (validateSessionLogin(beanRq.getSessionId(), beanRq)) {
			LoginBL login = new LoginBL();
			ResponseInfo info = login.execute(beanRq);
			return info;
		} else {
			return getErrorGeneral();
		}
	}

	@GetMapping(path = PathConstant.CREATE_SESSION, produces = "application/json")
	public @ResponseBody ResponseInfo getSession() {
		CreateSessionBL sessionId = new CreateSessionBL();
		ResponseInfo info = sessionId.execute();
		return info;
	}

	@PostMapping(path = PathConstant.REGISTER_USER, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseInfo registerUser(@RequestBody RequestInfo beanRq, HttpServletRequest request) {

		if (validateSessionRegister(beanRq.getSessionId())) {
			RegisterUserBL business = new RegisterUserBL();
			ResponseInfo info = business.execute(beanRq);
			return info;
		} else {
			return getErrorGeneral();
		}
	}

	@PostMapping(path = PathConstant.REGISTER_ACCIDENT, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseInfo registerAccident(@RequestBody RequestInfo beanRq, HttpServletRequest request) {

		if (validateSession(beanRq.getSessionId()) != null) {
			RegisterAccidentBL business = new RegisterAccidentBL();
			ResponseInfo info = business.execute(beanRq);
			return info;
		} else {
			return getErrorGeneral();
		}
	}
	
	@GetMapping(path = PathConstant.GET_INSURANCE, produces = "application/json")
	public @ResponseBody ResponseInfo getInsurance() {
		ConsultDataBL consultDataBL = new ConsultDataBL();
		ResponseInfo info = consultDataBL.getTypeInsurance();
		return info;
	}

	/**
	 * Exception Handler
	 * 
	 * @return Response of error
	 */
	@ExceptionHandler({ Exception.class })
	public @ResponseBody ResponseInfo handleException() {
		logger.debug(MessageConstant.MESSAGE_ERROR_GENERAL);
		return getErrorGeneral();
	}
}
