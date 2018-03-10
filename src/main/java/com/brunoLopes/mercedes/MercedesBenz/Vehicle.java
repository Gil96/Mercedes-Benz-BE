package com.brunoLopes.mercedes.MercedesBenz;

import java.util.List;
import java.util.Map;

public class Vehicle {
	
	private String id;
	private String model;
	private String duel;
	private String transmission;
	private Map<String, List<String>> availability;
	
	public Vehicle(String id, String model, String duel, String transmission, Map<String, List<String>> availability) {
		super();
		this.id = id;
		this.model = model;
		this.duel = duel;
		this.transmission = transmission;
		this.availability = availability;
	}

	

}
