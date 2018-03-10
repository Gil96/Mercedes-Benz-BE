package com.brunoLopes.mercedes.MercedesBenz;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App 
{
    public static void main( String[] args )
    {
    	
    	String Path = args[0];
    	
    	setJsonFile(Path);
    	
    }


	private static void setJsonFile(String Path) {
		
		Root root =  new Root();
    	
        JSONParser parser = new JSONParser();
        
        try {          
        	
        Object obj = parser.parse(new FileReader(Path));

        JSONObject jsonObject = (JSONObject) obj;            
            
            
        JSONArray dArray = (JSONArray) jsonObject.get("dealers");
        
        for (int i = 0; i< dArray.size(); i++) {
        	JSONObject dObj = (JSONObject)  dArray.get(i);
        	
        	Dealer dealer = new Dealer(
        			(String) dObj.get("id"),
        			(String) dObj.get("name"),
        			((Number)dObj.get("latitude")).doubleValue(),
        			((Number)dObj.get("longitude")).doubleValue(),
        			getClosed(dObj));

            
            JSONArray vehiclesArray = (JSONArray) dObj.get("vehicles");
            for (int iii = 0; iii< vehiclesArray.size(); iii++) {
            	
            	JSONObject vObj = (JSONObject)  vehiclesArray.get(iii);
                
            	
            	dealer.addVehicle(new Vehicle(
            			(String) vObj.get("id"),
            			(String) vObj.get("model"),
            			(String) vObj.get("fuel"),
            			(String) vObj.get("transmission"),
            			getAvailability((JSONObject) vObj.get("availability"))));
            	
            }
            
            root.addDealer(dealer);
        }
        
        
        
        JSONArray bArray = (JSONArray) jsonObject.get("bookings");
        
        for (int i = 0; i< bArray.size(); i++) {
        	
        	JSONObject bObj = (JSONObject)  bArray.get(i);
        	
            DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        

            
            Booking booking = new Booking(
            		(String) bObj.get("id"),
            		(String) bObj.get("vehicleId"),
            		(String) bObj.get("firstName"),
            		(String) bObj.get("lastName"), 
            		DateFormat.parse((String)bObj.get("pickupDate")),
            		DateFormat.parse((String)bObj.get("createdAt")),
            		null,
            		null);
            
            root.addBooking(booking);
        }
      
            

            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}


	private static List<String> getClosed(JSONObject dObj) {
		
        JSONArray closedArray = (JSONArray) dObj.get("closed");
        List<String> closed = new ArrayList<String>();
        for (int ii = 0; ii < closedArray.size(); ii++) {
        	closed.add((String) closedArray.get(ii));
        }
		return closed;
	}


    
    public static Map<String,List<String>> getAvailability(JSONObject avaObj ) {
    	
    	Map<String, List<String>> availability = new HashMap<String, List<String>>();
        
        String[] weekday = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
        
        for (String day : weekday) {
        	if(null != (JSONArray)avaObj.get(day)) {
        		
        		JSONArray dayArray = (JSONArray)avaObj.get(day);
        		
        		String start = (String) dayArray.get(0);
        		String end =(String) dayArray.get(1);
        		
        		List<String> timeAva = new ArrayList<String>();
        		timeAva.add(start);
        		timeAva.add(end);
        		availability.put(day,timeAva);
        	}
        }
        return availability;
    	
    }
    
        
}
