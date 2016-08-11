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
		int categoryId;

		if (request.getParameter("p") == null)
			currentPage = 1;
		else
			currentPage = Integer.parseInt(request.getParameter("p"));

		if (request.getParameter("s") == null)
			pageSize = 5;
		else {
			pageSize = Integer.parseInt(request.getParameter("s"));
			if (pageSize <= 5)
				pageSize = 5;
		}

		if (request.getParameter("b") == null)
			blockSize = 5;
		else {
			blockSize = Integer.parseInt(request.getParameter("b"));
			if (blockSize <= 5)
				blockSize = 5;
		}

		if (request.getParameter("cid") == null)
			categoryId = 0;
		else {
			categoryId = Integer.parseInt(request.getParameter("cid"));
			if (categoryId <= 5 && categoryId > 0)
				categoryId = 0;
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("currentPage", currentPage);
		map.put("pageSize", pageSize);
		map.put("blockSize", blockSize);
		map.put("categoryId", categoryId);

		return map;
	}
}
