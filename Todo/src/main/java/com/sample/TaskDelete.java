package com.sample;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TaskDelete
 */
@WebServlet("/taskdelete")
public class TaskDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<Integer,Todo> map = (Map<Integer,Todo>) session.getAttribute("map");
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		int idd=0;
		Todo del = map.get(id); 
			if(del.getId() == id) {
				session.setAttribute("del", del);
				idd=id;
			}
		
		
			session.setAttribute("idd", idd);
		 
		RequestDispatcher rd = request.getRequestDispatcher("/task_delete.jsp");
		rd.forward(request, response);
		return;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<Integer,Todo> map = (Map<Integer,Todo>) session.getAttribute("map");
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Todo todo = map.get(id); 
			if(todo.getId() == id) {
				map.remove(id);
				
			}
		
		
		  
		 
		RequestDispatcher rd = request.getRequestDispatcher("/task_list.jsp");
		rd.forward(request, response);
		return;
	
	}

}
