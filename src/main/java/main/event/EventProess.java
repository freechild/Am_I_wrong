package main.event;

import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
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
		
		cal.set(year, month-1, 1);
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
	    int lastDay = cal.getActualMaximum(Calendar.DATE);
	    
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("year", year);
		map.put("month", month);
		map.put("firstDay", firstDay);
		map.put("lastDay", lastDay);
		return map;
	}
	
}
