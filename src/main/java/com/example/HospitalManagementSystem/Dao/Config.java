package com.example.HospitalManagementSystem.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.example.HospitalManagementSystem.Entity.Hospital;
@Component
public class Config {
	static Session session = null;
	
	public Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Hospital.class);
		SessionFactory factory=cfg.buildSessionFactory();
		session=factory.openSession();
		return session;
	}
	
	
	
}
