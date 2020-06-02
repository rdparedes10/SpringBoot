/**
 * 
 */
package com.todo1.puce.business;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.todo1.puce.constants.ErrorConstant;
import com.todo1.puce.constants.MessageConstant;
import com.todo1.puce.spring.info.RequestInfo;
import com.todo1.puce.spring.info.ResponseInfo;
import com.todo1.puce.spring.info.StatusInfo;
import com.todo1.puce.spring.jdbc.dao.BrandDao;
import com.todo1.puce.spring.jdbc.dao.ClientDao;
import com.todo1.puce.spring.jdbc.dao.UserDao;
import com.todo1.puce.spring.jdbc.dao.VehicleDao;
import com.todo1.puce.spring.jdbc.model.Brand;
import com.todo1.puce.spring.jdbc.model.Client;
import com.todo1.puce.spring.jdbc.model.User;
import com.todo1.puce.spring.jdbc.model.Vehicle;
import com.todo1.puce.utils.Utils;

/**
 * @author rparedes
 *
 */
public class RegisterUserBL {

	public ResponseInfo execute(RequestInfo beanRq) {

		ResponseInfo responseInfo = new ResponseInfo();
		StatusInfo statusInfo = new StatusInfo();
		UserDao userDao = new UserDao();
		ClientDao clientDao = new ClientDao();

		Utils ulti = new Utils();
		String pass = beanRq.getUser().getPass();
		try {
			pass = ulti.decrypt(pass);

			String userName = beanRq.getUser().getUser();
			User userD = userDao.find(userName, pass);
			String id = beanRq.getUser().getCi();
			Client client = clientDao.find(id);
			if (!beanRq.validateCl()) {
				if (client == null) {
					Client clientInsert = beanRq.getClient();
					clientDao.insert(clientInsert);
					insertVehicle(beanRq);
					client = clientInsert;
				}
			}
			
			if (userD == null && client != null) {
				userD = new User();
				userD.setUser(userName);
				userD.setPass(pass);
				userD.setEmail(beanRq.getUser().getEmail());
				userD.setCi(id);
				userDao.insert(userD);
				statusInfo.setCode(ErrorConstant.SUCCESS_CODE);
				statusInfo.setMessage(MessageConstant.MESSAGE_SUCCESS_IN_LOGIN);
				statusInfo.setResult(ErrorConstant.SUCCESS);
			} else {
				setResponseError(statusInfo);
			}
			responseInfo.setStatusInfo(statusInfo);
			return responseInfo;
		} catch (InvalidKeyException e) {
			setResponseError(statusInfo);
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			setResponseError(statusInfo);
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			setResponseError(statusInfo);
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			setResponseError(statusInfo);
			e.printStackTrace();
		} catch (BadPaddingException e) {
			setResponseError(statusInfo);
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			setResponseError(statusInfo);
			e.printStackTrace();
		}
		responseInfo.setStatusInfo(statusInfo);
		return responseInfo;
	}

	/**
	 * SET RESPONSE ERROR
	 * 
	 * @param statusInfo - Parameter
	 */
	public void setResponseError(StatusInfo statusInfo) {
		statusInfo.setCode(ErrorConstant.ERROR_CODE_LOGIN);
		statusInfo.setMessage(MessageConstant.MESSAGE_ERROR_IN_LOGIN);
		statusInfo.setResult(ErrorConstant.ERROR);
	}

	/**
	 * GET BRAND
	 * 
	 * @param beanRq - beanRq
	 * @return - brand
	 */
	public Brand getBrand(RequestInfo beanRq) {
		BrandDao brandDao = new BrandDao();
		String brandName = beanRq.getVehicle().getIdBrand().toUpperCase();
		Brand brand = brandDao.find(brandName);
		if (brand == null) {
			brand = new Brand();
			brand.setIdBrand(brandName);
			brandDao.insert(brand);
		}
		return brand;
	}

	/**
	 * INSERT VEHICLE
	 * 
	 * @param beanRq - beanRq
	 */
	public void insertVehicle(RequestInfo beanRq) {

		Vehicle vehicle = beanRq.getVehicle();
		VehicleDao vehicleDao = new VehicleDao();
		if (vehicleDao.find(vehicle.getLicensePlate()) == null) {
			vehicle.setIdBrand(getBrand(beanRq).getIdBrand());
			vehicleDao.insert(vehicle);
		}
	}

}
