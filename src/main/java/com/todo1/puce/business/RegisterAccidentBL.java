/**
 * 
 */
package com.todo1.puce.business;

import com.todo1.puce.constants.ErrorConstant;
import com.todo1.puce.constants.MessageConstant;
import com.todo1.puce.spring.info.RequestInfo;
import com.todo1.puce.spring.info.ResponseInfo;
import com.todo1.puce.spring.info.StatusInfo;
import com.todo1.puce.spring.jdbc.dao.AccidentDao;
import com.todo1.puce.spring.jdbc.dao.AdviserDao;
import com.todo1.puce.spring.jdbc.dao.ClientDao;
import com.todo1.puce.spring.jdbc.dao.ClientHasAccidentDao;
import com.todo1.puce.spring.jdbc.dao.LocationDao;
import com.todo1.puce.spring.jdbc.dao.SessionDao;
import com.todo1.puce.spring.jdbc.dao.UserDao;
import com.todo1.puce.spring.jdbc.model.Accident;
import com.todo1.puce.spring.jdbc.model.Adviser;
import com.todo1.puce.spring.jdbc.model.Client;
import com.todo1.puce.spring.jdbc.model.ClientHasAccident;
import com.todo1.puce.spring.jdbc.model.Location;
import com.todo1.puce.spring.jdbc.model.Session;
import com.todo1.puce.spring.jdbc.model.User;
import com.todo1.puce.utils.Utils;

/**
 * @author rparedes
 *
 */
public class RegisterAccidentBL {

	public ResponseInfo execute(RequestInfo beanRq) {

		ResponseInfo responseInfo = new ResponseInfo();
		StatusInfo statusInfo = new StatusInfo();
		SessionDao sessionDao = new SessionDao();
		Session session = sessionDao.find(beanRq.getSessionId());
		UserDao userDao = new UserDao();
		User userD = userDao.find(session.getUserName());

		ClientDao clientDao = new ClientDao();
		Client client = clientDao.find(userD.getCi());

		AdviserDao adviserDao = new AdviserDao();
		Adviser adviser = getAdviser(adviserDao);

		AccidentDao accidentDao = new AccidentDao();
		Accident accident = getAccident(adviser.getCod(), beanRq);
		accidentDao.insert(accident);

		LocationDao locationDao = new LocationDao();
		Location location = getLocation(accident.getCod(), beanRq);
		locationDao.insert(location);

		ClientHasAccidentDao clientHasAccidentDao = new ClientHasAccidentDao();
		ClientHasAccident clientHasAccident = new ClientHasAccident();
		clientHasAccident.setId(client.getId());
		clientHasAccident.setCod(accident.getCod());
		clientHasAccidentDao.insert(clientHasAccident);

		if (clientHasAccident != null && accident != null && location != null) {
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

	/**
	 * GET LOCATION
	 * 
	 * @param codS   - codigo de siniestro
	 * @param beanRq - Request Info
	 * @return - Return Location
	 */
	public Location getLocation(String codS, RequestInfo beanRq) {
		Location location = new Location();

		String lon = beanRq.getAccident().getLon();
		String lat = beanRq.getAccident().getLat();
		location.setCodS(codS);
		location.setId(Utils.generateCod());
		location.setLat(lat);
		location.setLon(lon);
		return location;
	}

	/**
	 * GET ACCIDENT
	 * 
	 * @param codA   - codigo de Accident
	 * @param beanRq - Request info
	 * @return - Return Accident
	 */
	public Accident getAccident(String codA, RequestInfo beanRq) {
		Accident accident = new Accident();
		String description = beanRq.getAccident().getDescription();
		accident.setCodAd(codA);
		accident.setCod(Utils.generateCod());
		accident.setDescription(description);
		return accident;
	}

	public Adviser getAdviser(AdviserDao adviserDao) {
		int index = Utils.randomNumberLength(adviserDao.getListAll().size());
		return adviserDao.getListAll().get(index);
	}
}
