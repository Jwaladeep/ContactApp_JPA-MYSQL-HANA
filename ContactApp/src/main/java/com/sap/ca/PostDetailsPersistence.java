package com.sap.ca;
import javax.persistence.*;
import java.util.*;

public class PostDetailsPersistence{
EntityManager em = EntityManagerCreation.getEntityManager();

public String putDetail(PersonalDetails data) {
	em.getTransaction().begin();
	em.persist(data);
	em.getTransaction().commit();
	
	return "Row Created";
}
}