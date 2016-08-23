package event.service;

import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class EventProess {
	
	public HashMap<String, Integer> eventProress(HttpServletRequest request){
				
		int year; 
		int month; 
		Calendar cal = Calendar.getInstance();
		
		
		try {
			year = Integer.parseInt(request.getParameter("year"));
		} catch (Exception e) {
			year = cal.get(Calendar.YEAR);
		}
		try {
			month = Integer.parseInt(request.getParameter("month"));
		} catch (Exception e) {
			month = cal.get(Calendar.MONTH)+1;
		}
		
		year= cal.get(Calendar.YEAR);
		month= cal.get(Calendar.YEAR); //클라이언트에서 넘겨준 값이 없을때 표시하는 값
		
		cal.set(year, month-1, 1);
	    year = cal.get(Calendar.YEAR);
	    month = cal.get(Calendar.MONTH)+1;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("year", year);
		map.put("month", month);
		
		return map;
	}
     
	
}
