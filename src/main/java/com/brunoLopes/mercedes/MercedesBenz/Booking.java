package com.brunoLopes.mercedes.MercedesBenz;

import java.util.Date;

public class Booking {
	
	private String id;
	private String vehicleId;
	private String firstName;
	private String lastName;
	private Date pickupDate;
	private Date createdAtDay;
	private Date cancelledAt;
	private String cancelledReason;

	
	public Booking(String id, String vehicleId, String firstName, String lastName, Date pickupDate, Date createdAtDay,
			Date cancelledAt, String cancelledReason) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pickupDate = pickupDate;
		this.createdAtDay = createdAtDay;
		this.cancelledAt = cancelledAt;
		this.cancelledReason = cancelledReason;
	}


}
