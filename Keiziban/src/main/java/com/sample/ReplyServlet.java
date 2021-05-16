package com.sample;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/reply")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String addcomment = request.getParameter("addcomment");
		HttpSession session = request.getSession();
		List<Topic> list = (List<Topic>) session.getAttribute("list");
		
		int id = Integer.parseInt(request.getParameter("id"));
		for(Topic topic : list) {
			if(topic.getId() == id) {
				
				topic.setAddcomment(addcomment);
				
				break;
			}
		}
		
		//List<Topic> addList = new ArrayList();
		
		session.setAttribute("list", list);
		
		RequestDispatcher rd =request.getRequestDispatcher("/comment.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
