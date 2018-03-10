package com.brunoLopes.mercedes.MercedesBenz;

import java.util.List;
import java.util.ArrayList;


public class Dealer {
	
	private String id;
	private String name;
	private double latitude;
	private double longitude;
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private List<String> closed = new ArrayList<String>();
	
	
	public Dealer(String id, String name, double latitude, double longitude, List<String> closed) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.closed = closed;
	}
	
	
	
	public void addVehicle(Vehicle v) {
		
		this.vehicles.add(v);
	}



	public double getLatitude() {
		return latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public List<Vehicle> getVehicles() {
		return vehicles;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	

}
