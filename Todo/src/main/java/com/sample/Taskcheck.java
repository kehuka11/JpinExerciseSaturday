package com.sample;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Taskcheck
 */
@WebServlet("/taskcheck")
public class Taskcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Taskcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		Map<Integer,Todo> map = (Map<Integer,Todo>) session.getAttribute("map");
		
		String[] checktask = request.getParameterValues("check");
		Map<Integer,Todo> compmap = (Map<Integer,Todo>) session.getAttribute("compmap");
		
		if(compmap == null) {
			compmap = new TreeMap<Integer,Todo>();
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		int idc = 0;
		try {
		for(String comptask : checktask) {
			idc = Integer.parseInt(comptask);
			Todo comptodo = map.get(idc);
			compmap.put(idc, comptodo);
		
		}
			session.setAttribute("compmap", compmap);
		 
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/task_list.jsp");
		rd.forward(request, response);
		return;
	}

}
