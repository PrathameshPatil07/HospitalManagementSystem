package com.example.HospitalManagementSystem.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.HospitalManagementSystem.Dao.HospitalDao;
import com.example.HospitalManagementSystem.Entity.Hospital;

@Component
public class HospitalServices {
	@Autowired
	HospitalDao hospitaldao;
	
	public static ArrayList<Hospital>al=new ArrayList<Hospital>();
	
	public ArrayList<Hospital> getalldata(){
		System.out.println("hi");
		return hospitaldao.getalldata();
	}
	
	public void addHospitals(Hospital h) {
		System.out.println(h);
		hospitaldao.addHospital(h);
	}
	
	public void deleteHospital(Hospital h) {
		hospitaldao.deleteHospital(h);
	}

}
