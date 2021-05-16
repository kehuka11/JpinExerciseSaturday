package com.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TopicServlet
 */
@WebServlet("/topic")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicServlet() {
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
		String comment = request.getParameter("comment");
		String name = request.getParameter("name");
		String dai = request.getParameter("dai");
		
		//request.setAttribute("msg", msg);
		HttpSession session = request.getSession();
		List<Topic> list = (List<Topic>) session.getAttribute("list");
		
		if(list == null) {
			list = new ArrayList<Topic>();
		}
		
		Integer id = (Integer) session.getAttribute("id");
		if (id==null) {
			id=0;
		}


		Topic topic = new Topic(id + 1 ,dai,name,comment,null,new Date());
		list.add(topic);
		
		session.setAttribute("list", list);
		session.setAttribute("id", id + 1);
		RequestDispatcher rd = request.getRequestDispatcher("/keiziban.jsp");
		rd.forward(request, response);
		return;
	}

}
