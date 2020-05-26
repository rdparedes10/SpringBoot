package com.todo1.puce.spring.jdbc;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.todo1.puce.spring.jdbc.dao.VehicleDao;
import com.todo1.puce.spring.jdbc.model.Vehicle;

public class SpringJDBC {

	public static void main(String[] args) throws SQLException {

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		VehicleDao vehicle = ctx.getBean(VehicleDao.class);

		System.out.println("Cantidad de vehicleos: " + vehicle.totalVehicule());
		System.out.println("Vehicleo con ID = 25: " + vehicle.find(25));

		// crear un nuevo vehicleo
		Vehicle v0 = new Vehicle();

		// insertar nuevo vehicleo
		vehicle.insert(v0);

		// actualizar el vehicleo con ID = 35
		vehicle.update(v0);

		// listar todos los vehicleos
//		vehicle.todos().forEach(System.out::println);

		// eliminar el vehicleo con ID = 111
		vehicle.delete(v0.getChassis());

		ctx.close();
	}
}
