package com.example.HospitalManagementSystem.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalManagementSystem.Entity.Hospital;
import com.example.HospitalManagementSystem.services.HospitalServices;
@RestController
public class Controller {
	@Autowired
	HospitalServices hospitalservices;
	
	public static ArrayList<Hospital>al=new ArrayList<Hospital>();
	@GetMapping("gethospital")
	public ArrayList<Hospital> getalldata(){ 	
		return hospitalservices.getalldata();
	}
	
	@PostMapping("/addHospital")
	public void AddHospital(@RequestBody Hospital h) {
		System.out.println(h);
		hospitalservices.addHospitals(h);
		
	}
	
	@PutMapping("UpdateData")
	public static void updateHospitaldata(int id) {
		System.err.println(1);
	}
	
	@DeleteMapping("deletedata/{id}")
	public static void deleteHospital(@RequestBody int id) {
		deleteHospital(id);
		
	}
	
	

}
