package com.brunoLopes.mercedes.MercedesBenz;

import java.util.List;
import java.util.ArrayList;

public class Root {

	private List<Dealer> dealers = new ArrayList<Dealer>();
	private List<Booking> bookings = new ArrayList<Booking>();
	

	
	public void addDealer(Dealer d) {	
		
		this.dealers.add(d);
	}
	
	
	public void addBooking(Booking b) {
		
		this.bookings.add(b);
	}


	public List<Dealer> getDealers() {
		return dealers;
	}


	public List<Booking> getBookings() {
		return bookings;
	}
	
	
}
