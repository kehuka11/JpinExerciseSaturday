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
 * Servlet implementation class TaskFix
 */
@WebServlet("/taskfix")
public class TaskFix extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskFix() {
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
		int idf=0;
		Todo todo = map.get(id); 
			if(todo.getId() == id) {
				session.setAttribute("todo", todo);
				idf=id;
			}
		
		session.setAttribute("idf", idf);
		  
		 
		RequestDispatcher rd = request.getRequestDispatcher("/task_fix.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String regname = request.getParameter("regname");
		String contents = request.getParameter("contents");
		String date = request.getParameter("date");
		String chargename=request.getParameter("chargename");
		String bikou=request.getParameter("bikou");
		
		HttpSession session = request.getSession();
		Map<Integer,Todo> map = (Map<Integer,Todo>) session.getAttribute("map");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Todo todo = map.get(id); 
		if(todo.getId() == id) {
			Todo todofix = new Todo(id  ,regname,contents,date,chargename,bikou);
			map.replace(id,todofix);
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/task_list.jsp");
		rd.forward(request, response);
		return;
		
	}

}
