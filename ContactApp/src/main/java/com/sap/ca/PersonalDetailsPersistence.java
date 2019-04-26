package com.sap.ca;
import javax.persistence.*;
import java.util.*;

public class PersonalDetailsPersistence{
	EntityManager em = EntityManagerCreation.getEntityManager();
public List<PersonalDetails> getPersonalDetails() {

		Query query = em.createQuery("select s from PersonalDetails s");
		@SuppressWarnings("unchecked")
		List<PersonalDetails> people = query.getResultList();
		return people;
	}
}