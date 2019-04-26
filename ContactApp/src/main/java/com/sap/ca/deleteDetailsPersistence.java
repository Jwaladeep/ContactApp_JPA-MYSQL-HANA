package com.sap.ca;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class deleteDetailsPersistence {

	public String deleteContact(String phone) {
		
		EntityManager em = EntityManagerCreation.getEntityManager();
		String str = "DELETE FROM personaldetails WHERE PHONENO LIKE \"" + phone + "\" ";
		String strchck="SELECT * FROM personaldetails WHERE PHONENO LIKE \"" +phone + "\"";
		Query chkquery=em.createNativeQuery(strchck);
		em.getTransaction().begin();
		Query query = em.createNativeQuery(str);
		int rowDeleted = query.executeUpdate();
		em.getTransaction().commit();

		return rowDeleted+" Contact(	s) Deleted Succesfuly";

	}
}
