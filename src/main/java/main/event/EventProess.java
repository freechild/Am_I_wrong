package main.event;

import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class EventProess {
	
	public HashMap<String, String> eventProress(HttpServletRequest request){
				
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
			if(month>12){
				year +=1;
				month =1;
			}
			else if(month<1){
				year -=1;
				month =12;
			}
				
		} catch (Exception e) {
			month = cal.get(Calendar.MONTH)+1;
		}
		int days = cal.get(Calendar.DATE);
		int mon = cal.get(Calendar.MONTH)+1;
		String today =null;
		String day;
		String Mon;
		if(days<10)
			 day = "0"+days;
		else
			day = days+"";
			
		if(mon<10)
			Mon = "0"+mon;
		else
			Mon = mon+"";
		
			
			today = cal.get(Calendar.YEAR) + 
					"/"+ Mon +
					"/"+day;			
		
		
		
		cal.set(year, month-1, 1);
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
	    int lastDay = cal.getActualMaximum(Calendar.DATE);
	    
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("year", year+"");
		if(month <10){
			map.put("month", "0"+month);			
		}
		else map.put("month", month+"");
		map.put("today", today);
		map.put("firstDay", firstDay+"");
		map.put("lastDay", lastDay+"");
		return map;
	}
	
}
