package model.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class PagingProcess {

	public HashMap<String, Integer> pagingProcess(HttpServletRequest request) {

		int currentPage;
		// p
		int pageSize;
		// s
		int blockSize;
		// b
		int categoryid;
		
		
		try {
			currentPage = Integer.parseInt(request.getParameter("p"));
		} catch (Exception e) {
			currentPage = 1;
		}
		
		try {
			pageSize = Integer.parseInt(request.getParameter("s"));
		} catch (Exception e) {
			pageSize = 5;
		}
		
		try {
			blockSize = Integer.parseInt(request.getParameter("b"));
		} catch (Exception e) {
			blockSize = 5;
			
		}

		try {
			categoryid = Integer.parseInt(request.getParameter("cid"));
		} catch (Exception e) {
			categoryid = 0;
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("currentPage", currentPage);
		map.put("pageSize", pageSize);
		map.put("blockSize", blockSize);
		map.put("categoryid", categoryid);

		return map;
	}
}
