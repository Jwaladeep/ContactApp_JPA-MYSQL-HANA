package com.sap.ca;

import java.util.HashMap;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class EntityManagerCreation {

	/*
	 * private static EntityManagerFactory; fac =
	 * Persistence.createEntityManagerFactory("ca-java-persistence-unit"); private
	 * static EntityManager man = fac.createEntityManager();
	 * 
	 * public static EntityManager getEntityManager(){ return man;
	 */
	/* } */

	private static EntityManagerFactory entityManagerFactory;
	private static String hostedOn = "neo";

	static {
		if (hostedOn.equalsIgnoreCase("local")) {
			try {
				HashMap<String, Object> properties = new HashMap<String, Object>();
				properties.put("javax.persistence.jdbc.user", "root");
				properties.put("javax.persistence.jdbc.password", "password");
				properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
				properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:5636/learnJpa");

				entityManagerFactory = Persistence.createEntityManagerFactory("ca-java-persistence-unit", properties);

			} catch (Throwable ex) {
				System.err.println(
						"Initial SessionFactory creation failed. Bole to creation of factory itself failed.. ab kya karoge\n"
								+ ex);
				throw new ExceptionInInitializerError(ex);
			}
		} else {

			InitialContext ct;
			try {
				ct = new InitialContext();
				DataSource dataSource = (DataSource) ct.lookup("java:comp/env/jdbc/DefaultDB");
				HashMap<String, Object> properties = new HashMap<String, Object>();
				properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, dataSource);
				entityManagerFactory = Persistence.createEntityManagerFactory("ca-java-persistence-unit", properties);
			} catch (NamingException e) {
				e.printStackTrace();
			}

		}

	}

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();

	}

}