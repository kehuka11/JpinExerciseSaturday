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
 * Servlet implementation class TaskListChange
 */
@WebServlet("/taskchange")
public class TaskListChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskListChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String[] select = request.getParameterValues("list");
		Map<Integer,Todo> map = (Map<Integer,Todo>) session.getAttribute("map");
		Map<Integer,Todo> compmap = (Map<Integer,Todo>) session.getAttribute("compmap");
		
		//int id = Integer.parseInt(request.getParameter("id"));
		
		for(String sel : select) {
			if(sel.equals("complete")) {
				RequestDispatcher rd = request.getRequestDispatcher("/task_list_comp.jsp");
				rd.forward(request, response);
				return;
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/task_list.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
